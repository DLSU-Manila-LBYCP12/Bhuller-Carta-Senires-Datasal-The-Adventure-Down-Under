/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */


import acm.graphics.G3DRect;
import acm.graphics.GCanvas;
import acm.graphics.GPoint;
import acm.graphics.GRect;
import static acm.util.JTFTools.pause;
import java.awt.Color;

/**
 *
 * @author PauloSenires
 */
public class Body {

    GRect body;
    private GCanvas canvas;
    final int length = 20;
    private int size = 0;

    public Body(int x, int y, GCanvas canvas) {
        body = new GRect(x * length, y * length, length, length);
        this.canvas = canvas;

        body.setColor(Color.GRAY);
        body.setFilled(true);
        body.setFillColor(Color.GREEN);

    }

    public void add() {
        
        canvas.add(body);
        size++;

    }

    public int getSize() {
        return size;
    }

    public GPoint getLocation() {
        return body.getLocation();
    }

    public void setLocation(GPoint newLoc) {
        body.setLocation(newLoc);
    }

    public void dead() {
        int y = 0;
        while (y < 8) {
            body.setFillColor(Color.red);
            pause(200);
            body.setFillColor(Color.green);
            pause(200);
            y++;
        }

    }
}
