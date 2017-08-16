/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package FirstGame;

/**
 *
 * @author Bhuller
 */
public class Tetsam {
    private boolean gameo = true;
    
    private int scor;
    private final int[] scoret = { 0, 10, 30, 50, 100 };
    
    private final int cols = 16, rows = 28;
    private int[][] grid = new int[rows][cols];
    
    private long[] dat = { 0xF00444400F02222l, 
        0x660066006600660l, 0xC6004C800C60264l, 0x6C008C4006C0462l, 
        0x8E0044C00E20644l, 0xE8044602E00C44l, 0x46404E004C400E4l };
    
    private int[][][] block = new int[7][4][8];
    private int cur, next, turn;
    private int br= 0, bc = 3;
    
    public Tetsam() {
        initb();
        cur = (int) (7 * Math.random());
        next = (int) (7 * Math.random());
    }

    private void initb() {
        for (int p = 0; p < dat.length; p++) {
            int colRow = 0;
            for (int b = 0; b < 64; b++) {
                colRow = b % 16 == 0 ? 0 : colRow;
                if (((dat[p] >> b) & 1) == 1) {
                    block[p][b / 16][colRow++] = b % 4;
                    block[p][b / 16][colRow++] = (b % 16) / 4;
                }
            }
        }
    }
    
    public boolean go() {
        return gameo;
    }

    public int sco() {
        return scor;
    }

    public int col() {
        return cols;
    }

    public int row() {
        return rows;
    }
    
    public int val(int c, int r) {
        int[] blo = block[cur][turn];
        for (int i = 0; i < block.length; i+=2) {
            if (c == blo[i] + bc && r == blo[i + 1] + br) {
                return cur + 1;
            }
        }
        return grid[r][c];
    }
    
    public int nextval(int c, int r) {
        int[] blo = block[next][0];
        for (int i = 0; i < block.length; i+=2) {
            if (c == blo[i] && r == blo[i + 1]) {
                return next + 1;
            }
        }
        return 0;
    }
    
    private boolean collide(int aa, int bb, int rota) {
        int[] blo = block[cur][rota];
        for (int i = 0; i < block.length; i+=2) {
            int col = blo[i] + bc + aa;
            int row = blo[i + 1] + br + bb;
            if (col < 0 || col > cols - 1 
                    || row < 0 || row > rows - 1
                    || grid[row][col] > 0) {
                return true;
            }
        }
        return false;
    }
    
    public void start() {
        grid = new int[rows][cols];
        bc = 3;
        br = 0;
        scor = 0;
        gameo = false;
    }
    
    public void move(int aa) {
        if (!collide(aa, 0, turn)) {
            bc += aa;
        }
    }

    public void rot() {
        int nextrota = (turn + 1) % 4;
        if (!collide(0, 0, nextrota)) {
            turn = nextrota;
        }
    }
    
    public void down() {
        while (!collide(0, 1, turn)) {
            br++;
        }
    }

    public void update() {
        int cc = clea();
        scor += scoret[cc];
        if (!collide(0, 1, turn)) {
            br++;
            return;
        }
        if (br < 4 || gameo) {
            gameo = true;
            return;
        }
        sol();
        nextblo();
    }
    
    private int clea() {
        int cc = 0;
        nextRow:
        for (int r=0; r<rows; r++) {
            for (int col=0; col<cols; col++) {
                if (grid[r][col] == 0) {
                    continue nextRow;
                }
            }
            for (int r2 = r; r2 > 0; r2--) {
                System.arraycopy(grid[r2 - 1], 0, grid[r2], 0, cols);
            }
            cc++;
        }
        return cc;
    }
    
    private void sol() {
        int[] p = block[cur][turn];
        for (int i=0; i<p.length; i+=2) {
            grid[p[i + 1] + br][p[i] + bc] = cur + 1;
        }
    }

    private void nextblo() {
        bc = 3;
        br = 0;
        turn = 0;
        cur = next;
        next = (int) (7 * Math.random());
    }
}
