/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

import acm.graphics.*;
import acm.program.*;
import java.awt.*;
import acm.util.*;
import static acm.util.JTFTools.pause;
import javax.swing.*;

/**
 *
 * @author Johann Carta
 */
public class BillionaireCanvas extends GCanvas implements BillionaireConstants{
    
    //Start Declaration
    GRect background;
    
    GLabel welcome;
    
    GLabel Aa;
    
    GLabel Bb;
    
    GLabel Cc;
    
    GLabel Dd;
    
    GImage image;
    
    GLabel mock;

    GLabel answer;
    
    GLabel question;
    
    GLabel choice;
    //End   Declaration
    
    public void initializeCanvas()
    {
        DisplayGame();
    }
    
    public void DisplayGame()
    {
        background = new GRect(0, 0, 800, 800);
        background.setColor(Color.getHSBColor(0.7005f, 0.4904f, 0.5184f));
        background.setFilled(true);
        add(background);
        welcome = new GLabel("Who wants to be a Billionaire" , 200, 50);
        welcome.setFont("Copperplate-30");
        welcome.setColor(Color.black);
        add(welcome);
            try
            {
                image = new GImage("millionaire.png", 250, 70);
            }
            catch(ErrorException ex)
            {
                  System.out.println("Cannot display image");      
            }
        image.setSize(150,150);
        add(image);
        mock = new GLabel("DATASAL NERDS ONLY!", 265, 240);
        mock.setColor(Color.white);
        mock.setFont("Helvetica-20");
        add(mock);
        Aa = new GLabel("A");
        Aa.setFont("Helvitica-20");
        Aa.setColor(Color.white);
        Aa.setLocation(700, 400);
        add(Aa);
        
        Bb = new GLabel("B");
        Bb.setFont("Helvitica-20");
        Bb.setColor(Color.white);
        Bb.setLocation(700, 430);
        add(Bb);
        
        Cc = new GLabel("C");
        Cc.setFont("Helvitica-20");
        Cc.setColor(Color.white);
        Cc.setLocation(700, 460);
        add(Cc);
        
        Dd = new GLabel("D");
        Dd.setFont("Helvitica-20");
        Dd.setColor(Color.white);
        Dd.setLocation(700, 490);
        add(Dd);
    }
    
    public void Right()
    {
        answer = new GLabel("Your Answer is correct.");
        answer.setColor(Color.white);
        answer.setFont("Helvetica-20");
        answer.setLocation(50, 600);
        add(answer);
        
    }
    
    public void showQuestion(String msg)
    {
        question = new GLabel(msg);
        question.setFont("Helvetica-20");
        question.setColor(Color.RED);
	double x = 35;
	double y = getHeight() - 400;
	add(question, x, y);
    }
    
    public void showChoices(String msg)
    {
        choice = new GLabel(msg);
        choice.setFont("Helvetica-20");
        choice.setColor(Color.white);
        double x = getWidth()/2 - choice.getWidth()*3/4;
	double y = getHeight() - 300;
        add(choice, x, y);
    }
    
    public void Reset()
    {
        remove(answer);
        remove(question);
        remove(choice);
    }
}