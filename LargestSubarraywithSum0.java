import java.util.Arrays;

public class LargestSubarraywithSum0 {
    public static int Brute(int nums[]){
        // TC ->O(n^3)
        int maxCount = 0;
        for(int i= 0; i<nums.length;i++){
            for(int j=i;j<nums.length;j++){
                int sum=0;
                int count = 0;
                for(int k=i; k<=j;k++){
                    sum+=nums[k];
                    count++;
                }
                if(sum == 0){
                    maxCount=Math.max(maxCount, count);
                }
            }
        }
        return maxCount;
    }
    public static int Better(int nums[]){
        // better ->O(n^2)
        int maxCount = 0;
        int prefix[] = new int[nums.length];
        prefix[0]=nums[0];
        for(int i=1;i<nums.length;i++){
            prefix[i] = prefix[i-1]+nums[i];
        }
        for(int i=0;i<nums.length;i++){
            for(int j = i+1; j<nums.length;j++){
                int sum = i==0 ? prefix[j] : prefix[j]-prefix[i-1];
                if(sum==0){
                    int count = j-i+1;
                    maxCount = Math.max(maxCount, count);
                }
            }
        }
        return maxCount;
    } 
    // optimal -> O(n),SC->O(n)
    public static void main(String[] args) {
        // int arr[] = {15, -2, 2, -8, 1, 7, 10, 23}; // total subarrays are => (n*(n+1))/2
        // int arr[] = {2, 10, 4};
        int arr[] = {1, 0, -4, 3, 1, 0};
        // System.out.println(Brute(arr));
        System.out.println(Better(arr));
    }
}
