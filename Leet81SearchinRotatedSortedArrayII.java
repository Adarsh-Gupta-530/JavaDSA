public class Leet81SearchinRotatedSortedArrayII {
    public static boolean search(int nums[], int target){
        // Tc->O(n), sc->O(1)
        int n = nums.length;
        int low = 0 , high = n-1;
        while(low<=high){
            int mid = (low+high)/2;
            if(nums[mid]==target) return true;
            if(nums[low]==nums[mid] && nums[mid]==nums[high]){
                low++;
                high--;
                continue;
            }

            if(nums[low] <= nums[mid]){
                if(nums[low]<=target && target <= nums[mid]){
                    high = mid-1;
                }else{
                    low = mid+1;
                }
            }else{
                if(nums[mid] <= target && target <= nums[high]){
                    low = mid+1;
                }else{
                    high = mid-1;
                }
            }
        }
        return false;
    }
    public static void main(String[] args) {
        int arr[] = {7,8,1,2,3,3,3,4,5,6};
        int target = 3;
        System.out.println(search(arr, target));
    }
}
