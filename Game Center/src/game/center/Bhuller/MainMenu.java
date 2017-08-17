/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package game.center.Bhuller;


import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import java.util.ArrayList;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
/**
 *
 * @author Bhuller
 */
public class MainMenu {
     JFrame Men = new JFrame("Maze");
    JButton Sta = new JButton("Play");
    JButton Ex = new JButton("Exit");
    JButton make = new JButton("Map Maker");
    JLabel labe = new JLabel("Maze Game");
    ArrayList<String> mlist = new ArrayList<String>();
    JComboBox<String> lvlList;
    int menuw = 100; 
    int menuht = 30;
    int menuver = 460; 
    int WIDTH = 490;
    int HEIGHT = 530;
    
            
	public MainMenu() {
    	getMapList();
    	lvlList = new JComboBox<String>(mlist.toArray(new String[mlist.size()]));
    	
        
        Men.setResizable(false);
        Men.setSize(WIDTH, HEIGHT);
        Men.setLayout(null);
        Men.setLocationRelativeTo(null);
        Men.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        
      
        Sta.setSize(menuw,menuht);
        Sta.setLocation(10, menuver);
        Men.add(Sta);
        Sta.addActionListener(new ActionListener(){

			@Override
			public void actionPerformed(ActionEvent arg0) {
				new Maze(lvlList.getSelectedItem().toString());
				Men.setVisible(false);
			}
        	
        });	
        make.setSize(menuw,menuht);
        make.setLocation(120, menuver);
        Men.add(make);
        make.addActionListener(new ActionListener(){

			@Override
			public void actionPerformed(ActionEvent e) {
				new MazeMapMaker();
				Men.setVisible(false);
			}
        	
        });
        
        lvlList.setSize(menuw+35, menuht);
        lvlList.setLocation(230, menuver);
        Men.add(lvlList);
        
        Ex.setSize(menuw,menuht);
        Ex.setLocation(375,menuver);
        Men.add(Ex);
        Ex.addActionListener(new ActionListener(){

			@Override
			public void actionPerformed(ActionEvent e) {
	            System.exit(0);
			}
        });
        
        labe.setBounds((WIDTH-412)/2, 25, 412, 412);
        labe.setVisible(true);
        Men.add(labe);
        Men.setVisible(true);
    }

    static boolean levelsExistAlready = false;

    public void getMapList(){
    	for(int i = 0; i < 99; i++){
    		File map = new File("./Level "+i+".map");
    		if(map.exists()){
    			System.out.println("Level "+i+" exists");
    			mlist.add("Level "+i+".map");
    			levelsExistAlready = true;
    		}
    	}
    }
}
