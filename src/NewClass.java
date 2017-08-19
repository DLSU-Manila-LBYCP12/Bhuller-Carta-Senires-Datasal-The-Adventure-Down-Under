

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
/*
import acm.graphics.*;
import acm.program.*;
import static acm.program.Program.EAST;
import static acm.program.Program.NORTH;
import static acm.program.Program.SOUTH;
import acm.util.ErrorException;
import java.awt.MouseInfo;
import java.awt.event.ActionEvent;
import java.awt.event.MouseEvent;
import javax.swing.JButton;
import javax.swing.JTextField;
import javax.swing.JFrame;
import java.awt.Color;
import java.io.IOException;
import java.util.ArrayList;
import java.util.StringTokenizer;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
import javax.swing.WindowConstants;
import game.center.Bhuller.MyList;

/**
 *
 * @authors : Jashandeep Bhuller - TETRIS, BREAKOUT, MAZE Johann Carta - GUI,
 * FLAPPYBIRD Paulo Senires - SNAKE, PONG
 *
 *//*
public class GameCenter extends GraphicsProgram {

    //START DECLARE    
    GImage application;

    GImage background;

    GImage flappybutton;

    GImage snakebutton;

    GImage pongbutton;

    GImage tetrisbutton;

    GImage breakoutbutton;

    GImage mazebutton;
    
    GImage millionairebutton;

    JTextField username;
    
    String user;
    
    JButton login;
    
    JTextField friend;
    
    GLabel ss1 = new GLabel("");
    GLabel ps1 = new GLabel("");
    GLabel bs1 = new GLabel("");
    GLabel ms1 = new GLabel("");
    GLabel qs1 = new GLabel("");
    GLabel high = new GLabel("");
    
    private Database Database;
    
    private Profile profile;
    
    private Profile dispFriend;
    
    private Thread thread;
    
    JFrame networkframe;
    
    GLabel friends_header;
    
    JButton displayfriends;
    
    ArrayList<ArrayList<String>> friends;
    //END DECLARE
    @Override
    public void init() {
        addMouseListeners();
        setSize(280, 320);
        try {
            application = new GImage("index.png", 0, 0);
        } catch (ErrorException ex) {
            System.out.println("Cannot display image");
        }
        application.setSize(256, 256);
        add(application);
        try {
            Database = new Database();

        } catch (IOException ex) {
            Logger.getLogger(GameCenter.class.getName()).log(Level.SEVERE, null, ex);
        }
        initFriends();
    }

    public void EnterApp(GObject selected) {
        if ((GImage) selected == application) {
            loginPage();
        }
    }

    public void loginPage() {
        removeAll();
        setSize(400, 390);
        try {
            background = new GImage("gradient.jpg", 0, 0);
        } catch (ErrorException ex) {
            System.out.println("Cannot display image");
        }
        background.setSize(400, 400);
        add(background);
        username = new JTextField(20);
        add(username, NORTH);
        login = new JButton("LOGIN");
        add(login, SOUTH);
        addActionListeners();
    }

    public void actionPerformed(ActionEvent e) {
        Profile temp_profile = null;
        temp_profile = Database.getProfile(username.getText());
        if (e.getActionCommand().equals("LOGIN")) {
            //lagyan mo if statement na if may profile tsaka lang makakalogin
            user= username.getText();
            username.setVisible(false);
            login.setVisible(false);
            if (temp_profile != null) {
                    System.out.println("user already exist");
                    profile=temp_profile;
            }
            else{
                    profile = new Profile(username.getText());
                    System.out.println("Add: " + username.getText());
                    
                    Database.addProfile(profile);

                   
            }
           startGameMenu();
        }
        
        
    }

    public void startGameMenu() {
        removeAll();
        ArrayList<String> friendlist = profile.getFriends();
            
        
        try {
            background = new GImage("gradient.jpg", 0, 0);
        } catch (ErrorException ex) {
            System.out.println("Cannot display image");
        }
        background.setSize(900, 500);
        add(background);
        setSize(900, 600);
        try {
            flappybutton = new GImage("flappy.png", 20, 30);
        } catch (ErrorException ex) {
            System.out.println("Cannot display image");
        }
        flappybutton.setSize(100, 100);
        add(flappybutton);
        try {
            snakebutton = new GImage("snake.png", 20, 140);
        } catch (ErrorException ex) {
            System.out.println("Cannot display image");
        }
        snakebutton.setSize(100, 100);
        add(snakebutton);
        try {
            pongbutton = new GImage("pong.jpg", 140, 30);
        } catch (ErrorException ex) {
            System.out.println("Cannot display image");
        }
        pongbutton.setSize(100, 100);
        add(pongbutton);
        try {
            millionairebutton = new GImage("millionaire.png", 140, 140);
        } catch (ErrorException ex) {
            System.out.println("Cannot display image");
        }
        millionairebutton.setSize(100, 100);
        add(millionairebutton);
        try {
            tetrisbutton = new GImage("tetris.jpg", 670, 250);
        } catch (ErrorException ex) {
            System.out.println("Cannot display image");
        }
        tetrisbutton.setSize(70, 25);
        add(tetrisbutton);
        try {
            breakoutbutton = new GImage("breakout.jpg", 260, 30);
        } catch (ErrorException ex) {
            System.out.println("Cannot display image");
        }
        breakoutbutton.setSize(100, 100);
        add(breakoutbutton);
        try {
            mazebutton = new GImage("maze.jpg", 670, 220);
        } catch (ErrorException ex) {
            System.out.println("Cannot display image");
        }
        mazebutton.setSize(70, 25);
        add(mazebutton);
        GLabel name = new GLabel("Welcome "+user);
        name.setColor(Color.DARK_GRAY);
        name.setFont("Arial-bold-20");
        add(name,450,40);
        GLabel games = new GLabel("Apps and Games: ");
        games.setColor(Color.DARK_GRAY);
        games.setFont("Arial-bold-16");
        add(games,10,22);
        GLabel high = new GLabel(user+"'s Highscores per game: ");
        high.setColor(Color.DARK_GRAY);
        high.setFont("Arial-bold-20");
        add(high,10,350);
        //displaycurrentplayerscore()
        GLabel ss = new GLabel("Snake: "+profile.getsnakeScore());
        ss.setColor(Color.DARK_GRAY);
        ss.setFont("Arial-bold-14");
        add(ss,10,380);
        GLabel ps = new GLabel("Pong: "+profile.getpong());
        ps.setColor(Color.DARK_GRAY);
        ps.setFont("Arial-bold-14");
        add(ps,ss.getX()+10+ss.getWidth(),380);
        GLabel bs = new GLabel("Breakout: "+profile.getbreak());
        bs.setColor(Color.DARK_GRAY);
        bs.setFont("Arial-bold-14");
        add(bs,ps.getX()+10+ps.getWidth(),380);
        GLabel qs = new GLabel("Quiz: "+profile.getquiz());
        qs.setColor(Color.DARK_GRAY);
        qs.setFont("Arial-bold-14");
        add(qs,bs.getX()+10+bs.getWidth(),380);
        GLabel ms = new GLabel("Math: "+profile.getmath());
        ms.setColor(Color.DARK_GRAY);
        ms.setFont("Arial-bold-14");
        add(ms,qs.getX()+10+qs.getWidth(),380);
        friend = new JTextField(10);
        add(friend, EAST);
        
        friends_header = new GLabel("Friends: ");
        friends_header.setFont("Arial-16");
        add(friends_header, name.getX() , name.getY()+40);
        for (int i = 0; i < friendlist.size(); i++) 
        {
            System.out.println("reached friend iterator");
            GLabel friend_name = new GLabel(fixName(friendlist.get(i)));
            add(friend_name, friends_header.getX(), friends_header.getY() + (friends_header.getHeight() + 10) * ((i) % 6) + friends_header.getHeight() + 10);
        }
        
    }

    public void playGames(GObject gselected) {
        
        if ((GImage) gselected == flappybutton) {
                  

            
        } else if ((GImage) gselected == snakebutton) {
            Snake snake = new Snake();
            JFrame frame = new JFrame("Snake");
            frame.setVisible(true);
            frame.setSize(398, 600);
            frame.getContentPane().add(snake);
            snake.setProfile(profile);
            snake.start();
        } else if ((GImage) gselected == pongbutton) {
            Pong pong = new Pong();
            JFrame frame = new JFrame("Pong");
            frame.setVisible(true);
            frame.setSize(480, 620);
            frame.getContentPane().add(pong);
            pong.setProfile(profile);
            pong.start();
        } else if ((GImage) gselected == breakoutbutton) {
            JFrame frame = new JFrame("Breakout");
            frame.setVisible(true);
            BreakOutGame breakout = new BreakOutGame();
            frame.setSize(420, 630);
            frame.getContentPane().add(breakout);
            breakout.setProfile(profile);
            breakout.start();
        }
        else if ((GImage) gselected == millionairebutton) {
            JFrame frame = new JFrame("Millionaire");
            frame.setVisible(true);
            Billionaire billionaire = new Billionaire();
            frame.setSize(915, 800);
            frame.getContentPane().add(billionaire);
            billionaire.setProfile(profile);
            billionaire.start();
        }
        else if ((GImage) gselected == mazebutton) {
            
            if (!friend.getText().equals("")) {
                System.out.println("Add Friend: " + friend.getText());
                Profile temp_profile2 = null;
                temp_profile2 = Database.getProfile(friend.getText());
                if (temp_profile2 != null) {

                    String weight;
                    
                    profile.addFriend(friend.getText(),Integer.parseInt("1"));
                    
                    startGameMenu();
                } 

            }
        
        } else if ((GImage) gselected == tetrisbutton) {
                displayfriendscore();
        }
        
            saveProfiles();
        
            Logger.getLogger(GameCenter.class.getName()).log(Level.SEVERE, null, ex);
        
    }
    public void displayfriendscore(){
        
        String disp = friend.getText();
        dispFriend = Database.getProfile(friend.getText());
        high.setLabel(disp+"'s Highscores per game: ");
        high.setColor(Color.DARK_GRAY);
        high.setFont("Arial-bold-20");
        add(high,10,410);
        ss1.setLabel("Snake: "+dispFriend.getsnakeScore());
        ss1.setColor(Color.DARK_GRAY);
        ss1.setFont("Arial-bold-14");
        add(ss1,10,430);
        ps1.setLabel("Pong: "+dispFriend.getpong());
        ps1.setColor(Color.DARK_GRAY);
        ps1.setFont("Arial-bold-14");
        add(ps1,ss1.getX()+10+ss1.getWidth(),430);
        bs1.setLabel("Breakout: "+dispFriend.getbreak());
        bs1.setColor(Color.DARK_GRAY);
        bs1.setFont("Arial-bold-14");
        add(bs1,ps1.getX()+10+ps1.getWidth(),430);
        qs1.setLabel("Quiz: "+dispFriend.getquiz());
        qs1.setColor(Color.DARK_GRAY);
        qs1.setFont("Arial-bold-14");
        add(qs1,bs1.getX()+10+bs1.getWidth(),430);
        ms1.setLabel("Math: "+dispFriend.getmath());
        ms1.setColor(Color.DARK_GRAY);
        ms1.setFont("Arial-bold-14");
        add(ms1,qs1.getX()+10+qs1.getWidth(),430);
        
    }
    private void saveProfiles() throws IOException {
        Database.saveProfiles();
    }
    @Override
    public void mouseClicked(MouseEvent e) {
        double x, y;
        x = e.getX();
        y = e.getY();
        EnterApp(getElementAt(x, y));
        playGames(getElementAt(x, y));
    }
    
    public GObject eclicked() {
        int x1 = MouseInfo.getPointerInfo().getLocation().x;
        int y1 = MouseInfo.getPointerInfo().getLocation().y;
        return getElementAt(x1 - 10, y1 - 10);
    }
    private void initFriends(){
        friends = new ArrayList<>();
        for (int i = 1; i != 5; i++) {
            for (int j = 5; j != 5; j++) {
                friends.add(Database.getProfiles());
            }
        }
        
    }
     private String fixName(String name) {
        StringTokenizer token = new StringTokenizer(name, " ");
        String temp_name = "";
        while (token.hasMoreTokens()) {
            String word = token.nextToken();
            temp_name = temp_name.concat(word.substring(0, 1).toUpperCase() + word.substring(1));
            temp_name += " ";
        }
        return temp_name;
    }
    /**
     * @param args the command line arguments
     *//*
    public static void main(String[] args) {
        GameCenter app = new GameCenter();

        app.start(args);// TODO code application logic here
    }

}
*/