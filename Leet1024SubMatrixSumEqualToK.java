import java.util.HashMap;

public class Leet1024SubMatrixSumEqualToK {
    public static int numSubmatrixSumTargetBrute(int[][] matrix, int target) {
        // TC->O(n^3*m^3) , SC->O(1)
        int n = matrix.length;
        int m = matrix[0].length;
        int ans = 0;
        // TC->O(n^2*m^2)
        for(int rowStart = 0; rowStart<n;rowStart++){ 
            for(int rowSize = 1; rowSize + rowStart<=n; rowSize++){
                for(int colStart = 0; colStart<m; colStart++){
                    for(int colSize = 1; colSize + colStart <=m; colSize++){
                        //TC_>O(n*m)
                        if(generateSubMatrix(matrix, rowStart, rowSize, colStart, colSize) == target) ans++;
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

    // Better Approach -> TC->O(n^2*m^2) , SC->O(n*m) -> using prefix sum
    public static int numSubmatrixSumTargetBetter(int[][] matrix, int target) {
        int n = matrix.length;
        int m = matrix[0].length;
        int ans = 0;

        // prefix sum 
        for(int row = 0; row<n; row++){
            for(int col = 1; col<m;col++){
                matrix[row][col]+=matrix[row][col-1];
            }
        }

        for(int colStart = 0; colStart<m;colStart++){
            for(int colEnd = colStart;colEnd<m;colEnd++){
                for(int rowStart = 0; rowStart<n;rowStart++){
                    int sum = 0;
                    for(int rowEnd = rowStart; rowEnd<n;rowEnd++){
                        sum +=matrix[rowEnd][colEnd] - (colStart!=0 ? matrix[rowEnd][colStart-1]: 0);
                        if(sum == target) ans++;
                    }
                }
            }
        }
        return ans;
    }
    // optimal ->
    public static int numSubmatrixSumTargetOptimal(int[][] matrix, int target) { 
        // optimal -> TC->O(n^2*m) , SC->O(n*m +n)(if another matrix used)but here SC->O(n) -> using prefix sum and hashmap
        int n = matrix.length;
        int m = matrix[0].length;
        int ans = 0;

        // prefix sum 
        for(int row = 0; row<n; row++){
            for(int col = 1; col<m;col++){
                matrix[row][col]+=matrix[row][col-1];
            }
        }
        
        for(int colStart = 0; colStart<m;colStart++){
            for(int colEnd = colStart;colEnd<m;colEnd++){
                HashMap<Integer, Integer> map = new HashMap<>();
                map.put(0, 1); // for the case when sum itself is equal to target
                int currSum = 0;
                for(int row = 0; row<n;row++){
                    currSum +=matrix[row][colEnd] - (colStart!=0 ? matrix[row][colStart-1]: 0); // calculating curr sum
                    ans += map.getOrDefault(currSum - target, 0); // checking if currSum - target is present in map or not
                    map.put(currSum, map.getOrDefault(currSum, 0) + 1); // putting currSum in map
                }
            }
        }
        return ans;
    }
    public static void main(String[] args) {
        int matrix[][] = {{1,1,1},{-1,-1,1},{1,1,-1}};
        int target = 0;
        System.out.println(numSubmatrixSumTargetOptimal(matrix, target)); 
    }
}
