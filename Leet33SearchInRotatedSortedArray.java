public class Leet33SearchInRotatedSortedArray {
    public static int search(int[] nums, int target) { // TC-> O(logn)
        int n=nums.length;
        int left = 0;
        int right = n-1;
        while(left<right){// step 1 => find the shift value from where the array  is rotated
            int mid = (left+right)/2; // mid
        // if array is sorted this condition isnt possible if become true means there is rotation
            if(nums[mid]>nums[right]) left = mid+1;  // move left to mid+1
            else  right = mid; // otherwise right is equal to mid 
        } // left==right
        int shift = left;   // or we can also write the right as well
        // reInitialize both pointers
        left = 0;
        right = n-1;
        // atep 2-> now moving for the binary search
        while(left<=right){
            int mid = (left+right)/2;
            int realMid =(mid+shift) % n; //  to get the real mid with out rotate the array

            if(nums[realMid]==target) return realMid;
            else if(nums[realMid]>target) right = mid-1;
            else left = mid+1;
        }
        return -1; // if isnt present return -1
    }
    public static void main(String[] args) {
        int arr[] ={4,5,6,7,0,1,2};
        int target =0;
        System.out.println("Value present at index : "+search(arr, target));
    }
}
