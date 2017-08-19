/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
import acm.graphics.GImage;
import acm.graphics.*;
import acm.program.*;
import java.awt.*;
import acm.util.*;
import static acm.util.JTFTools.pause;
import javax.swing.*;
import acm.graphics.GLabel;
import acm.graphics.GObject;
import acm.program.*;
import static acm.program.Program.EAST;
import acm.util.ErrorException;
import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.MouseEvent;
import java.util.Stack;
import javax.swing.JButton;
import javax.swing.SwingUtilities;

/**
 *
 * @author Johann Carta
 */
public class Billionaire extends GraphicsProgram implements BillionaireConstants{

    //Start Declaration
    private BillionaireCanvas canvas;
    
    Stack<String> stackq = new Stack<>();
    
    Stack<String> stacka = new Stack<>();
    
    MyLinkedList<String> questionlist = new MyLinkedList<>();
    
    MyLinkedList<String> choiceslist = new MyLinkedList<>();
    
    JButton A;
    
    public int qcounter = 1;
    
    Profile profile;
    
    public int score = 100;
    
    JButton B;
    
    JButton C;
    
    JButton D;
    
    GImage Aa;
    
    GImage Bb;
    
    GImage Cc;
    
    GImage Dd;
    
    GRect background;
    
    GLabel welcome;
    
    /*GLabel Aa;
    
    GLabel Bb;
    
    GLabel Cc;
    
    GLabel Dd;*/
    
    GImage image;
    
    GLabel mock;

    GLabel answer;
    
    GLabel question;
    
    GLabel choice;
    
    JButton cancel;
    //End Declaration
    
    @Override
    public void run()
    {
        addMouseListeners();
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
        try
            {
                Aa = new GImage("A.png", 700, 400);
            }
            catch(ErrorException ex)
            {
                  System.out.println("Cannot display image");      
            }
        add(Aa);
        try
            {
                Bb = new GImage("B.png", 700, 430);
            }
            catch(ErrorException ex)
            {
                  System.out.println("Cannot display image");      
            }
        add(Bb);
        try
            {
                Cc = new GImage("C.png", 700, 460);
            }
            catch(ErrorException ex)
            {
                  System.out.println("Cannot display image");      
            }
        add(Cc);
        try
            {
                Dd = new GImage("D.png", 700, 490);
            }
            catch(ErrorException ex)
            {
                  System.out.println("Cannot display image");      
            }
        add(Dd);
        A = new JButton("Choose A");
        //add(A, EAST);
        B = new JButton("Choose B");
        //add(B, EAST);
        C = new JButton("Choose C");
        //add(C, EAST);
        D = new JButton("Choose D");
        //add(D, EAST);
        cancel = new JButton("Remove");
        //add(cancel, EAST);
        //addActionListeners();
        //canvas = new BillionaireCanvas();
        //add(canvas);
        setSize(915, 800);
        //canvas.initializeCanvas();
        initinit();
        playGame();
    }
    
    public void initinit()
    {
        questionlist.add(1, "What is the time complexity of indexing operations in a binary search tree.");
        questionlist.add(1,"What is the time complexity of dequeue operation in a queue.");
        questionlist.add(1,"What is the time complexity of enqueue operation in a queue.");
        questionlist.add(1,"What is the time complexity of indexing operations in a dynamic array.");
        questionlist.add(1,"What is the time complexity of indexing operations in a linear array.");
        questionlist.add(1,"push(1), push(2), pop(), push(1), push(2), pop(), pop(). what is the value returned by peek().");
        questionlist.add(1,"Which of the following stack operations could result to stack underflow.");
        questionlist.add(1,"Which of the following stack operations could result to stack overflow.");
        questionlist.add(1,"Which of the following stack operations could result to queue underflow.");
        questionlist.add(1,"Which of the following stack operations could result to queue overflow.");
        choiceslist.add(1, "A. O(logn) B. O(n^2) C. O(1) D. O(nlogn) ");
        choiceslist.add(1,"A. O(1) B. O(n^2) C. O(n) D. O(nlogn) ");
        choiceslist.add(1,"A. O(1) B. O(n^2) C. O(n) D. O(nlogn) ");
        choiceslist.add(1,"A. O(1) B. O(n^2) C. O(n) D. O(nlogn) ");
        choiceslist.add(1,"A. O(1) B. O(n^2) C. O(n) D. O(nlogn) ");
        choiceslist.add(1,"A. 1 B. 2 C. null D. 0");
        choiceslist.add(1,"A. pop B. initStack C. push D. isEmpty");
        choiceslist.add(1,"A. push B. initStack C. pop D. isEmpty");
        choiceslist.add(1,"A. dequeue B. Front C. enqueue D. isEmpty");
        choiceslist.add(1,"A. enqueue B. Rear C. dequeue D. Front");
    }
    
