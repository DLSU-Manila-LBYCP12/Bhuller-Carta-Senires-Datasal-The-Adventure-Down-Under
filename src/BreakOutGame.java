/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */


import game.center.Bhuller.MyList;
import acm.graphics.*;
import acm.program.*;
import acm.util.*;

import java.applet.*;
import java.awt.*;
import java.awt.event.*;
/**
 *
 * @Jashandeep S. Bhuller
 */
public class BreakOutGame extends GraphicsProgram{
    
    	/** Width and height of application window in pixels */
	public static final int APPLICATION_WIDTH = 400;
	public static final int APPLICATION_HEIGHT = 600;

	/** Dimensions of game board (usually the same) */
	private static final int WIDTH = APPLICATION_WIDTH;
	private static final int HEIGHT = APPLICATION_HEIGHT;

	/** Dimensions of the paddle */
	private static final int PADDLE_WIDTH = 60;
	private static final int PADDLE_HEIGHT = 10;

	/** Offset of the paddle up from the bottom */
	private static final int PADDLE_Y_OFFSET = 30;

	/** Number of bricks per row */
	private static final int NBRICKS_PER_ROW = 10;
        private Profile profile;
	/** Number of rows of bricks */
	private static final int NBRICK_ROWS = 10;

	/** Separation between bricks */
	private static final int BRICK_SEP = 4;

	/** Width of a brick */
	private static final int BRICK_WIDTH =
	  (WIDTH - (NBRICKS_PER_ROW - 1) * BRICK_SEP) / NBRICKS_PER_ROW;

	/** Height of a brick */
	private static final int BRICK_HEIGHT = 8;

	/** Radius of the ball in pixels */
	private static final int BALL_RADIUS = 10;

	/** Offset of the top brick row from the top */
	private static final int BRICK_Y_OFFSET = 70;

        
        private static final double TIME_DELAY = 3;
	/** Number of turns */
	private static final int NTURNS = 3;
        
        private static final double BRICK_X_OFFSET = 0.5 * (WIDTH - (NBRICKS_PER_ROW - 1)*BRICK_SEP -BRICK_WIDTH * NBRICKS_PER_ROW);
        
        private GRect padd;
        
        
	/* Method: init() */
	/** Sets up the Breakout program. */
	public void setup() {
            drawBrickWall();
            paddle();
            dBall();/* You fill this in, along with any subsidiary methods */
	}

    private int brickco;
    private int scor;
    private int fscore;
   
    /// Create the list of food (memory allocation)
    private MyList<Integer> hscore = new MyList<Integer>();
   
    
	/* Method: run() */
	/** Runs the Breakout program. */
	public void run() {
          hscore.createList();
          
            scor=0;
            trun=3;
            for (int a=0; a<3;a++){
                    setup();
                    GLabel score = new GLabel ("SCORE: " + scor);
                    score.setColor(Color.BLACK);
                    add (score,300,50); 
                    startg(score);
			if(brickco == 0) {
				ballls.setVisible(false);
				win();
                                waitForClick();
				break;
			}
                        if(brickco > 0) {
                            removeAll();
                            trun--;
			}
                        if(trun == 0) {
                        Gameo();
                        if(scor>profile.getbreak()){
                        profile.setbreak(scor);
                        }
                        waitForClick();
                        removeAll();
                
		} 
            }     
        
        }
        

        public void setProfile(Profile p){
        profile=p;
        }
        private void drawBrickWall() {
            for (int row = 0; row < NBRICK_ROWS; row++){
                for (int brickNumb = 0; brickNumb < NBRICKS_PER_ROW; brickNumb++){
                double a = BRICK_X_OFFSET + brickNumb * (BRICK_WIDTH + BRICK_SEP);
                double b = (BRICK_Y_OFFSET) +   (BRICK_HEIGHT + BRICK_SEP)*row ;
                
                GRect brick = new GRect (a, b, BRICK_WIDTH, BRICK_HEIGHT);
                brick.setColor(Color.BLACK);
                brick.setFilled(true);
                
                switch(row){
                case 0:
                case 1:
                brick.setFillColor(Color.RED);
                break;
                case 2:
                case 3:
                brick.setFillColor(Color.ORANGE);
                break;
                case 4:
                case 5:
                brick.setFillColor(Color.YELLOW);
                break;
                case 6:
                case 7:
                brick.setFillColor(Color.GREEN);
                break;
                case 8:
                case 9:
                brick.setFillColor(Color.CYAN);
                }
                add(brick);
                }
                
            }
        }
        
        private void paddle(){
            double x = WIDTH- PADDLE_WIDTH;
            double y = HEIGHT - PADDLE_Y_OFFSET - PADDLE_HEIGHT;
            padd = new GRect(PADDLE_WIDTH, PADDLE_HEIGHT);
            padd.setFilled(true);
            add( padd, 0.5*x,y ); 
            addMouseListeners();
        }
        
        private boolean isMouseXInsideWindow(int A){
        return ((A > 0.5 * PADDLE_WIDTH)
        && (A < (WIDTH - 0.5 * PADDLE_WIDTH)));
        }
        
