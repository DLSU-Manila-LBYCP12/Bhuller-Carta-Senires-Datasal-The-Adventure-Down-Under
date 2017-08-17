/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package game.center.Bhuller;

import java.awt.event.KeyEvent;
import java.lang.reflect.Field;
import java.lang.reflect.Modifier;
import java.util.HashMap;

/**
 *
 * @author Bhuller
 */
public class Gett {
    
    private static HashMap<Integer, String> je;
    
    public static void lod(){
        je = new HashMap<Integer, String>();
        Field[] fields = KeyEvent.class.getFields();
        for (Field l: fields){
            if(Modifier.isStatic(l.getModifiers())){
                if(l.getName().startsWith("VK")){
                    System.out.println(l);
                    try{
                        int ge = l.getInt(null);
                                String na = KeyEvent.getKeyText(ge);
                    je.put(ge, na);
                    System.out.println(na);
                }
                    catch(Exception e){
                            e.printStackTrace();
                            }
                }
            }
        }
    }
}