    public void playGame()
    {
        switch(qcounter)
        {
            case 1: 
                showQuestion(questionlist.get(1));
                showChoices(choiceslist.get(1));
                break;
            case 2: 
                Reset();
                showQuestion(questionlist.get(2));
                showChoices(choiceslist.get(2));
                break;
            case 3: 
                Reset();
                showQuestion(questionlist.get(3));
                showChoices(choiceslist.get(3));
                break;
            case 4: 
                Reset();
                showQuestion(questionlist.get(4));
                showChoices(choiceslist.get(4));
                break;
            case 5: 
                Reset();
                showQuestion(questionlist.get(5));
                showChoices(choiceslist.get(5));
                break;
                case 6: 
                Reset();
                showQuestion(questionlist.get(6));
                showChoices(choiceslist.get(6));
                break;
                case 7: 
                Reset();
                showQuestion(questionlist.get(7));
                showChoices(choiceslist.get(7));
                break;
                case 8: 
                Reset();
                showQuestion(questionlist.get(8));
                showChoices(choiceslist.get(8));
                break;
                case 9: 
                Reset();
                showQuestion(questionlist.get(9));
                showChoices(choiceslist.get(9));
                break;
            case 10:
                java.awt.Window dialog = SwingUtilities.windowForComponent(A);
                dialog.dispose();
        }
    }
    
    @Override
    public void mouseClicked(MouseEvent e) {
        double x, y;
        x = e.getX();
        y = e.getY();
        next(getElementAt(x, y));
    }
    
