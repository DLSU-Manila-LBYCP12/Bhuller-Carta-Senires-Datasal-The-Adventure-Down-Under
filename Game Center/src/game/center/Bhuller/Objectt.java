/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package game.center.Bhuller;

import java.util.Random;

/**
 *
 * @author Bhuller
 */
public class Objectt {
 private int hori, ver;
		private int ty, turn;
		final static int size = 4;
		private final static int[][][][] num = {
	{
	{
	{0,1,0,0},
	{0,1,0,0},
	{0,1,0,0},
	{0,1,0,0}
	},
	{
	{0,0,0,0},
	{1,1,1,1},
	{0,0,0,0},
	{0,0,0,0}
	},
	{
	{0,1,0,0},
	{0,1,0,0},
	{0,1,0,0},
	{0,1,0,0}
	},
	{
	{0,0,0,0},
	{1,1,1,1},
	{0,0,0,0},
	{0,0,0,0}
	}
	},
	{
	{
	{0,0,0,0},
	{2,2,0,0},
	{0,2,2,0},
	{0,0,0,0}
	},
	{
	{0,2,0,0},
	{2,2,0,0},
	{2,0,0,0},
	{0,0,0,0}
	},
	{
	{0,0,0,0},
	{2,2,0,0},
	{0,2,2,0},
	{0,0,0,0}
	},
	{
	{0,2,0,0},
	{2,2,0,0},
	{2,0,0,0},
	{0,0,0,0}
	}
	},
	{
	{
	{0,0,0,0},
	{0,3,3,0},
	{3,3,0,0},
	{0,0,0,0}
	},
	{
	{3,0,0,0},
	{3,3,0,0},
	{0,3,0,0},
	{0,0,0,0}
	},
	{
	{0,0,0,0},
	{0,3,3,0},
	{3,3,0,0},
	{0,0,0,0}
	},
	{
	{3,0,0,0},
	{3,3,0,0},
	{0,3,0,0},
	{0,0,0,0}
	}
	},
	{
	{
	{0,4,0,0},
	{4,4,4,0},
	{0,0,0,0},
	{0,0,0,0}
	},
	{
	{0,4,0,0},
	{0,4,4,0},
	{0,4,0,0},
	{0,0,0,0}
	},
	{
	{0,0,0,0},
	{4,4,4,0},
	{0,4,0,0},
	{0,0,0,0}
	},
	{
	{0,4,0,0},
	{4,4,0,0},
	{0,4,0,0},
	{0,0,0,0}
	}
	},
	{
	{
	{0,5,0,0},
	{0,5,0,0},
	{0,5,5,0},
	{0,0,0,0}
	},
	{
	{0,0,0,0},
	{5,5,5,0},
	{5,0,0,0},
	{0,0,0,0}
	},
	{
	{5,5,0,0},
	{0,5,0,0},
	{0,5,0,0},
	{0,0,0,0}
	},
	{
	{0,0,5,0},
	{5,5,5,0},
	{0,0,0,0},
	{0,0,0,0}
	}
	},
	{
	{
	{0,6,0,0},
	{0,6,0,0},
	{6,6,0,0},
	{0,0,0,0}
	},
	{
	{6,0,0,0},
	{6,6,6,0},
	{0,0,0,0},
	{0,0,0,0}
	},
	{
	{0,6,6,0},
	{0,6,0,0},
	{0,6,0,0},
	{0,0,0,0}
	},
	{
	{0,0,0,0},
	{6,6,6,0},
	{0,0,6,0},
	{0,0,0,0}
	}
	},
	{
	{
	{0,0,0,0},
	{0,7,7,0},
	{0,7,7,0},
	{0,0,0,0}
	},
	{
	{0,0,0,0},
	{0,7,7,0},
	{0,7,7,0},
	{0,0,0,0}
	},
	{
	{0,0,0,0},
	{0,7,7,0},
	{0,7,7,0},
	{0,0,0,0}
	},
	{
	{0,0,0,0},
	{0,7,7,0},
	{0,7,7,0},
	{0,0,0,0}
	}
	}
	
	};
	private static int[][][] start = {
	{
	{3,0},
	{3,-1},
	{3,0},
	{3,-1}
	},
	{
	{3,-1},
	{3,0},
	{3,-1},
	{3,0}
	},
	{
	{3,-1},
	{3,0},
	{3,-1},
	{3,0}
	},
	{
	{3,0},
	{3,0},
	{3,-1},
	{3,0}
	},
	{
	{3,0},
	{3,-1},
	{4,0},
	{4,0}
	},
	{
	{4,0},
	{3,0},
	{3,0},
	{3,-1},
	},
	{
	{3,-1},
	{3,-1},
	{3,-1},
	{3,-1}
	}
	};
    public Objectt () {
	Random r = new Random();
	ty = r.nextInt(7);
	turn = r.nextInt(4);
	hori = start[ty][turn][1];
	hori = start[ty][turn][0];
	}
    public Objectt(Objectt a) {
	hori = a.getx();
	ver = a.gety();
	ty = a.getType();
	turn = a.getRot();
	}
	public int getx() {
	return hori;
	}
	public int gety() {
	return ver;
	}
	public int getType() {
	return ty;
	}
	public int getRot() {
	return turn;
	}
	public static int getPieceSize() {
	return size;
	}
	public int[][] getPiece() {
	return num[ty][turn];
	}
	public int getBlock(int x, int y) {
	return num[ty][turn][x][y];
	}
	public void left() {
	hori--;
	}
	public void right() {
	hori++;
	}
	public void down() {
	ver++;
	}
	public void rot() {
	turn= (turn+1)%4;
	}
	public Objectt rotpiece() {
	Objectt q = new Objectt(this);
	q.rot();
	return q;
	}
}
