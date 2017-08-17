/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package game.center.Bhuller;
import java.util.TimerTask;
/**
 *
 * @author Bhuller
 */
public class Time extends TimerTask {
    private FinalGame game;
	public Time(FinalGame game) {
		this.game = game;
	}
	
	public void run() {
		game.timer();
	}
    
}
