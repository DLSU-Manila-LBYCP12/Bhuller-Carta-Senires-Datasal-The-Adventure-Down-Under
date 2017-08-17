package game.center.Bhuller;
/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.HeadlessException;
import java.awt.event.KeyEvent;
import java.awt.image.BufferedImage;
import javax.swing.JFrame;
import javax.swing.SwingUtilities;
/**
 *
 * @author Bhuller
 */

public class Tetris extends JFrame {
    
    private BufferedImage off;
    private Tetsam sam = new Tetsam();
    private Color[] colors = { Color.WHITE, Color.YELLOW, Color.PINK, Color.BLUE
            , Color.ORANGE, Color.MAGENTA, Color.RED, Color.CYAN };
    
    public Tetris() throws HeadlessException {
        setSize(400, 400);
        setTitle("Tetris Game");
        setLocationRelativeTo(null);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        off = new BufferedImage(getWidth(), getHeight(), BufferedImage.TYPE_INT_ARGB);
        new Thread(new Runnable() {
            @Override
            public void run() {
                while (true) {
                    if (!sam.go()) {
                        sam.update();
                    }
                    repaint();
                    try {
                        Thread.sleep(200);
                    } catch (InterruptedException ex) { }
                }
            }
        }).start();
    }

    @Override
    public void paint(Graphics g) {
        draw(off.getGraphics());
        g.drawImage(off, 0, 0, null);
    }
    
    public void draw(Graphics g) {
        ((Graphics2D) g).setBackground(getBackground());
        g.clearRect(0, 0, getWidth(), getHeight());
        dsco(g, 210, 120);
        dgri(g, 30, 10);
        dnp(g, 210, 150);
        if (sam.go()) {
            dgo(g);
        }
    }

    private void dsco(Graphics g, int x, int y) {
        g.setColor(getForeground());
        g.drawString("CURRENT SCORE: " + sam.sco(), x, y);
    }
    
    private void dgri(Graphics g, int aa, int bb) {
        int cs = 10;
        for (int row = 4; row < sam.row(); row++) {
            for (int col = 0; col < sam.col(); col++) {
                int x = col * cs + aa;
                int y = row * cs + bb;
                int c = sam.val(col, row);
                g.setColor(Color.GRAY);
                g.fillRect(x, y, cs, cs);
                if (c > 0) {
                    g.setColor(colors[c]);
                    g.fillRect(x, y, cs, cs);
                }
                g.setColor(Color.BLACK);
                g.drawRect(x, y, cs, cs);
            }
        }
    }
    
    private void dnp(Graphics g, int aa, int bb) {
        g.drawString("NEXT PIECE: ", aa, bb);
        int cs = 10;
        for (int row = 0; row < 4; row++) {
            for (int col = 0; col < 4; col++) {
                int x = col * cs + aa;
                int y = row * cs + bb + 5;
                int c = sam.nextval(col, row);
                g.setColor(Color.GRAY);
                g.fillRect(x, y, cs, cs);
                if (c > 0) {
                    g.setColor(colors[c]);
                    g.fillRect(x, y, cs, cs);
                }
                g.setColor(Color.BLACK);
                g.drawRect(x, y, cs, cs);
            }
        }
    }

    public void dgo(Graphics g) {
        g.setColor(Color.RED);
        g.fillRect(80, 130, 180, 100);
        g.setColor(getForeground());
        g.drawRect(80, 130, 180, 100);
        g.drawString("YOU LOST", 140, 165);
        g.drawString("SPACE FOR PLAY", 105, 195);
    }

    @Override
    protected void processKeyEvent(KeyEvent e) {
        if (e.getID() == KeyEvent.KEY_PRESSED) {
            if (sam.go()) {
                if (e.getKeyCode() == 32) {
                    sam.start();
                }
            }
            else {
                switch (e.getKeyCode()) {
                    case 37: sam.move(-1); break;
                    case 39: sam.move(1); break;
                    case 38: sam.rot(); break;
                    case 40: sam.down(); break;
                    case 65: sam.update(); break;
                }
            }
        }
        repaint();
    }
        
    public static void main(String[] args) {
        SwingUtilities.invokeLater(new Runnable() {
            @Override
            public void run() {
                Tetris view = new Tetris();
                view.setVisible(true);
            }
        });
    }
    
}