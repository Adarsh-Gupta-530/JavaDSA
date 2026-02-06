import java.util.*;
public class Leet73SetMatrixZeroes {
    public static void setRows(int matrix[][], int row){
        for(int j=0;j<matrix[0].length;j++){ // TC->O(m)
            matrix[row][j]=-1;
        }
    }
    public static void setColumns(int matrix[][], int column){
        for(int i=0;i<matrix[0].length;i++){ // TC->O(n)
            matrix[i][column]=-1;
        }
    }
    public static void setZeroBrute(int matrix[][]){
        // brute force -> TC->O(n*m)*O(n+m)+O(n+m) ~= O(n^3)
        // step 1. mark all zeros to -1
        for(int i = 0; i<matrix.length;i++){//TC->O(n)
            for(int j =0;j<matrix[0].length;j++){ //TC->O(m)
                if(matrix[i][j]==0){
                    // TC->O(n+m)
                    setRows(matrix,i);
                    setColumns(matrix, j);
                }
            }
        }
        // step 2 -> make all -1 to 0;
        for(int i = 0; i<matrix.length;i++){
            for(int j =0;j<matrix[0].length;j++){
                if(matrix[i][j]==-1){
                    matrix[i][j] = 0;
                }
            }
        }

    }

    public static void setZeroesBetter(int[][] matrix) {
        // betters->TC->O(2(n*m)), SC->O(m+n)
        // step 1 ->  take to boolean array to store which row or column contains the zero value
        boolean rows[] = new boolean[matrix.length];
        boolean columns[]=new boolean[matrix[0].length];

        // step2-> tereverse for which row or column contains zero value
        for(int i=0;i<matrix.length;i++){
            for(int j=0;j<matrix[0].length;j++){
                if(matrix[i][j]==0){ // make the row and column true
                    rows[i]=true;
                    columns[j]=true;
                }
            }
        }
        // step 3 -> make all that rows and columns to zero which have atleast one zero value
        for(int i=0;i<matrix.length;i++){
            for(int j=0;j<matrix[0].length;j++){
                if(rows[i]==true || columns[j]==true){
                    matrix[i][j]=0;
                }
            }
        }
    }

    public static void setZerosOptimized(int matrix[][]){ // TC->O(n*m)
        // columns[]=> matrix[0][.....] =>as mark column array
        // rows[]=>matrix[....][0] =>as mark row array
        int col0 = 1;
        // step 1-> check for zero
        for(int i=0;i<matrix.length;i++){
            for(int j = 0; j<matrix[0].length;j++){
                if(matrix[i][j]==0){
                    // mark i th row
                    matrix[i][0]=0;
                    //  j th column
                    if(j!=0) matrix[0][j]=0;
                    else col0 = 0;
                }
                
            }
        }

        // iterate without first row and first column
        for(int i=1;i<matrix.length;i++){
            for(int j = 1; j<matrix[0].length;j++){
                if(matrix[i][j]!=0){
                    if(matrix[i][0]==0||matrix[0][j]==0) matrix[i][j]=0;
                }
            }
        }
        // checking for first column
        if(matrix[0][0]==0) for(int j=0;j<matrix[0].length;j++) matrix[0][j]=0;
        // checking for the first row
        if(col0==0) for(int i=0;i<matrix.length;i++) matrix[i][0]=0;
    }
    public static void main(String[] args) {
        // int matrix[][] ={{1,1,1},{1,0,1},{1,1,1}};
        // int matrix[][] = {{0,1,1},{1,0,1},{1,1,0}};
        // int matrix[][]={{1,1,1,1},{1,0,0,1},{1,1,0,1},{1,1,1,1}};
        int matrix[][]={{1,1,1,1},{1,0,0,1},{1,1,0,1},{0,1,1,1}};
        // setZeroesBetter(matrix);
        // setZeroBrute(matrix);
        setZerosOptimized(matrix);
        for(int i=0;i<matrix.length;i++){
            System.out.println(Arrays.toString(matrix[i]));
        }

    }
}
