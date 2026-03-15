public class GFGMaxXorSubarrayOfSizeK {
    public static int maxSubarrayXOR(int[] arr, int k) {
        // optimal -> sliding window -> O(2n), O(1)
        int n = arr.length;
        if (k <= 0 || k > n) return 0;

        int currXor = 0;

        // calculate first window xor
        for(int i = 0; i < k; i++){
            currXor ^= arr[i];
        }

        int maxXor = currXor;   // first window

        // slide window
        for(int i = k; i < n; i++){
            currXor ^= arr[i - k];   // remove left element
            currXor ^= arr[i];       // add new right element
            maxXor = Math.max(maxXor, currXor);
        }

        return maxXor;
    }
    public static void main(String[] args) {
        int arr[] = {1, 2, 3, 4, 5};
        int k = 2;
        System.out.println(maxSubarrayXOR(arr, k));
    }
    
}