    public void next(GObject selected)
    {
        if((GImage) selected == Aa)
        {
            Right();
            qcounter = qcounter + 1;
            if(qcounter == 9)
            {
                endgame();
            }else{
            playGame();
            }
        } 
        else if((GImage) selected == Bb)
        {
            Reset();
            for(int i = 9; i > qcounter; i--)
            {
                questionlist.remove(i);
                choiceslist.remove(i);
            }
            initinit();
            qcounter = 1;
            score = score - 10;
            playGame();
        }
        else if((GImage) selected == Cc)
        {
            Reset();
            for(int i = 9; i > qcounter; i--)
            {
                questionlist.remove(i);
                choiceslist.remove(i);
            }
            initinit();
            qcounter = 1;
            score = score - 10;
            playGame();
        }
        else if((GImage) selected == Dd)
        {
            Reset();
            for(int i = 9; i > qcounter; i--)
            {
                questionlist.remove(i);
                choiceslist.remove(i);
            }
            initinit();
            qcounter = 1;
            score = score - 10;
            playGame();
        }
                
        
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
    
    public void Right()
    {
        answer = new GLabel("Your Answer is correct.");
        answer.setColor(Color.white);
        answer.setFont("Helvetica-20");
        answer.setLocation(50, 600);
        add(answer);
        
    }
    
    public GObject eclicked() {
        int x1 = MouseInfo.getPointerInfo().getLocation().x;
        int y1 = MouseInfo.getPointerInfo().getLocation().y;
        return getElementAt(x1 - 10, y1 - 10);
    }
    
    /*public void actionPerformed(ActionEvent e)
    {
        if(e.getActionCommand().equals("Choose A"))
        {
            canvas.Right();
            qcounter = qcounter + 1;
            if(qcounter == 5)
            {
                endgame();
            }else{
            playGame();
            }
        }
        else if(e.getActionCommand().equals("Choose B"))
        {
            canvas.Reset();
            for(int i = 5; i > qcounter; i--)
            {
                stacka.pop();
                stackq.pop();
            }
            stackq.push("What is the time complexity of indexing operations in a binary search tree.");
        stackq.push("What is the time complexity of dequeue operation in a queue.");
        stackq.push("What is the time complexity of enqueue operation in a queue.");
        stackq.push("What is the time complexity of indexing operations in a dynamic array.");
        stackq.push("What is the time complexity of indexing operations in a linear array.");
        stacka.push("A. O(logn) B. O(n^2) C. O(1) D. O(nlogn) ");
        stacka.push("A. O(1) B. O(n^2) C. O(n) D. O(nlogn) ");
        stacka.push("A. O(1) B. O(n^2) C. O(n) D. O(nlogn) ");
        stacka.push("A. O(1) B. O(n^2) C. O(n) D. O(nlogn) ");
        stacka.push("A. O(1) B. O(n^2) C. O(n) D. O(nlogn) ");
            qcounter = 1;
            score = score - 10;
            playGame();
        }
        else if(e.getActionCommand().equals("Choose C"))
        {
            canvas.Reset();
            for(int i = 5; i > qcounter; i--)
            {
                stacka.pop();
                stackq.pop();
            }
            stackq.push("What is the time complexity of indexing operations in a binary search tree.");
        stackq.push("What is the time complexity of dequeue operation in a queue.");
        stackq.push("What is the time complexity of enqueue operation in a queue.");
        stackq.push("What is the time complexity of indexing operations in a dynamic array.");
        stackq.push("What is the time complexity of indexing operations in a linear array.");
        stacka.push("A. O(logn) B. O(n^2) C. O(1) D. O(nlogn) ");
        stacka.push("A. O(1) B. O(n^2) C. O(n) D. O(nlogn) ");
        stacka.push("A. O(1) B. O(n^2) C. O(n) D. O(nlogn) ");
        stacka.push("A. O(1) B. O(n^2) C. O(n) D. O(nlogn) ");
        stacka.push("A. O(1) B. O(n^2) C. O(n) D. O(nlogn) ");
            qcounter=1;
            score = score - 10;
            playGame();
        }
        else if(e.getActionCommand().equals("Choose D"))
        {
            canvas.Reset();
            for(int i = 5; i > qcounter; i--)
            {
                stacka.pop();
                stackq.pop();
            }
            stackq.push("What is the time complexity of indexing operations in a binary search tree.");
        stackq.push("What is the time complexity of dequeue operation in a queue.");
        stackq.push("What is the time complexity of enqueue operation in a queue.");
        stackq.push("What is the time complexity of indexing operations in a dynamic array.");
        stackq.push("What is the time complexity of indexing operations in a linear array.");
        stacka.push("A. O(logn) B. O(n^2) C. O(1) D. O(nlogn) ");
        stacka.push("A. O(1) B. O(n^2) C. O(n) D. O(nlogn) ");
        stacka.push("A. O(1) B. O(n^2) C. O(n) D. O(nlogn) ");
        stacka.push("A. O(1) B. O(n^2) C. O(n) D. O(nlogn) ");
        stacka.push("A. O(1) B. O(n^2) C. O(n) D. O(nlogn) ");
            qcounter=1;
            score = score - 10;
            playGame();
        }
    }*/
    
    public void endgame()
    {
        removeAll();
        profile.setquiz(score);
        showQuestion("Your score is: " + score);
        
    }
    
    public void setProfile(Profile p){
        profile=p;
    }
    
    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        new Billionaire().start(args);
// TODO code application logic here
    }
    
}
