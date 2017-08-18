/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
import acm.program.*;
import static acm.program.Program.EAST;
import java.awt.event.ActionEvent;
import javax.swing.JButton;

/**
 *
 * @author Johann Carta
 */
public class Billionaire extends Program implements BillionaireConstants{

    //Start Declaration
    private BillionaireCanvas canvas;
    
    JButton A;
    
    JButton B;
    
    JButton C;
    
    JButton D;
    
    JButton cancel;
    //End Declaration
    
    @Override
    public void run()
    {
        A = new JButton("Choose A");
        add(A, EAST);
        B = new JButton("Choose B");
        add(B, EAST);
        C = new JButton("Choose C");
        add(C, EAST);
        D = new JButton("Choose D");
        add(D, EAST);
        cancel = new JButton("Remove");
        add(cancel, EAST);
        addActionListeners();
        canvas = new BillionaireCanvas();
        add(canvas);
        setSize(915, 800);
        canvas.initializeCanvas();
        playGame();
    }
    
    public void playGame()
    {
        
    }
    
    public void actionPerformed(ActionEvent e)
    {
        if(e.getActionCommand().equals("Choose A"))
        {
            canvas.Right();
        }
        else if(e.getActionCommand().equals("Remove"))
        {
            canvas.Reset();
        }
    }
    
    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        new Billionaire().start(args);
// TODO code application logic here
    }
    
}
