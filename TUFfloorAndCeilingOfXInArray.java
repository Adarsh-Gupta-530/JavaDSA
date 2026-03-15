import java.util.Arrays;

public class TUFfloorAndCeilingOfXInArray {
    public static int[] getFloorAndCeil(int[] nums, int x){
        int n = nums.length;
        int low = 0, high = n - 1;
        int floor = -1, ceil = -1;

        while(low <= high){
            int mid = (low + high) / 2;

            if(nums[mid] == x){
                floor = nums[mid];
                ceil = nums[mid];
                break;
            }

            if(nums[mid] < x){
                floor = nums[mid];  // possible floor
                low = mid + 1;
            } 
            else{
                ceil = nums[mid];   // possible ceil
                high = mid - 1;
            }
        }
        return new int[]{floor, ceil};
    }
    
    public static void main(String[] args) {
        int arr[] = {3, 4, 4,5, 7, 8, 10};
        int x = 5;
        System.out.println(Arrays.toString(getFloorAndCeil(arr, x)));
    }
}
