import java.util.Arrays;

import javax.sound.midi.SysexMessage;

public class Leet88MergeSortedArray {
    public static void mergeTwoSortedArrBrute(int[] nums1, int m, int[] nums2, int n) {
        // brute force - >O(n+m)+O(logn) , SC=>O(n+m)
        if(n == 0) return;
        int ans[] = new int[m+n];
        int left = 0;
        int right = 0;
        int idx = 0;
        while(left<m && right<n){ // using O(m+n) time 
            if(nums1[left]<=nums2[right]){
                ans[idx++] = nums1[left++];
            }else{
                ans[idx++] = nums2[right++];
            }
        }
        while(left!=m) 
            ans[idx++]=nums1[left++];
        while(right!=n)
            ans[idx++] = nums2[right++];

        System.out.println((Arrays.toString(ans)));
        // for(int i=0;i<ans.length;i++) // using O(m+n) space
        //     nums1[i] = ans[i];
    }

    public static void merge(int[] nums1, int m, int[] nums2, int n) { // TC->O(n+m), SC->O(1)
        if(n == 0) return;
        int idx = m+n-1;
        int i = m-1;
        int j = n-1;
        while(i>=0 && j>=0){
            if(nums1[i]>=nums2[j]) nums1[idx--] = nums1[i--];
            else nums1[idx--] = nums2[j--];
        }
        while(j>=0){
            nums1[idx--] = nums2[j--];
        }
    }
    public static void main(String[] args) {
        // int arr1[] =  {1,2,3, 0 , 0 , 0};
        // int arr2[] = {2,5,6};
        int arr1[] =  {4,5,6, 0 , 0 , 0};
        int arr2[] = {1,2,3};
        // mergeTwoSortedArrBrute(arr1, 3, arr2, 3);
        // System.out.println(Arrays.toString(arr1));
        merge(arr1, 3, arr2, 3);
        System.out.println(Arrays.toString(arr1));
    }
}
