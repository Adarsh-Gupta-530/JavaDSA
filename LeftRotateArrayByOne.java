import java.util.*;
public class LeftRotateArrayByOne {
    public static void rotateArrayByOne(int[] nums) {
        // brute force ->TC->O(n)
        int leftFirst = nums[0];  // store first left elemet in temprary variable 

        for(int i=1;i<nums.length;i++){
            nums[i-1]=nums[i];  // shift all elements to previous location/ in previous index
        }
        nums[nums.length-1] = leftFirst;  // store the first element into last index 
        System.out.print(Arrays.toString(nums)); // printing arr;
    }
    public static void rotateArrayByKPosition(int[] arr, int k) {
        // brute force -> TC-> O(n), SC->O(n)
        int n=arr.length;
        int copyArr[] = new int[n];
        for(int i=0;i<n;i++){ // copying int new arr from i+k%n position
            int idx = (i+k)%n;
            copyArr[idx] = arr[i]; 
        }

        for(int i=0;i<n;i++){ // storing back rotated copyArr into original array
            arr[i] = copyArr[i]; 
        }
        System.out.println(Arrays.toString(copyArr));
    }
    public static void rotateArrayByKPositionOptimal(int[] arr, int k) {
        k%=arr.length; // in case k is greater than array length
        reverse(arr, 0, arr.length-1);
        reverse(arr, 0, k-1);
        reverse(arr, k, arr.length-1);

        System.out.println(Arrays.toString(arr));
        // System.out.println(Arrays.toString(arr));
    }
    public static void reverse(int arr[], int start, int end ){
        if(start >= end ){
            return;
        }
        // swap
        int temp = arr[start];
        arr[start] = arr[end];
        arr[end] = temp;

        reverse(arr,start+1,end-1);
        // System.out.println(Arrays.toString(arr));
    } 
    public static void main(String[] args) {
        // int arr[] = {1, 2, 3, 4, 5};
        // // int arr[] = {-1,-2,0,3,4,5};
        // rotateArrayByOne(arr);

        int arr[] = {1,2,3,4,5,6,7};
        int k=11;
        // reverse(arr, 0, arr.length-1);
        rotateArrayByKPositionOptimal(arr, k);

    }
}
