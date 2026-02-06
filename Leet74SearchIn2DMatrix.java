public class Leet74SearchIn2DMatrix {
    public static boolean searchMatrix(int[][] matrix, int target) {
        // brute force  ->Applying lenear search => TC-> O(n^2)
        /*for(int i=0; i<matrix.length;i++){
            for(int j=0; j<matrix[0].length;j++){
                if(matrix[i][j]==target){
                    return true;
                }
            }
        }
        return false;
        */
        // better approach ->Applying Binary Search => TC -> O(nlogn)
        int m = matrix.length;
        for(int i=0; i<m; i++){
            int start = 0;
            int end = matrix[i].length-1;
            while(start<=end){
                int mid = start + (end-start)/2;
                if(matrix[i][mid] == target) return true;
                else if(matrix[i][mid]>target) end = mid-1;
                else start = mid+1;
            }
        }
        return false;
    }
    public static void main(String[] args) {
        int matrix[][] = {{1,3,5,7},{10,11,16,20},{23,30,34,60}};
        int target = 13;
        if(searchMatrix(matrix,target)) System.out.println("Target "+target+" is present in matrix.");
        else System.out.println("Target "+target+" is not present in matrix.");
    }
}
