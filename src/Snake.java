/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

import acm.graphics.*;
import acm.program.GraphicsProgram;
import acm.util.RandomGenerator;
import java.awt.Color;
import java.awt.event.KeyEvent;
import java.util.ArrayList;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.util.StringTokenizer;

import java.io.FileNotFoundException;

import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.*;
import game.center.Bhuller.MyList;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author PauloSenires
 */
public class Snake extends GraphicsProgram {

    private RandomGenerator rgen = RandomGenerator.getInstance();
    private Food food;
    final int length = 20;
    private ArrayList<Body> body = new ArrayList<>();
    private int velx = -1;
    public int vely = 0;
    private int size = 4;
    private double speed = 200;
    private int score = 0;
    private Profile profile;
    private Database database;
    private String path = System.getProperty("user.dir") + "\\snake.txt";

    public void init() {

        File f = new File(path);
        FileReader source = null;
        try {
            source = new FileReader(f);
        } catch (FileNotFoundException ex) {
            Logger.getLogger(Snake.class.getName()).log(Level.SEVERE, null, ex);
        }
        BufferedReader br = new BufferedReader(source);
        MyList<Integer> List = new MyList<Integer>();
        List.createList();

        String temp = null;
        
        while (temp != null) {

            
            try {
                temp = br.readLine();
                List.add(1, Integer.parseInt(temp));
            } catch (IOException ex) {
                Logger.getLogger(Snake.class.getName()).log(Level.SEVERE, null, ex);
            }

        
    }
    /* removeAll();
        
        score=0;
        speed=200;
        velx = -1;
        vely = 0;
        size = 4;
        run();*/
}
public void run() {
        
        initGUI();
        initBody();
        addKeyListeners();
        initFood();
        gameLoop();

    }
    public void setProfile(Profile p){
        profile=p;
    }
    /**
     * @param args the command line arguments
     */
    @Override
        public void keyPressed(KeyEvent e) {
        if (e.getKeyChar() == 'a') {
            if (velx == 0) {
                velx = -1;
                vely = 0;
            }
        } else if (e.getKeyChar() == 'd') {
            if (velx == 0) {
                velx = 1;
                vely = 0;
            }
        } else if (e.getKeyChar() == 'w') {
            if (vely == 0) {
                vely = -1;
                velx = 0;
            }
        } else if (e.getKeyChar() == 's') {
            if (vely == 0) {
                vely = 1;
                velx = 0;
            }
        }
    }

    public static void main(String[] args) {
        // TODO code application logic here
        new Snake().start();
    }

    private void initGUI() {
        this.setSize(398, 600);
        for (int i = 1; i <= 20; i++) {
            GLine gridy = new GLine(i * length, 0, i * length, length * 20);
            add(gridy);
            GLine gridx = new GLine(0, i * length, length * 20 + length * 2, i * length);
            add(gridx);
        }
        
        
        GLabel Instructions = new GLabel("Use a to go left, w to go up, s to go down, and d to go right");
        Instructions.setColor(Color.black);
        add(Instructions, 10, 490);
    }

    private void initBody() {
        for (int i = 0; i < size; i++) {
            Body init = new Body(i + 10, 10, this.getGCanvas());
            init.add();
            body.add(init);
        }
    }

    private boolean collision() {
        Body head = body.get(0);
        for (int i = 1; i < size; i++) {
            if ((head.getLocation().getX() == body.get(i).getLocation().getX()) && (head.getLocation().getY() == body.get(i).getLocation().getY())) {
                body.get(i).dead();
                return true;
            }
        }
        return false;
    }

    private void gameLoop() {
        
        Body head = body.get(0);
        
        while (!collision()) {
        GLabel Score = new GLabel("Score: " + score);
        Score.setFont("Serif-bold-16");
        Score.setColor(Color.black);
        add(Score, 10, 470);
            pause(speed);
            update();
            System.out.println("food " + food.getLocation());
            System.out.println("body " + body.get(0).getLocation());
            if ((head.getLocation().getX() == food.getLocation().getX()) && (head.getLocation().getY() == food.getLocation().getY())) {
                food.remove();
                food = new Food(rgen.nextInt(0, 18), rgen.nextInt(0, 18), this.getGCanvas());
                food.add();
                size++;
                Body init = new Body(size + 10, 1000, this.getGCanvas());
                speed = speed * 0.9901;
                init.add();
                body.add(init);
                System.out.println("eaten");
                score=score+10;
                
                
            }
            if (head.getLocation().getX() < -1) {
                GPoint newLoc = new GPoint(18 * length, head.getLocation().getY());
                head.setLocation(newLoc);
            }
            if (head.getLocation().getY() < -1) {
                GPoint newLoc = new GPoint(head.getLocation().getX(), 19 * length);
                head.setLocation(newLoc);
            }
            if (head.getLocation().getX() >= length * 19) {
                GPoint newLoc = new GPoint(-1 * length, head.getLocation().getY());
                head.setLocation(newLoc);
            }
            if (head.getLocation().getY() >= length * 20) {
                GPoint newLoc = new GPoint(head.getLocation().getX(), -1 * length);
                head.setLocation(newLoc);
            }
            Score.setVisible(false);
        }
        GLabel Over = new GLabel("Gameover. You scored: "+score+" points");
        Over.setFont("Serif-bold-20");
        Over.setColor(Color.red);
        
        add(Over, 50, 450);
        if(score>profile.getsnakeScore()){
        profile.setsnakeScore(score);
        }
    }

    private void update() {
        for (int i = body.size() - 1; i > 0; i--) {
            body.get(i).setLocation(body.get(i - 1).getLocation());

        }
        GPoint newHeadLocation = body.get(0).getLocation();
        newHeadLocation.setLocation(newHeadLocation.getX() + velx * length, newHeadLocation.getY() + vely * length);
        body.get(0).setLocation(newHeadLocation);
        
    }

    private void initFood() {
        food = new Food(rgen.nextInt(1, 18), rgen.nextInt(1, 18), this.getGCanvas());
        food.add();
    }
    public String toString() {
        summary = name + " (" + snakeScore + pongScore + breakScore + quizScore + mathScore +"): ";
        for (int i = 0; i < friends.size() - 1; i++) {
            summary = summary.concat((String) friends.get(i) + ", ");
        }
        summary = summary.concat((String) friends.get(friends.size() - 1));

        return summary;
    }
    public String save() {
        String summary =  snakeScore + System.lineSeparator()+ pongScore + System.lineSeparator()+ breakScore + System.lineSeparator()+ quizScore + System.lineSeparator()+ mathScore + System.lineSeparator();
        if (friends.size() > 0) {
            for (int i = 0; i < friends.size(); i++) {
                summary = summary.concat(friends.get(i) + " " + weights.get(i) + System.lineSeparator());
            }
        }
        summary = summary.concat("end profile");

        return summary;
    }
}
