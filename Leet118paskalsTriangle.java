import java.util.*;
public class Leet118paskalsTriangle {
    public static int pascalTriangeType1Brute(int row, int column){//TC->O(n)+O(r)+O(n-r)
        // type 1-> row and column are given and return the element at that place
        // brute-> logic use nCr formula 
        return factorial(row-1)/(factorial(column-1)*factorial((row-1)-(column-1)));

    }
    public static int factorial(int n){
        if(n==0) return 1;
        return n*factorial(n-1);
    }
    // better for type 1
    public static int pascalsTriangleType1Better(int n, int r){ // tc->O(r)
        int result = 1;
        for(int i=0;i<r;i++){ // correct for 1 based indexing
            result = (result*(n-i))/(i+1);
        }
        return result;
    }

    // Type 2 -> print the entire row;
    public static long nCr(int n, int r){
        if(r==0) return 1;
        long result = 1;
        for(int i=0;i<r;i++){ // O(r)
            result = (int)(result*(n-i))/(i+1);
        }
        return result;
    }
    public static List<Integer> pascalTriangeType2Brute(int row){
            List<Integer> resultRow = new ArrayList<>();
            for(int col=1;col<=row+1;col++){
                resultRow.add((int)nCr(row, col-1));
            }
            return resultRow;
    }

    // better type 2->  O(n)
    public static List<Integer> pascalsTriangleType2Better(int row){  // X wrong ans for row =30;
        List<Integer> result = new ArrayList<>();
        long value=1;
        for(int col=1;col<=row+1;col++){  // TC-> O(n)
            result.add((int)value);
            value = (long)result.get(col-1)*(row+1-col);
            value = value/col;
        }
        return result;
    }

    // type - 3 -> brute
    public static List<List<Integer>> pascalsTriangleType3Brute(int rowNum){//TC->O(n)*O(n)*O(r)
        List<List<Integer>> result = new ArrayList<>();// for result
        for(int row=0; row<=rowNum;row++){//O(n)
            List<Integer> tringleRow = new ArrayList<>();
            for(int col=1;col<=row+1;col++){//O(n)
                tringleRow.add((int)nCr(row, col-1)); // O(r)
            }
            result.add(new ArrayList<>(tringleRow));
        }
        return result;
    }

    public static List<List<Integer>> pascalsTriangleType3Better(int rowNum){ // better -> TC->O(n)*O(n)
        List<List<Integer>> result = new ArrayList<>();// for result
        for(int row=0; row<=rowNum;row++){//O(n)
            long value=1;
            List<Integer> tringleRow = new ArrayList<>();
            for(int col=1;col<=row+1;col++){//O(n)
                tringleRow.add((int)value);
                value = (long)tringleRow.get(col-1)*(row+1-col);
                value = value/col;
            }
            result.add(new ArrayList<>(tringleRow));
        }
        return result;
    }
    public static void main(String[] args) {
        // int row = 30;
        // int column = 4;
        // type 1 
        // System.out.println("Element is : "+pascalTriangeType1Brute(row, column));
        // System.out.println("Element is : "+pascalsTriangleType1Better(row-1, column-1));

        // type 2
        // int row = 30;
        // System.out.println(pascalTriangeType2Brute(row));
        // System.out.print(nCr(5, 2));
        // System.out.println(pascalsTriangleType2Better(row));

        // type - 3
        // System.out.println(pascalsTriangleType3Brute(5));
        // pascalsTriangleType3Brute(6);
        System.out.println(pascalsTriangleType3Better(5));

    }
    
}
