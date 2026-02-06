import java.util.ArrayList;
import java.util.List;

public class Leet54SpiralMatrix {
    public static List<Integer> spiralOrder(int matrix[][]){
        List<Integer> spiral= new ArrayList<>();
        int startRow=0;
        int startCol=0;
        int endRow=matrix.length-1;
        int endCol=matrix[0].length-1;
        while(startRow<=endRow && startCol<=endCol){
            for(int j=startCol;j<=endCol;j++){// Top row
                spiral.add(matrix[startRow][j]);
            }
            for(int i=startRow+1;i<=endRow;i++){//Right coumn
                spiral.add(matrix[i][endCol]);
            }
            for(int j=endCol-1;j>=startCol;j--){// Bottom row
                if(startRow==endRow) break;  // corner case if single row is remaining then (top boundary == bottom boundery)
                spiral.add(matrix[endRow][j]);
            }
            for(int i=endRow-1;i>=startRow+1;i--){// left col
                if(startCol==endCol) break; // corner case if single column is remaining then (left boundary == right boundary)
                spiral.add(matrix[i][startCol]);
            }
            startRow++;
            startCol++;
            endRow--;
            endCol--;
        }
        return spiral;
    }
    public static void main(String[] args) {
        // int matrix[][]={{1,2,3,4},{5,6,7,8},{9,10,11,12},{13,14,15,16}};
        // int matrix[][]={{1,2,3,4,25},
        //                 {5,6,7,8,26},
        //                 {9,10,11,12,27},
        //                 {13,14,15,16,28}};

        int matrix[][]={{1,2,3,4,5},{6,7,8,9,10},{11,12,13,14,15},{16,17,18,19,20},{21,22,23,24,25}};
        System.out.print(spiralOrder(matrix));
    }
}