        public void mouseMoved(MouseEvent me){
            
            if (isMouseXInsideWindow(me.getX()))
            padd.setLocation(me.getX()-0.5 * PADDLE_WIDTH,
            padd.getY());
            
        }
        private GOval ballls;
        private void dBall() {
		double x = getWidth()/2 - BALL_RADIUS;
		double y = getHeight()/2 - BALL_RADIUS;
		ballls = new GOval(x, y, BALL_RADIUS, BALL_RADIUS);
		ballls.setFilled(true);
                ballls.setFillColor(Color.BLUE);
		add(ballls);
	}
        
        private void startg(GLabel score) {
		GLabel nemo = new GLabel ("LOLOL");
                nemo.setLabel("LIVES:"+trun);
                add(nemo,20,20);
                waitForClick();
		ballv();
                brickco=100;
		while (true) {
			mball(score);
			if (ballls.getY() >= getHeight()) {
				break;
			}
			if(brickco == 0) {
                            hscore.add(1, scor);
                            break;
			}
		}
	}
        private double velx, vely;
        private RandomGenerator rang = RandomGenerator.getInstance();
        private static final int del =6;
        private void ballv(){
            vely = 2.0;
            velx = rang.nextDouble(1.0, 3.0);
		if (rang.nextBoolean(0.5)) {
			velx = -velx; 
		}
        }
        
        private void mball(GLabel score){
        ballls.move(velx,vely);
        
        if ((ballls.getX() - velx <= 0 && velx < 0 )|| (ballls.getX() + velx >= (getWidth() - BALL_RADIUS*2) && velx>0)) {
		velx = -velx;
	}
        if ((ballls.getY() - vely <= 0 && vely < 0 )) {
			vely = -vely;
	}
        
        
        GObject collider = getCollidingObject();
        if (collider == padd) {
            vely = -vely;			
	}
        else if (collider != null) {
            remove(collider);
            brickco--;
            scor++;
            score.setLabel("Score: " + scor);
            vely = -vely;
	}
        else{
        if(ballls.getY() >= getHeight() - PADDLE_Y_OFFSET - PADDLE_HEIGHT - BALL_RADIUS*2 && ballls.getY() < getHeight() - PADDLE_Y_OFFSET - PADDLE_HEIGHT - BALL_RADIUS*2  ) {
	vely = -vely*1.005;	
	} 
        }
	pause (del);
        }
        
        private GObject getCollidingObject() {
		
		if((getElementAt(ballls.getX(), ballls.getY())) != null) {
	         return getElementAt(ballls.getX(), ballls.getY());
	      }
		else if (getElementAt( (ballls.getX() + BALL_RADIUS*2), ballls.getY()) != null ){
	         return getElementAt(ballls.getX() + BALL_RADIUS*2, ballls.getY());
	      }
		else if(getElementAt(ballls.getX(), (ballls.getY() + BALL_RADIUS*2)) != null ){
	         return getElementAt(ballls.getX(), ballls.getY() + BALL_RADIUS*2);
	      }
		else if(getElementAt((ballls.getX() + BALL_RADIUS*2), (ballls.getY() + BALL_RADIUS*2)) != null ){
	         return getElementAt(ballls.getX() + BALL_RADIUS*2, ballls.getY() + BALL_RADIUS*2);
	      }
		else{
	         return null;
	      }
	}
        private int trun=NTURNS;
        private void Gameo() {
                int a=0;
                
		GLabel ko = new GLabel ("YOU LOST");
		ko.setColor(Color.RED);
		add (ko,getWidth()/2-20, 40);
                GLabel High = new GLabel ("HIGH SCORES");
                add(High, getWidth()/2-High.getWidth()/2, getHeight()/2-100);
                
                if(hscore.size()!=0){
                for(int i=1; i<=hscore.size();i++ ){
                    if(scor>=hscore.get(i)){
                        if(hscore.size()==5){
                            hscore.remove(5);
                        }
                            hscore.add(i,scor);
                            a++;
                            break;   
                    }    
                }
                    if(a==0)
                    hscore.add(hscore.size()+1,scor);   
                }
                else{
                hscore.add(1,scor);
                }
                for(int i = 1; i <= hscore.size(); i++){
                   GLabel num = new GLabel("#"+ i +" " + hscore.get(i));
                   add(num, (getWidth() - num.getWidth())/2, getWidth()/2 + i * 20); 
                }
                trun--;
                
	}

        
         private void win() {
		int a=0;
                
		GLabel ko = new GLabel ("YOU WON");
		ko.setColor(Color.RED);
		add (ko,getWidth()/2-20, 40);
                GLabel High = new GLabel ("HIGH SCORES");
                add(High, getWidth()/2-High.getWidth()/2, getHeight()/2-100);
                if(hscore.size()!=0){
                for(int i=1; i<=hscore.size();i++ ){
                    if(scor>=hscore.get(i)){
                        if(hscore.size()==5){
                            hscore.remove(5);
                        }
                            hscore.add(i,scor);
                            a++;
                            break;   
                    }    
                }
                    if(a==0)
                    hscore.add(hscore.size()+1,scor);   
                }
                else{
                hscore.add(1,scor);
                }
                for(int i = 1; i <= hscore.size(); i++){
                   GLabel num = new GLabel("#"+ i +" " + hscore.get(i));
                   add(num, (getWidth() - num.getWidth())/2, getWidth()/2 + i * 20); 
                }
                trun--;
                
	}
         
         
        
        public static void main(String[] args) {
        // TODO code application logic her
        new BreakOutGame().start(args);
    }    
}
