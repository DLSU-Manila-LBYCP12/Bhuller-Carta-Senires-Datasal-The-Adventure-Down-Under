/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package SecondGame;


import java.awt.Color;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.io.BufferedReader;
import java.io.FileReader;

import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
/**
 *
 * @author Bhuller
 */
public class Maze extends JFrame{
     public static int row = 20;
    public static int col = 20;
    public static int size = 25;
    public static int map[][] = new int[col][row];
    public static int endLevelLoc;
    Player p;
    
    public Maze(String str){
        loadMap(str);
        this.setResizable(false);
        this.setSize((col*size+50), (row*size)+70);
        this.setTitle("Maze");
        this.setLayout(null);
        
        this.addKeyListener(new KeyListener(){

			@Override
			public void keyPressed(KeyEvent e) {
				int key = e.getKeyCode();
				
				revalidate();
				repaint();
				
				//Player movement
				if(key == KeyEvent.VK_W){
					p.moveUp();
				}
				if(key == KeyEvent.VK_A){
					p.moveLeft();
				}
				if(key == KeyEvent.VK_S){
					p.moveDown();
				}
				if(key == KeyEvent.VK_D){
					p.moveRight();
				}
				
				if(p.a == col-1 && p.b == endLevelLoc){
					JOptionPane.showMessageDialog(null, "Level Complete", "End Game", JOptionPane.INFORMATION_MESSAGE);
					dispose();
					new MainMenu();
				}
			}

			@Override
			public void keyReleased(KeyEvent arg0) {
				// TODO Auto-generated method stub
				
			}

			@Override
			public void keyTyped(KeyEvent arg0) {
				// TODO Auto-generated method stub
				
			}
        	
        });
        
        this.addWindowListener(new WindowAdapter(){
            public void windowClosing(WindowEvent e) {
                //System.out.println((columns*panelSize)+50+"-"+((rows*panelSize)+70));
                System.exit(0);
            }
        });
        
        this.setLocationRelativeTo(null);
        
    	p = new Player();
    	p.setVisible(true);
    	this.add(p);
    	
        //Color map
        for(int y = 0; y < col; y++){
            for(int x = 0; x < row; x++){
                Tile tile = new Tile(x, y);
                tile.setSize(size, size);
                tile.setLocation((x*size)+23, (y*size)+25);
                if(map[x][y] == 0){
                    tile.setBackground(Color.GRAY);
                }else{
                    tile.setBackground(Color.WHITE);
                    tile.setw(false);
                    if(x == 0){
                    	p.setLocation((x*size)+23, (y*size)+25);
                    	p.b = y;
                    }
                    if(x == col-1){
                    	endLevelLoc = y;
                    }
                }
                
                tile.setVisible(true);
                this.add(tile);
            }
        }
        this.setVisible(true);
    }
    
    public static void main(String args[]){
    	new MainMenu();
    }
    
    public void loadMap(String str){
        try{
            BufferedReader b = new BufferedReader(new FileReader(str));
            StringBuilder s = new StringBuilder();
            String li = b.readLine();

            while (li != null) {
                s.append(li);
                s.append(System.lineSeparator());
                li = b.readLine();
            }
            String mapStr = s.toString();
            
            int counter = 0;
            for(int y = 0; y < col; y++){
                for(int x = 0; x < row; x++){
                    String mapChar = mapStr.substring(counter, counter+1);
                    if(!mapChar.equals("\r\n") && !mapChar.equals("\n")&& !mapChar.equals("\r")){//If it's a number
                        //System.out.print(mapChar);
                        map[x][y] = Integer.parseInt(mapChar);
                    }else{//If it is a line break
                        x--;
                        System.out.print(mapChar);
                    }
                    counter++;
                }
            }
        }catch(Exception e){
            System.out.println("Unable to load existing map(if exists), creating new map.");
        }
    }
}
