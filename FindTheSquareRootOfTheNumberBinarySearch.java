public class FindTheSquareRootOfTheNumberBinarySearch {
    public static int findSquareRoot(int n){
        int ans = 1;

        // brute -> O(n) - linear search
        // for(int i = 1; i<=n; i++){
        //     if(i*i<=n){
        //         ans = i;
        //     }else{
        //         break;
        //     }
        // }
        // return ans;

        // better -> binary search -> O(logn)
        int low = 1;
        int high = n;

        
        return ans;
    }
    public static void main(String[] args) {
        int n = 28;
        System.out.println(findSquareRoot(n));
    }
}
