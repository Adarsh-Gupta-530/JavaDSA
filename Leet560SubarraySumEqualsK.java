import java.util.*;

public class Leet560SubarraySumEqualsK {
    public static int subarraySumBrute(int[] nums, int k) { 
        // Brute force -> TC->O(n^3) -> gives TLE
        int count=0;
        for(int i=0;i<nums.length;i++){
            for(int j=i;j<nums.length;j++){
                int sum=0;
                for(int l=i;l<=j;l++){
                    sum+=nums[l];
                }
                if(sum==k) count++;
            }
        }
        return count;
    }
    public static int subarraySumBetter(int[] nums, int k) {
        // Better->TC->O(N^2), SC->O(n)
        int prefix[]=new int[nums.length];
        int count=0;
        prefix[0]=nums[0];
        for(int i=1;i<nums.length;i++){
            prefix[i]=nums[i]+prefix[i-1];
        }
        System.out.println(Arrays.toString(prefix));
        for(int i = 0;i<nums.length;i++){
            int start = i;
            for(int j=i;j<nums.length;j++){
                int sum=0;
                int end = j;
                if(start==0) sum = prefix[end];
                else sum = prefix[end]-prefix[start-1];

                if(sum==k) count++;
            }
        }
        return count;
    }
        public static int subarraySumBetter2(int[] nums, int k) { //better-> TC->O(n^2)
            int count=0;
            for(int i=0;i<nums.length;i++){
                int sum=0;
                for(int j=i;j<nums.length;j++){
                    sum+=nums[j];
                    if(sum==k) count++;
                }
            }
            return count;
        }
    public static int subarraySumOptimal(int[] nums, int k) { 
        // -> Optimal TC->O(n), SC->O(n)
        HashMap<Integer,Integer> map = new HashMap<>();
        map.put(0,1); // initially putting sum 0 with count 1
        int preSum=0;
        int count=0;

        for(int i=0;i<nums.length;i++){
            preSum +=nums[i]; //storeing the prefix sum 
            int remove = preSum-k; // remove (s-k)
            count += map.getOrDefault(remove, 0); // if we find the (s-k) in map then we add its count to our result count
            map.put(preSum, map.getOrDefault(preSum, 0)+1); // adding the prefix sum to map with its count
        }

        return count;
    }

    public static void main(String[] args) {
        // int arr[]={1,1,1};
        int arr[]={1,2,1,2,3};
        // System.out.println("count is :"+subarraySumBrute(arr, 2));
        // System.out.println("count is :"+subarraySumBetter(arr, 3));
        System.out.println("count is :"+subarraySumOptimal(arr, 3));
        // System.out.println("count is :"+subarraySumBetter2(arr, 3));
    }
}
