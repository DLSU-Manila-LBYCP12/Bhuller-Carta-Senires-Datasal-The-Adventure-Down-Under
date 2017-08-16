/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package SecondGame;

import javax.swing.JPanel;
/**
 *
 * @author Bhuller
 */
public class Tile extends JPanel{
    int a, b;
    boolean ex = true;
    
    public Tile(int x, int y){
        this.a = x;
        this.b = y;
    }
    
    public void setw(boolean ex){
        this.ex = ex;
    }
}
