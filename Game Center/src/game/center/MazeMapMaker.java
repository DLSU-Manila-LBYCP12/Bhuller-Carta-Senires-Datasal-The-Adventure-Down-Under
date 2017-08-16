/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package SecondGame;


import java.awt.Color;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.PrintWriter;
import java.util.ArrayList;

import javax.swing.JFrame;
import javax.swing.JOptionPane;
/**
 *
 * @author Bhuller
 */
public class MazeMapMaker extends JFrame{
    static int row = 20;
    static int col = 20;
    int psize = 25;
    static int map[][] = new int[col][row];
    ArrayList<String> mapList = new ArrayList<String>();
    int level = 0;
    boolean levelex = false;
    
    public MazeMapMaker(){
    	getMapList();
    	getLevelChoice();
    	if(level != -1){
	        loadMap();
	        this.setResizable(false);
	        this.setSize((col*psize)+50, (row*psize)+70);
	        this.setTitle("Maker");
	        this.setLayout(null);
	        
	        this.addWindowListener(new WindowAdapter(){
	            public void windowClosing(WindowEvent e) {
	                saveMap();
	                new MainMenu();
	            }
	        });
	        
	        this.setLocationRelativeTo(null);
	        
	        for(int i = 0; i < col; i++){
	            for(int j = 0; j < row; j++){
	            	MapMakerTile t = new MapMakerTile(i, j);
	                t.setSize(psize-1, psize-1);
	                t.setLocation((i*psize)+23, (j*psize)+25);
	                if(map[i][j] == 0){
	                    t.setBackground(Color.GRAY);
	                }else{
	                    t.setBackground(Color.WHITE);
	                }
	                
	                t.setVisible(true);
	                
	                this.add(t);
	            }
	        }
	        this.setVisible(true);
    	}else{
    		new MainMenu();
    	}
    }
    
    public void getMapList(){
    	for(int i = 0; i < 99; i++){
    		File map = new File("Level "+i);
    		if(map.exists()){
    			System.out.println("Level "+i+" exists");
    			mapList.add("Level "+i+".map");
    			levelex = true;
    		}
    	}
    }
    
    public void getLevelChoice(){
    	if(levelex){
	    	String map[] = new String[99];
	    	mapList.toArray(map);
	    	map[mapList.size()] = "New Stage: ";
	    	String choice = (String)JOptionPane.showInputDialog(null, "Choose which Level: ", "Maze Level Selector", JOptionPane.QUESTION_MESSAGE, null, map, map[0]);
	    	System.out.println(choice);
	    	if(choice != null && !choice.equals("New Stag: ")){
	    		level = Integer.parseInt((choice.replace("Level ", "").replace(".map", "")));
	    	}else if(choice == null){
	    		level = -1;
	    	}else{
	    		level = mapList.size();
	    	}
    	}
    }
    
    public void saveMap(){
        try{
        PrintWriter wri = new PrintWriter("Level "+level+".map", "UTF-8");
        for(int y = 0; y < col; y++){
            for(int x = 0; x < row; x++){
                wri.print(map[x][y]);
            }
            wri.print("\r\n");
        }
        wri.close();
        }catch(Exception e){
            e.printStackTrace();
        }
    }
    
    public void loadMap(){
        try{
            BufferedReader b = new BufferedReader(new FileReader("Level "+level+".map"));
            StringBuilder s = new StringBuilder();
            String wo = b.readLine();

            while (wo != null) {
                s.append(wo);
                s.append(System.lineSeparator());
                wo = b.readLine();
            }
            String mapStr = s.toString();
            
            int cou = 0;
            for(int i = 0; i < col; i++){
                for(int j = 0; j < row; j++){
                    String mapChar = mapStr.substring(cou, cou+1);
                    if(!mapChar.equals("\r\n") && !mapChar.equals("\n")&& !mapChar.equals("\r")){  
                        map[j][i] = Integer.parseInt(mapChar);
                    }else{
                        j--;
                    }
                    cou++;
                }
            }
        }catch(Exception e){
            System.out.println("Error");
            for(int i = 0; i < col; i++){
                for(int j = 0; j < row; j++){
                    map[j][i] = 0;
                }
            }
        }
    }
}
