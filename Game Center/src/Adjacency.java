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
import java.io.IOException;
import static java.lang.Boolean.TRUE;
import java.util.logging.Level;
import java.util.logging.Logger;
/**
 *
 * @author Rosemarie Ty
 */

public class Adjacency extends ConsoleProgram{
Database database;
    int[][] friends;
    int i;
    public void init(){
    try {
        database = new Database();
    } catch (IOException ex) {
        Logger.getLogger(Adjacency.class.getName()).log(Level.SEVERE, null, ex);
    }
    }
        
    public void run(){
        init();
    for(i=0;i<database.getSize();i++){
        println("");
        print(""+database.gProfile(i).getName()+":");
        for(int j=0;j<database.getSize();j++){
            if(database.gProfile(i).isFriend(database.gProfile(j))){
                print(" "+database.gProfile(j).getName());
            }
        }
    }
}
    
    /**;
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        new Adjacency().start(args);// TODO code application logic here
    }
    
}
