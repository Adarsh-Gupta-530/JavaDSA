import java.util.*;
public class countInversion2 { // TC =>O(nlogn) , SC->O(n)
    public static int merge(int left, int mid, int right, int nums[]){
        int[] temp = new int[right-left+1];
        int i = left; // iterator for left array
        int j = mid+1;// iterator for right array
        int k= 0; // iterator for temp array
        int count = 0;

        while(i<=mid && j<=right){
            if(nums[i]<=nums[j]){
                temp[k++] = nums[i++];
            }else{ // here the main logic written 
                temp[k++] = nums[j++];
                count += (mid-i+1); // adding count if left element is greater
            }
        }
        while(i<=mid) temp[k++] = nums[i++];
        while(j<=right) temp[k++] = nums[j++];

        for(k =0, i=left;k<temp.length;k++,i++){
            nums[i] = temp[k];
        }
        return count;
    }
    public static int  mergeSort(int left, int right, int nums[]){
        int count = 0;
        if(left>=right) return count;
        int mid = (right + left)/2;

        count += mergeSort(left, mid,nums);// left halve
        count += mergeSort(mid+1,right,nums);//right halve
        count += merge(left, mid, right, nums); // merging array 
        return count;
    }
    public static int numberOfInversions(int[] nums) {
        return mergeSort(0, nums.length-1, nums);
    }
    public static void main(String[] args) {
        // int arr[] = {2, 3, 7, 1, 3, 5};
        int arr[] = {5,2,3,4,1};
        // int arr[] = {-10, -5, 6, 11, 15, 17};
        // mergeSort(0,arr.length-1,arr);
        System.out.print(numberOfInversions(arr));
        // System.out.print(Arrays.toString(arr));
    }
}
