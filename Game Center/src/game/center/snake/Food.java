/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package game.center.snake;

import acm.graphics.GCanvas;
import acm.graphics.GPoint;
import acm.graphics.GRect;
import java.awt.Color;

/**
 *
 * @author PauloSenires
 */
public class Food {
     GRect food ;
            private GCanvas canvas ;
    final int length = 20;
    public Food(int x, int y, GCanvas canvas){
        food = new GRect(x*length, y*length, length, length);
        this.canvas = canvas;
        food.setColor(Color.RED);
        food.setFilled(true);
        food.setFillColor(Color.RED);
    }
    public void add(){
        canvas.add(food);
    }
    public void remove(){
        canvas.remove(food);
    }
    public GPoint getLocation(){
        return food.getLocation();
    }
    public void setLocation(GPoint newLoc){
        food.setLocation(newLoc);
    }
}
