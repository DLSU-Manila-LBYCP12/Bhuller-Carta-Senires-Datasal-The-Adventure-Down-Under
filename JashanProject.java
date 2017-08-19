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

    private IntToPost wer = new IntToPost();;
 Profile profile;
    GLabel mm = new GLabel("Welcome to the Computing Game");
    GLabel nn = new GLabel("Compute for the Following");
    Double res1;
    Double res2;
    Double res3;
    Double res4;
    Double res5;
    int score=0;
    int cor =0;
    
    public void display()
    {
       println("Welcome to the Computing Game.");
       println("Solve for the following items:");
       println("\n1. 2*10/5*20");
       Double cho1 = readDouble("Answer: ");
       Double n = cho1;
       String inpute = "2*10/5*20";
      
       res1 = wer.posttoans(wer.inttoposst(inpute));
       if(n.equals(res1)){
           score = score + 20;
           cor = cor +1;
       }
       
        println(score);
       
       println("\n2. 5*7-24/8");
       Double cho2 = readDouble("Answer: ");
       String inpu = "5*7-24/8";
      
       res2 = wer.posttoans(wer.inttoposst(inpu));
       if(cho2.equals(res2))
       {
           score = score + 20;
            cor = cor +1;
       }
      
       
       
       println("\n3. 4+1*9/9-1");
       Double cho3 = readDouble("Answer: ");
       String inp = "4+1*9/9-1";
      
       res3 = wer.posttoans(wer.inttoposst(inp));
        if(cho3.equals(res3))
       {
           score = score + 20;
            cor = cor +1;
       }
       
       println("\n4. 2+8*6/3-1");
       Double cho4 = readDouble("Answer: ");
       String in = "4+1*9/9-1";
       
       res4 = wer.posttoans(wer.inttoposst(in));
       if(cho4.equals(res4))
       {
           score = score + 20;
            cor = cor +1;
       }
     
       
       
       println("\n5. 2+9/3+10-5+1*20");
       Double cho5 = readDouble("Answer: ");
        String i = "2+9/3+10-5+1*20";
     
       res5 = wer.posttoans(wer.inttoposst(i));
        if(cho5.equals(res5))
       {
           score = score + 20;
            cor = cor +1;
       }
       
        println("\nFinal Score is " + score);
        println("\nYou got " + cor  + " out of 5 questions.");
        profile.setmath(score);
    }
    
    public void run(){
        display();
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
