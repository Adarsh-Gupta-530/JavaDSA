import java.util.*;
public class Leet48RotateMatrixBy90Degree {
    public static void rotate90Brute(int[][] matrix) { 
        // bruteForce-> TC->O(n*m), SC->O(n*m)
        int n= matrix.length;
        int m= matrix[0].length;
        int rotated[][]= new int[matrix.length][matrix[0].length]; // take another matrix 
        for(int i=0;i<n;i++){
            for(int j=0;j<m;j++){
                // store matrix elements in rotated fashion
                rotated[j][m-i-1] = matrix[i][j];
            }
        }
        for(int i=0;i<matrix.length;i++){ // restore into the same matrix 
            for(int j=0;j<matrix[0].length;j++){
                matrix[i][j] = rotated[i][j];
            }
        }
    }

    public static void rotate90Optimal(int[][] matrix) {
        int n =matrix.length;
        int m = matrix[0].length;
        // algorithm for optimal solution ->SC->O(n), TC->O(n/2)*O(n/2) + O(n * n/2)
        // step 1 : get the transpose of matrix 
        for(int i=0;i<=n-2;i++){ //TC ->O(n/2)*O(n/2)
            for(int j=i+1;j<=m-1;j++){
                // swap matrix[i][j] to matrix[j][i]
                int temp = matrix[i][j];
                matrix[i][j] = matrix[j][i];
                matrix[j][i] = temp;
            }
        }
        // step 2 : reverse all rows 
        for(int i=0;i<n;i++){ // TC->O(n * n/2)
            reverse(matrix[i], 0, m-1);
        }

    }
    public static void reverse(int arr[], int start, int end){ // TC->O(n/2)
        if(start>=end){
            return;
        }
        // swap
        int temp = arr[start];
        arr[start]=arr[end];
        arr[end] = temp;
        reverse(arr, start+1, end-1);
    }

    public static void main(String[] args) {
        // int matrix[][] = {{1,2,3},{4,5,6},{7,8,9}};
        int matrix[][] ={{1,2,3,4},{5,6,7,8},{9,10,11,12},{13,14,15,16}};
        // rotate90Brute(matrix);
        rotate90Optimal(matrix);
        for(int i=0;i<matrix.length;i++){
            System.out.println(Arrays.toString(matrix[i]));
        }
    }
}
