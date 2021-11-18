import java.util.Arrays;

public class NextGeneration {
    public static boolean isInside(boolean[][] cells, int x, int y) {
        if ((x >= cells.length) || (y >= cells[0].length) || x < 0 || y < 0)
            return false;
        return true;
    }

    public static boolean checkCell(boolean[][] cells, int x, int y){
      if (isInside(cells,x,y)){return cells[x][y];}
    return false;}

    public static int numberOfNeighbors(boolean[][] cells, int x, int y) {
        int countTrue = 0;
        for (int i = -1; i <= 1; i++) {
            for (int j = -1; j <= 1; j++) {
                if ((i != 0 || j != 0) && checkCell(cells, x + i, y + j))
                    countTrue++;
            }
        }
        return countTrue;
    }

    public static boolean[][] NextGeneration(boolean[][] cells){
        boolean [][] next= new boolean[cells.length][cells[0].length];
        for (int i = 0; i < cells.length ; i++) {
            for (int j = 0; j < cells[0].length ; j++) {
                int Neighbors=numberOfNeighbors(cells,i,j);

                boolean live = checkCell(cells,i,j);

                if (!live && Neighbors==3){
                    next[i][j]=true;}

                else if (live && (Neighbors == 2 || Neighbors == 3)){
                    next[i][j]= true;}

                else {next[i][j] = false;}
                }
                }

            return next; }

    public static void main(String[] args) {
        boolean[][] currentGen = {{false,false,false,false,false}
                ,{false,false,false,false,false}
                ,{false,true,true,true,false}
               ,{false,false,false,false,false}
                ,{false,false,false,false,false}};
        boolean[][] nextGen = NextGeneration(currentGen);
        for(int i=0 ; i<nextGen.length ; i++){
            System.out.println(Arrays.toString(nextGen[i]));
        }}}



