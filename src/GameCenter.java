

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
import acm.graphics.*;
import acm.program.*;
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

/**
 *
 * @authors : Jashandeep Bhuller - TETRIS, BREAKOUT, MAZE Johann Carta - GUI,
 * FLAPPYBIRD Paulo Senires - SNAKE, PONG
 *
 */
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

    JTextField username;
    String user;
    JButton login;
    JTextField friend;
    private Database Database;
    private Profile profile;
    private Thread thread;
    private Network Network;
    JFrame networkframe;
    GLabel friends_header;

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
            // You fill this in
            Database = new Database();

        } catch (IOException ex) {
            Logger.getLogger(GameCenter.class.getName()).log(Level.SEVERE, null, ex);
        }
        networkframe = new JFrame("network graph");
        networkframe.setVisible(false);
        networkframe.setDefaultCloseOperation(WindowConstants.DO_NOTHING_ON_CLOSE);
        networkframe.setSize(600, 700);

        Network = new Network(networkframe);
        networkframe.add(Network);
        initNework();
        Network.displayNodes();
        Network.displayConnections();
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

                   
                    profile.profile_node = Network.createNode(profile.getName());
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
        background.setSize(900, 400);
        add(background);
        setSize(900, 390);
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
            tetrisbutton = new GImage("tetris.jpg", 140, 140);
        } catch (ErrorException ex) {
            System.out.println("Cannot display image");
        }
        tetrisbutton.setSize(100, 100);
        add(tetrisbutton);
        try {
            breakoutbutton = new GImage("breakout.jpg", 260, 30);
        } catch (ErrorException ex) {
            System.out.println("Cannot display image");
        }
        breakoutbutton.setSize(100, 100);
        add(breakoutbutton);
        try {
            mazebutton = new GImage("maze.jpg", 670, 120);
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
        friend = new JTextField(10);
        add(friend, EAST);
        
        friends_header = new GLabel("Friends: ");
        friends_header.setFont("Arial-16");
        add(friends_header, name.getX() , name.getY()+40);
        for (int i = 0; i < friendlist.size(); i++) {
                System.out.println("reached friend iterator");
                GLabel friend_name = new GLabel(fixName(friendlist.get(i)));
                add(friend_name, friends_header.getX(), friends_header.getY() + (friends_header.getHeight() + 10) * ((i) % 6) + friends_header.getHeight() + 10);
            }
        
    }

    public void playGames(GObject gselected) {
        
        if ((GImage) gselected == flappybutton) {
                    if (networkframe.isVisible()) {
                networkframe.setVisible(false);
            } else {
                networkframe.setVisible(true);

            }
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
        } else if ((GImage) gselected == mazebutton) {
            
            if (!friend.getText().equals("")) {
                System.out.println("Add Friend: " + friend.getText());
                Profile temp_profile2 = null;
                temp_profile2 = Database.getProfile(friend.getText());
                if (temp_profile2 != null) {

                    String weight;
                    JFrame weightFrame = new JFrame("Weight");
                    weight = JOptionPane.showInputDialog(weightFrame, "How close are you from 1-5? 5 being the largest");
                    
                    profile.addFriend(friend.getText(),Integer.parseInt(weight));
                    temp_profile2.addFriend(profile.getName(),Integer.parseInt(weight));
                    profile.profile_node.connect(temp_profile2.profile_node, Integer.parseInt(weight));
                    temp_profile2.profile_node.connect(profile.profile_node, Integer.parseInt(weight));
                    Network.createEdge(profile.profile_node, temp_profile2.profile_node, Integer.parseInt(weight));
                    Network.displayConnections();
                    startGameMenu();
                } 

            }
        
        } else if ((GImage) gselected == tetrisbutton) {

        }
        updateNetwork();
        try {
            saveProfiles();
        } catch (IOException ex) {
            Logger.getLogger(GameCenter.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    public void updateNetwork() {
        Network.displayNodes();
        Network.displayConnections();
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
     private void initNework() {
        Profile profile;
        ArrayList<Profile> profiles = Database.profiles;
        for (int i = 0; i < profiles.size(); i++) {
            profiles.get(i).profile_node = Network.createNode(profiles.get(i).getName());
            System.out.println("node " + profiles.get(i).getName() + " created");

        }
        System.out.println("all nodes created");

        for (int i = 0; i < profiles.size(); i++) {
            ArrayList<String> friends = profiles.get(i).getFriends();
            for (int j = 0; j < friends.size(); j++) {
                profile = Database.getProfile(friends.get(j));
                profile.profile_node.connect(profiles.get(i).profile_node);
                int weight;

                weight = profiles.get(i).weights.get(j);
                System.out.println("Edge weight = " + weight);
                Network.createEdge(profile.profile_node, profiles.get(i).profile_node, weight);
            }
            System.out.println("exited inner for loop");
        }

        System.out.println("all nodes connected");
        Network.displayConnections();
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
     */
    public static void main(String[] args) {
        GameCenter app = new GameCenter();

        app.start(args);// TODO code application logic here
    }

}
