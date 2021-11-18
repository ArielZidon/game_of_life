import java.awt.*;

public abstract class GameOfLife {




    public static void clearCells(boolean [][]clearCells){
        StdDraw.clear();
    }


    public static void drawCells(boolean[][] cells, int cellSize, Color color){
        StdDraw.setPenColor(color);
        for (int i = 0; i < cells.length; i++) {
            for (int j = 0; j < cells[0].length; j++) {
                if (cells[i][j]) {
                    double p = i * cellSize + cellSize / 2;
                    double q = j * cellSize + cellSize / 2;
                    StdDraw.filledSquare(q, p, cellSize / 2);}}}}


    public static void generation(int n, double cellSize) {
        StdDraw.setXscale(0,n);
        StdDraw.setYscale(n,0);
        StdDraw.setPenRadius(0.005);
        StdDraw.setPenColor(Color.blue);
        for (int i = 0; i <=n ; i+=cellSize) {
            StdDraw.line(0,i,n,i);
            StdDraw.line(i,0,i,n);}
        StdDraw.setPenRadius(cellSize);
        }

    public static void gameOfLife (int n, int cellSize) {
        boolean cells [][]= new boolean[n][n];
        cells[7][2] = true;
        cells[7][3] = true;
        cells[7][4] = true;
        cells[7][5] = true;
        cells[7][6] = true;
        cells[7][7] = true;
        cells[7][8] = true;
        cells[7][9] = true;
        cells[7][10] = true;
        cells[7][11] = true;
        cells[7][12] = true;

        cells[20][20] = true;
        cells[19][20] = true;
        cells[19][19] = true;
        cells[18][19] = true;
        cells[18][18] = true;
        cells[17][18] = true;
        cells[17][17] = true;
        cells[16][17] = true;
        cells[16][16] = true;

        cells[1][15] = true;
        cells[1][16] = true;
        cells[2][17] = true;
        cells[1][18] = true;
        cells[2][19] = true;
        cells[1][20] = true;
        cells[1][21] = true;
        cells[1][22] = true;
        cells[2][22] = true;
        cells[2][23] = true;

        while(true){
            generation(n, cellSize);
            drawCells(cells, cellSize, Color.yellow                );
            StdDraw.pause(1000);
            clearCells(cells);
            cells = NextGeneration.NextGeneration(cells);
        }
    }


    public static void main(String[] args) throws InterruptedException {
        gameOfLife(240,10);
    }


    }

