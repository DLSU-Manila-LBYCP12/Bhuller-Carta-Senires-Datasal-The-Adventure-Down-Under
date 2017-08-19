/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

import acm.graphics.*;
import acm.program.*;
import java.awt.Color;
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
 * @author Rosemarie Ty
 */
public class JashanProject extends ConsoleProgram{

    Profile profile;
    Queueee<Integer> im1 = new Queueee<>();
    Queueee<Integer> im2 = new Queueee<>();
    GLabel mm = new GLabel("Welcome to the Computing Game");
    GLabel nn = new GLabel("Compute for the Following");
    int score;
    int temp1;
    int temp2;
    
    @Override
    public void run()
    {
        im1.create();
        im2.create();
     im1.enqueue(300);
     im1.enqueue(437);
     im1.enqueue(35);
     im1.enqueue(110);
     im1.enqueue(99);
     
     im2.enqueue(40);
     im2.enqueue(96);
     im2.enqueue(16);
     im2.enqueue(55);
     im2.enqueue(44);
     display();
    }
    
    public void display()
    {
       println("Welcome to the Computing Game.");
       println("Solve for the following items:");
       println("\n1. " + im1.first() + "*" + im2.first() + " = ");
       Integer cho1 = readInt("Answer: ");
       
       if(cho1 == im1.first() * im2.first())
       {
           score = score + 20;
       }
       im1.dequeue();
       im2.dequeue();
       
       println("\n2. " + im1.first() + "-" + im2.first() + " = ");
       Integer cho2 = readInt("Answer: ");
       if(cho2 == im1.first() - im2.first())
       {
           score = score + 20;
       } 
       im1.dequeue();
       im2.dequeue();
       
       println("\n3. " + im1.first() + "+" + im2.first() + " = ");
       Integer cho3 = readInt("Answer: ");
       if(cho3 == im1.first() + im2.first())
       {
           score = score + 20;
       }
       im1.dequeue();
       im2.dequeue();
       
       println("\n4. " + im1.first() + "/" + im2.first() + " = ");
       Integer cho4 = readInt("Answer: ");
       if(cho4 == im1.first() / im2.first())
       {
           score = score + 20;
       }
       im1.dequeue();
       im2.dequeue();
       
       
       println("\n5. " + im1.first() + "%" + im2.first() + " = ");
       Integer cho5 = readInt("Answer: ");
        if(cho5 == im1.first() % im2.first())
       {
           score = score + 20;
       }
        profile.setmath(score);
        println("Final Score is " + score);
        pause(800);
        exit();
    }
    
    public void setProfile(Profile p){
        profile=p;
    }
    /**;
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        new JashanProject().start(args);// TODO code application logic here
    }
    
}
