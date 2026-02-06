public class LongestSubArrayWithKsum {
    public static int longestSubarray(int[] nums, int k) {
    //    // brute force ->TC->O(n^3)
    //    int len = 0;
    //    for(int i=0;i<nums.length;i++){
    //         for(int j=i+1;j<nums.length;j++){
    //             int sum = 0;
    //             int maxCount=Integer.MIN_VALUE;
    //             for(int p=i;p<=j;p++){
    //                 sum+=nums[p];
    //             }
    //             if(sum==k) len = Math.max(len, j-i+1);
    //         }
    //         // System.out.println();
    //    }
    //    return len;

    // brute force 2-> TC->O(n^2);
        int len=0;
        for(int i=0;i<nums.length;i++){
            int sum=0;
            for(int j=i;j<nums.length;j++){
                sum+=nums[j];
                if(sum==k) len = Math.max(len, j-i+1);
            }
        }
        return len;
    }

    public static int longestSubarrayBetter(int[] nums, int k) {
        int prefix[] =new int[nums.length];
        prefix[0] = nums[0];
        for(int i=1;i<nums.length;i++){ // prefix sum stored
            prefix[i]=prefix[i-1]+nums[i];
        }
        int len=0;
        int sum=0;
        for(int i=0;i<nums.length;i++){
            for(int j=i;j<nums.length;j++){
                if(i==0) sum+=prefix[j];
                else sum= prefix[j]- prefix[i-1];

                if(sum==k) len = Math.max(len, j-i+1);
            }
        }
        return len;
    }

    public static int longestSubarrayOptimal(int nums[], int k){
        int left = 0;
        int right=0;
        int maxLen = 0;
        int sum = nums[0];
        
        while(right<nums.length){
            while(left<=right && sum > k){ // if sum exceeded the k then subtract the previous value from sum  
                sum-=nums[left];
                left++;
            }
            if(sum == k){
                maxLen = Math.max(maxLen, right-left+1); // storing the maximum length 
            }
            right++; // increase the value of right before sum 
            if(right < nums.length) sum+=nums[right]; // if right is less then nums.length means there is a value just add it.
        }

        return maxLen;
    }

    public static void main(String[] args) {
        // int arr[] = {10,5, 2, 7, 1, 9};
        int arr[] = {-3,2,6,4,5,1};
        System.out.println("longest length is : "+longestSubarrayBetter(arr, 15));

    }
}
