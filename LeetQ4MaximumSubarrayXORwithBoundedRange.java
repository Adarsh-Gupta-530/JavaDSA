public class LeetQ4MaximumSubarrayXORwithBoundedRange {
    public static int maxXor(int[] nums, int k) { // better -> O(n^2) and SC-> O(n)
        if(nums.length == 0) return -1;
        int preXor[] = new int[nums.length];
        int maxXorSubArray = Integer.MIN_VALUE;
        preXor[0] = nums[0];
        for(int i=1;i<nums.length;i++){
            preXor[i] = preXor[i-1]^nums[i];
        }

        for(int i=0;i<nums.length;i++){
            for(int j = i;j<nums.length;j++){
                if(getMixMinDiff(i,j,nums)<=k){
                    int currSubArrayXor = i==0 ? preXor[j] : preXor[j]^preXor[i-1];
                    maxXorSubArray = Math.max(maxXorSubArray, currSubArrayXor);
                } 
            }
        }
        return maxXorSubArray == Integer.MIN_VALUE ? -1 : maxXorSubArray;
    }
    public static int getMixMinDiff(int i, int j, int[] nums){
        int maxEle = Integer.MIN_VALUE;
        int minEle = Integer.MAX_VALUE;
        for(int start = i;start<=j;start++){
            maxEle = Math.max(maxEle, nums[start]);
            minEle = Math.min(minEle, nums[start]);
        }
        return maxEle-minEle;
    }
    public static void main(String[] args) {
        int arr[] = {5,4,5,6};
        int k = 1;
        System.out.println(maxXor(arr, k));
    }
}
