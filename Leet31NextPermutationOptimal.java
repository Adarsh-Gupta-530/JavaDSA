import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Leet31NextPermutationOptimal{
    public static void nextPermutation(int[] nums) { // O(3n), sc->O(1)
        // Algorithm works in 3steps 
        int n = nums.length;
        int idx = -1;
        // 1. -> find the break point/longest matched prefix
        for(int i= n-2; i>=0;i--){
            if(nums[i]<nums[i+1]){
                idx = i; // store the breake point. 
                break;
            }
        }
        if(idx==-1){ // if idx still -1 means just return the reverse of it because it reaches the last parmutation.
            reverse(nums,0,n-1);
            return;
        }
        // 2. -> find element which is greater in the array after break point and samallest of in the greates and swap it 
        for(int i=n-1;i>idx;i--){
            if(nums[i]>nums[idx]){
                swap(nums, idx, i); // swap it 
                break;
            }
        }
        // 3. reverse the array from breake point/ sort them to get the ans  
        reverse(nums, idx+1,n-1);
    }
    public static void swap(int nums[], int i, int j){ //swap
        int temp = nums[i];
        nums[i] = nums[j];
        nums[j] = temp;
    }
    public static void reverse(int nums[], int i, int j){
        if(i>=j)
            return;
        swap(nums, i, j);
        reverse(nums, i+1, j-1);
    }
    public static void main(String[] args) {
        // int arr[] = {1,2,3};
        int arr[] = {1,1};
        nextPermutation(arr);
        System.out.print(Arrays.toString(arr));
    }
}