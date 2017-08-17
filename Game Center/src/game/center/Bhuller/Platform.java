/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package game.center.Bhuller;

/**
 *
 * @author Bhuller
 */
public class Platform {
public final static int hit = 20;
	public final static int wid = 10;
	private int[][] mat;
	public Platform() {
		mat = new int[hit][wid];
	}
	public boolean stor(Objectt p) {
		int x = p.getx();
		int y = p.gety();
		try {
		for(int j = 0; j < Objectt.size; j++)
			for(int i = 0; i < Objectt.size; i++)
				if(p.getBlock(j, i)!=0)
					mat[y+j][x+i] = p.getBlock(j, i);
		} catch(ArrayIndexOutOfBoundsException e) {
			return false;
		}
		return true;
	}
	private void delLine(int line) {
		for(int j = line; j > 0; j--)
		mat[j] = mat[j-1];
		mat[0] = new int[wid];
	}
	public int delposLines() {
		int dlines = 0;
		int j = hit-1;
		while(j>=0) {
			boolean delpos = true;
			for(int i = 0; i < wid; i++)
				if(mat[j][i]==0) {
					delpos = false;
					break;
				}
			if(delpos) {
				delLine(j);
				dlines++;
			}
			else
				j--;
		}
		return dlines;
	}
	public boolean cmove(Objectt a, int xDisp, int yDisp) {
		if(yDisp < 0) {
			a = a.rotpiece();
			yDisp = 0;
		}
		int x = a.getx() + xDisp;
		int y = a.gety() + yDisp;
		try {
			for(int k = 0; k < Objectt.size; k++)
				for(int i = 0; i < Objectt.size; i++)
					if(a.getBlock(k, i)!=0)
						if(mat[y+k][x+i] !=0 )
							return false;
		} catch(ArrayIndexOutOfBoundsException e) {
			return false;
		}
		return true;
	}
	public int gblock(int y, int x) {
		return mat[y][x];
	}
}
