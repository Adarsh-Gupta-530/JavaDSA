import java.util.Arrays;

public class Leet36FirstAndLastOccuranceInanArray {
    public static int[] searchRange(int[] nums, int target){
        int n = nums.length;
        int lb = lowerBoundBS(nums, n, target);
        if(lb == n || nums[lb]!=target) return new int[]{-1,-1};
        return new int[]{lb, upperBoundBS(nums, n, target)-1};
    }
    public static int lowerBoundBS(int[] arr,int n, int target){
        int low = 0;
        int high = n-1;
        int ans = n;
        while(low<=high){
            int mid  = (low+high)/2;
            if(arr[mid]>=target){
                ans = mid;
                high = mid-1;
            }else{
                low = mid+1;
            }
        }
        return ans;
    }
    public static int upperBoundBS(int[] arr, int n, int target){
        int low =0;
        int high = n-1;
        int ans = n;
        while(low<=high){
            int mid  = (low+high)/2;
            if(arr[mid]>target){
                ans = mid;
                high = mid-1;
            }else{
                low = mid+1;
            }
        }
        return ans;
    }
    public static void main(String[] args) {
        int arr[] = {5, 7, 7, 8, 8, 10};
        int target = 11;
        System.out.println(Arrays.toString(searchRange(arr, target)));
    }
}
