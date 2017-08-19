/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */


import acm.graphics.*;
import acm.program.*;
import acm.util.*;
import java.awt.Color;
import java.awt.event.MouseAdapter; 
import java.awt.event.MouseEvent; 
import java.awt.event.MouseListener;
import static java.lang.Boolean.TRUE;

/**
 *
 * @author Bhuller
 */
public class Piccgame extends GraphicsProgram{
    Profile profile;
    private int wid=30;
    private int height=30;
    int score;

 
    public static final int APPLICATION_WIDTH = 500;
    public static final int APPLICATION_HEIGHT = 500;
    
    public void init(){
  addd();
  
       
    }
     public synchronized void addMouseListener(MouseListener l) {
        super.addMouseListener(l);
    }
 
    GImage zero = new GImage("unnamed.jpg");
   GImage img = new GImage("Sample.jpg");
    GLabel mm = new GLabel("Congratulations, you gatch me");
     GRect recc = new GRect(300,50);
   
     
     private void addd()  {
         img.setSize(500, 500);
         add(img,0,0);
     zero.setSize(20, 20);
     add(zero, 150, 250);
     zero.addMouseListener(new MouseAdapter() {
        public void mouseClicked(MouseEvent e) {
       
        }

        @Override
        public void mousePressed(MouseEvent e) {
        
        }

        @Override
        public void mouseReleased(MouseEvent e) {
            recc.setColor(Color.yellow);
            recc.setFilled(TRUE);
            recc.setFillColor(Color.white);
            add(recc,100, 160);
        mm.setFont("Arial-20");
        mm.setColor(Color.black);
            add(mm,100,200);
            score = 200;
        }
        });   
     //profile.setpic(score);
    }
    
     public void setProfile(Profile p){
        profile=p;
    }
     
      
    public static void main(String[] args) {
        new Piccgame().start(args);
        // TODO code application logic here
    } 
}