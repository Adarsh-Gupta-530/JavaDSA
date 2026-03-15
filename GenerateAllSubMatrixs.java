public class GenerateAllSubMatrixs {
    public static int allSubMatrixs(int matrix[][], int target){
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
        System.out.println("Submatrix:");
        for (int i = rStart; i < rStart + rSize; i++) {
            for (int j = cStart; j < cStart + cSize; j++) {
                System.out.print(matrix[i][j] + " ");
                subMatrixSum+=matrix[i][j];
            }
            System.out.println();
        }
        System.out.print("subMatrix Sum = "+subMatrixSum);
        System.out.println(); // extra line for spacing between submatrices
        return subMatrixSum;
    }
    public static void main(String[] args) {
        int[][] matrix = {{2,4,7,8,10},
                          {3,1,1,1,1},
                          {9,11,1,2,1}, 
                          {12,-17,1,1,1}};
        int target = 10;
        System.out.println("Total number of sub matrixes are : "+allSubMatrixs(matrix, target));
    }
}
