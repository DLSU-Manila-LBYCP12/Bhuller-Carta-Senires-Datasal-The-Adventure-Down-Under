/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package game.center.Bhuller;
import game.center.Bhuller.Platform;
import game.center.Bhuller.Objectt;
import game.center.Bhuller.Time;
import java.applet.Applet;
import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.util.Timer;
/**
 *
 * @author Bhuller
 */
public class FinalGame extends Applet implements KeyListener{
    private static final int HEIGTH = 680, WIDTH = 640, size = 32;
	private static final int xoff = 20, yoff = 20, nextpx = 360, nextpy = 40;
	private static Objectt curpiece, nextPiece;
	private static Platform boar;
	private static int lev = 1;
	private static double scor;
	private static int lines;
	private final static Color[] color = {Color.WHITE, Color.ORANGE, Color.GREEN, Color.CYAN, Color.MAGENTA, Color.BLUE, Color.YELLOW, Color.RED};
	private static Time timerr;
	private static Timer timer;
	private static boolean gameo = false;
	
	
	public void init() {
		setSize(640, 680);
		curpiece = new Objectt();
		nextPiece = new Objectt();
		boar = new Platform();
		timer = new Timer();
		timerr = new Time(this);
		timer.scheduleAtFixedRate(timerr, 1000, 1000);
		setFocusable(true);
		this.requestFocusInWindow();
		this.addKeyListener(this);
		repaint();
	}
	
	
	public void paint(Graphics g) {

		Graphics2D g2d = (Graphics2D)g;
		g2d.setFont(new Font("Comic Sans MS", Font.BOLD, 20));
		g2d.setPaint(Color.GRAY);
		g2d.fillRect(0, 0, WIDTH, HEIGHT);
		g2d.setPaint(Color.WHITE);
		g2d.drawString("Next Piece:", nextpx, nextpy-10);
		g2d.drawString("Score: "+(int)scor, nextpx, 390);
		g2d.drawString("Lines: "+lines, nextpx, 430);
		g2d.drawString("Level: "+lev, nextpx, 470);
		drawBoard(g2d);
		drawPiece(g2d);
		drawNextPiece(g2d);
		if(gameo) {
			timerr.cancel();
			g2d.setPaint(Color.GRAY);
			g2d.fillRect(xoff + 2*size, yoff + 8*size, 6*size, 4*size);
			g2d.setPaint(Color.WHITE);
			g2d.drawString("GAME OVER", xoff + 3*size, yoff + 10*size - 10);
			g2d.drawString("Score: "+(int)scor, xoff + 3*size, yoff + 11*size - 10);
			this.removeKeyListener(this.getKeyListeners()[0]);
		}

	}

	private void drawPiece(Graphics2D aa) {
		int x = curpiece.getx();
		int y = curpiece.gety();
		for(int j=0; j<Objectt.size; j++)
			for(int i=0; i<Objectt.size; i++) {
				if(curpiece.getBlock(j, i) !=0) {
					aa.setPaint(color[curpiece.getBlock(j, i)]);
					aa.fillRect(xoff+(x+i)*size, size+(y+j)*size, size, size);
				}
			}
	}

	private void drawNextPiece(Graphics2D g2d) {
		for(int j=0; j<Objectt.size; j++)
			for(int i=0; i<Objectt.size; i++) {
				g2d.setPaint(color[nextPiece.getBlock(j, i)]);
				g2d.fillRect(nextpx+i*size, nextpy+j*size, size, size);
			}
	}

	private void drawBoard(Graphics2D g2d) {
		for(int j=0; j<Platform.hit; j++)
			for(int i=0; i<Platform.wid; i++) {
				g2d.setPaint(color[boar.gblock(j, i)]);
				g2d.fillRect(xoff+i*size, yoff+j*size, size, size);
			}
				
	}

	@Override
	public void keyPressed(KeyEvent e) {

	}

	@Override
	public void keyReleased(KeyEvent e) {

		int key = e.getKeyCode();
		switch(key) {
			case KeyEvent.VK_UP: if(boar.cmove(curpiece, 0, -1))
									curpiece.rot();
								 break;
			case KeyEvent.VK_DOWN: if(boar.cmove(curpiece, 0, 1)) {
										curpiece.down();
										scor += 10 ;
									}
									else {
										upboard();
									}
								   break;
			case KeyEvent.VK_LEFT: if(boar.cmove(curpiece, -1, 0))
										curpiece.left();
			 						break;
			case KeyEvent.VK_RIGHT: if(boar.cmove(curpiece, 1, 0))
										curpiece.right();
			   						break;
			case KeyEvent.VK_SPACE: while(boar.cmove(curpiece, 0, 1)) {
										curpiece.down();
										scor += 10 ;
									}
									upboard();
									break;
		}
		repaint();
	}

	
	public void keyTyped(KeyEvent e) {
		
	}

	public void timer() {
		if(boar.cmove(curpiece, 0, 1))
			curpiece.down();
		else {
			upboard();
		}
		repaint();
	}

	private void upboard() {
		boar.stor(curpiece);
		curpiece = nextPiece;
		nextPiece = new Objectt();
		int num = boar.delposLines();
		lines += num;
		scor += 1;
		lev = (int) (scor/1000) + 1;
		if(!boar.cmove(curpiece, 0, 1)) {
			gameo = true;
		}
	}
}
