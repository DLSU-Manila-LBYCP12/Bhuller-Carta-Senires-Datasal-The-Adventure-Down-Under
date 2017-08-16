/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package FirstGame;
import java.awt.Canvas;
import java.awt.Color;
import static java.awt.Color.BLACK;
import java.awt.Font;
import java.awt.Graphics2D;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.awt.image.BufferStrategy;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import FirstGame.FinalGame;
/**
 *
 * @author Bhuller
 */
public class Game extends Canvas implements Runnable,KeyListener{
    
    public static final int wid = 400;
    public static final int hit = 565;
    
    public static void main(String args[]){
        JFrame fra = new JFrame("MAIN"); 
        fra.setSize(wid,hit);
        fra.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        fra.setLocationRelativeTo(null);
        fra.setResizable(false);
        fra.setLayout(null);
        
        Gett.lod();
        
        JMenuBar bar = new JMenuBar();
        bar.setBounds(0, 0, wid-1, 25);
        
        JMenu ff =new JMenu ("Menu");
        
        JMenuItem ng = new JMenuItem("Start New Game");
        ng.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                System.out.println("Beginning New Game.....");
            }
        });
    
        JMenuItem hs = new JMenuItem("High Score");
        hs.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                int hs =0;
                final JFrame ring = new JFrame ("Scores");
                ring.setSize(200, 200);
                ring.setLayout(null);
                ring.setLocationRelativeTo(null);
                ring.setAlwaysOnTop(true);
                JLabel scor = new JLabel("New high score is " + hs);
                scor.setBounds(0, 0, 200, 50);
                
                JButton oo = new JButton("BACK");
                oo.setBounds(50, 120, 100, 30);
                oo.addActionListener(new ActionListener(){
                    public void actionPerformed(ActionEvent e){
                        ring.dispose();
                    }
                });
                ring.add(scor);
                ring.add(oo);
                ring.setResizable(false);
                ring.setVisible(true);
            }
        });
        
        JMenuItem ex = new JMenuItem("Exit");
        ex.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                System.out.println("Closing....");
                System.exit(0);
            }
        });
        Game dd = new Game();
        
        dd.setBounds(0, 0, wid, hit-25);
        bar.add(ff);
        fra.add(bar);
        fra.add(dd);
        ff.add(ng);
        ff.add(hs);
        ff.add(ex);
        fra.setVisible(true);
        dd.start();
       
    }
    
    public void init(){
        
    }
    public void run(){
        boolean samp = true;
        while (samp){
            update();
            BufferStrategy nn = getBufferStrategy();
            if (nn == null){
                createBufferStrategy(3);
                continue;
            }
            Graphics2D j = (Graphics2D) nn.getDrawGraphics();
            ren(j);
            nn.show();
        }
        
    }

    public void ren(Graphics2D j){
        j.setColor(Color.BLACK);
        j.fillRect(0,0,wid,hit);
        j.setColor(Color.WHITE);
        j.setFont(new Font ("Arial", Font.BOLD, 30));
        j.drawString("GAME", 145, 190);
    }
    public void update(){
        
    }
    public void start(){
        Thread t = new Thread(this);
        t.setPriority(Thread.MAX_PRIORITY);
        t.start();
    }
    @Override
    public void keyTyped(KeyEvent ke) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void keyPressed(KeyEvent ke) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void keyReleased(KeyEvent ke) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    
  
    
}
