/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package SecondGame;

import java.awt.Color;
import javax.swing.JPanel;

/**
 *
 * @author Bhuller
 */
public class Player extends JPanel{
    int a, b;
	
    public Player() {
    	this.setBackground(Color.getHSBColor(0.3f, 0.3f, 1));
    	this.setSize(Maze.size, Maze.size);
    }

    public void moveLeft() {
    	if(a > 0 && Maze.map[a-1][b] == 1){
	    	this.setLocation(this.getX()-25, this.getY());
	    	a--;
    	}
    }

    public void moveRight() {
    	if(a < Maze.col-1 && Maze.map[a+1][b] == 1){
	    	this.setLocation(this.getX()+25, this.getY());
	    	a++;
    	}
    }

    public void moveUp() {
    	if(b > 0 && Maze.map[a][b-1] == 1){
	    	this.setLocation(this.getX(), this.getY()-25);
	    	b--;
    	}
    }

    public void moveDown() {
    	if(b < Maze.row-1 && Maze.map[a][b+1] == 1){
	    	this.setLocation(this.getX(), this.getY()+25);
	    	b++;
    	}
    }
}
