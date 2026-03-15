import java.util.*;

public class GFGLongestSubarrayWithMajorityGreaterThanK{
    public static int longestSubarray(int[] arr, int k) {  
        // optimal -> TC->O(n), SC->O(n)
        HashMap<Integer, Integer> map = new HashMap<>();
        int preSum = 0; 
        int maxLen = 0;
        for(int i = 0; i<arr.length;i++){
            preSum += (arr[i]>k) ? 1 : -1; 
            if(preSum>0) maxLen = i+1;
            if(map.containsKey(preSum-1)) maxLen = Math.max(maxLen, i-map.get(preSum-1));
            if(!map.containsKey(preSum)) map.put(preSum, i); 
        }
        return maxLen;
    }
    public static void main(String[] args) {
        int arr[] = {1, 2, 3, 4, 1};
        int k = 2;
        // int arr[] = {11,60, 26, 7, 44, 30, 18, 29, 10, 72, 3, 4, 49, 77, 23, 21, 20, 34, 20, 99, 21, 70, 9, 74, 41};
        // int k = 35;

        System.out.println("Longest subarray with majority element then k is : "+longestSubarray(arr, k));
    }
}