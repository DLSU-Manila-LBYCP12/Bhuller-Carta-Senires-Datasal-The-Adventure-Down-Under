/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package SecondGame;


import java.awt.Color;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

import javax.swing.JPanel;

/**
 *
 * @author Bhuller
 */
public class MapMakerTile extends JPanel{
     int a, b;
    
    public MapMakerTile(int x, int y){
        this.a = x;
        this.b = y;
        
        addMouseListener(new MouseAdapter(){
                    public void mousePressed(MouseEvent e) {
                    	if(e.getButton() == MouseEvent.BUTTON1){
	                        setBackground(Color.WHITE);
	                        MazeMapMaker.map[x][y] = 1;
                    	}
                    	if(e.getButton() == MouseEvent.BUTTON3){
	                        setBackground(Color.GRAY);
	                        MazeMapMaker.map[x][y] = 0;
                    	}
                    }
                });
    }
}
