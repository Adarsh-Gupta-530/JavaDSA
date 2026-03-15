public class Leet493ReversePairs {
    public static int reversePairs(int[] nums) {
        // brute force ->TC->O(n^2), Sc->O(1) -> gives -> TLE
        int count=0;
        for(int i=0;i<nums.length;i++){
            for(int j=i+1; j<nums.length;j++){
                long first = nums[i];
                long second = nums[j];
                second = second*2;
                if(first>second) count++;

            }
        }
        return count;
    }
    // better
    
    
    public static void main(String[] args) {
        // int arr[] = {1,3,2,3,1};
        // int arr[] = {2147483647,2147483647,2147483647,2147483647,2147483647,2147483647};
        int arr[] = {2,4,3,5,1};
        // A reverse pair is a pair (i, j) where:
        // 1. -> 0 <= i < j < nums.length and
        // 2. -> nums[i] > 2 * nums[j]

        System.out.println(reversePairs(arr));
    }
}
