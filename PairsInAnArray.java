public class PairsInAnArray {
    public static void allPossiblePairs(int arr[]){ //TC-> O(n^2)
        int totalPairs = 0;
        for(int i=0;i<arr.length;i++){
            for(int j=i+1;j<arr.length;j++){
                System.out.print("("+arr[i]+", "+arr[j]+")");
                totalPairs++;
            }
            System.out.println();
        }
        System.out.println("Total pairs : "+totalPairs);
    }
    public static int totalPairsCount(int arr[]){ // TC->O(n)
        int n = arr.length;
        return (int)n*(n-1)/2;

    }
    public static void main(String[] args) {
        int arr[]= {2,4,6,8,10,1};
        allPossiblePairs(arr);
        System.out.println("pairs count is : "+totalPairsCount(arr));
    }
}
