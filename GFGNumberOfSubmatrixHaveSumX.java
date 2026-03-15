import java.util.*;
public class GFGNumberOfSubmatrixHaveSumX{
    public static int allSquareSubMatrixsSumKBrute(int matrix[][], int target){
        // BRUTE FORCE -> TC->O(n^3*m^3) , SC->O(1)
        int n = matrix.length;
        int m = matrix[0].length;
        int ans = 0;
        // TC->O(n^2*m^2)
        for(int rowStart = 0; rowStart<n;rowStart++){ 
            for(int rowSize = 1; rowSize + rowStart<=n; rowSize++){
                for(int colStart = 0; colStart<m; colStart++){
                    for(int colSize = 1; colSize + colStart <=m; colSize++){
                        //TC_>O(n*m)
                        if(rowSize==colSize && generateSubMatrix(matrix, rowStart, rowSize, colStart, colSize) == target) ans++;
                    }
                }
            }
        } 
        return ans;
    }
    public static int generateSubMatrix(int[][] matrix, int rStart, int rSize, int cStart, int cSize) { //TC->O(n*m)
        int subMatrixSum =0;
        for (int i = rStart; i < rStart + rSize; i++) {
            for (int j = cStart; j < cStart + cSize; j++) {
                subMatrixSum+=matrix[i][j];
            }
        }
        return subMatrixSum;
    }

    // better -> TC->O((n*m)^2), SC->O(1)
    public static int allSquareSubMatrixsSumKBetter(int matrix[][], int target){
        int n = matrix.length;
        int m = matrix[0].length;
        int ans = 0;

        // prefix sum  ->  by making change in given matrix also use another matrix to not change input
        for(int row = 0; row<n; row++){
            for(int col = 1; col<m;col++){
                matrix[row][col]+=matrix[row][col-1];
            }
        }
        // calculating 
        for(int colStart = 0; colStart<m;colStart++){
            for(int colEnd = colStart;colEnd<m;colEnd++){
                for(int rowStart = 0; rowStart<n;rowStart++){
                    int sum = 0;
                    for(int rowEnd = rowStart; rowEnd<n;rowEnd++){
                        sum +=matrix[rowEnd][colEnd] - (colStart!=0 ? matrix[rowEnd][colStart-1]: 0);
                        if((rowEnd - rowStart) == (colEnd - colStart)){ //  checking for square submatrixs
                            if(sum == target){
                                ans++;
                            }
                        }
                    }
                }
            }
        }
        return ans;
    }

    // optimal ->
    public static int allSquareSubMatrixsSumKOptimal(int matrix[][], int target){
        int n = matrix.length;
        int m = matrix[0].length;
        int ans = 0;

        // prefix sum  ->  by making change in given matrix also use another matrix to not change input
        for(int row = 0; row<n; row++){
            for(int col = 1; col<m;col++){
                matrix[row][col]+=matrix[row][col-1];
            }
        }
        // calculating 
        HashMap<Integer, Integer> map = new HashMap<>();
        for(int colStart = 0; colStart<m;colStart++){
            for(int colEnd = colStart;colEnd<m;colEnd++){
                for(int rowStart = 0; rowStart<n;rowStart++){
                    
                }
            }
        }
        return ans;
    }
    public static void main(String[] args) {
        int[][] matrix = {{2,4,7,8,10},
                          {3,1,1,1,1},
                          {9,11,1,2,1}, 
                          {12,-17,1,1,1}};
        int target = 10;
        System.out.println("Total number of sub matrixes are : "+allSquareSubMatrixsSumKBetter(matrix, target));
    }
}