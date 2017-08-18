/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

import acm.graphics.*;
import acm.program.*;
import java.awt.*;
import acm.util.*;
import javax.swing.*;

/**
 *
 * @author Johann Carta
 */
public class BillionaireCanvas extends GCanvas implements BillionaireConstants{
    
    //Start Declaration
    GRect background;
    
    GLabel welcome;
    
    GImage image;
    
    GLabel mock;

    GLabel answer;
    //End   Declaration
    
    public void initializeCanvas()
    {
        DisplayGame();
    }
    
    public void DisplayGame()
    {
        background = new GRect(0, 0, 800, 800);
        background.setColor(Color.BLUE);
        background.setFilled(true);
        add(background);
        welcome = new GLabel("Who wants to be a Billionaire" , 200, 50);
        welcome.setFont("Copperplate-30");
        welcome.setColor(Color.black);
        add(welcome);
            try
            {
                image = new GImage("index.png", 250, 70);
            }
            catch(ErrorException ex)
            {
                  System.out.println("Cannot display image");      
            }
        image.setSize(256,150);
        add(image);
        mock = new GLabel("DATASAL NERDS ONLY!", 265, 240);
        mock.setColor(Color.white);
        mock.setFont("Helvetica-20");
        add(mock);
    }
    
    public void Right()
    {
        answer = new GLabel("Your Answer is answer");
        answer.setColor(Color.white);
        answer.setFont("Helvetica-20");
        answer.setLocation(50, 600);
        add(answer);
    }
    
    public void Reset()
    {
        remove(answer);
    }
}
