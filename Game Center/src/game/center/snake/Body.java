/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package game.center.snake;

import acm.graphics.G3DRect;
import acm.graphics.GCanvas;
import acm.graphics.GPoint;
import acm.graphics.GRect;
import java.awt.Color;

/**
 *
 * @author PauloSenires
 */
public class Body  {
    GRect body ;
            private GCanvas canvas ;
    final int length = 20;
    public Body(int x, int y, GCanvas canvas){
        body = new GRect(x*length, y*length, length, length);
        this.canvas = canvas;
        body.setColor(Color.GREEN);
        body.setFilled(true);
        body.setFillColor(Color.GREEN);
    }
    public void add(){
        canvas.add(body);
    }
    public GPoint getLocation(){
        return body.getLocation();
    }
    public void setLocation(GPoint newLoc){
        body.setLocation(newLoc);
    }
}
