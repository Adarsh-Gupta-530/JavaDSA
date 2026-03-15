import java.util.Arrays;

public class Leet1582SpecialPositionInABinaryMatrix {
    public static int numSpecialBrute(int[][] mat) {
        //brute force -> O(n^3), O(1)
        int specialPos = 0;
        for(int i = 0; i<mat.length;i++){
            for(int j = 0;j<mat[0].length; j++){
                if((isRowZero(mat, i) && isColZero(mat,j)) && mat[i][j]==1 ){
                    specialPos++;
                }
            }
        }
        return specialPos;
    }
    public static boolean isRowZero(int[][] mat, int row){
        int count = 0;
        for(int i = 0; i<mat[0].length;i++ ){
            if(mat[row][i]==1) count++;
        }
        System.out.println(count);
        if(count==1) return true;
        else return false;
    }
    public static boolean isColZero(int[][] mat, int col){
        int count = 0;
        for(int i = 0; i<mat.length;i++ ){
            if(mat[i][col]==1) count++;
        }
        System.out.println(count);
        if(count==1) return true;
        else return false;
    }

    // bettre -> O(n^2), O(n)
    public static int numSpecialBetter(int mat[][]){
        // Better -> TC->O(2n^2), SC->O(2n)
        int specialCount = 0;
        int row[] = new int[mat.length];
        int col[] = new int[mat[0].length];
        
        for(int i = 0; i< mat.length; i++){
            for(int j =0; j<mat[0].length;j++){
                if(mat[i][j]==1){
                    row[i]+=1;
                    col[j]+=1;
                }
            }
        }

        for(int i = 0; i< mat.length; i++){
            for(int j =0; j<mat[0].length;j++){
                if(mat[i][j]==1 && (row[i]==1) && col[j]==1){
                    specialCount++;
                }
            }
        }
        return specialCount;
    }

    public static void main(String[] args) {
        int[][] mat = { {1,0,0},
                        {0,0,1},
                        {1,0,0} };
        System.out.println(numSpecialBetter(mat));

    }
}
