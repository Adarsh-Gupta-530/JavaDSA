import java.util.Arrays;

public class mergeSort {
    public static void merge(int left, int mid, int right, int nums[]){
        int[] temp = new int[right-left+1];
        int i = left; // iterator for left array
        int j = mid+1;// iterator for right array
        int k= 0; // iterator for temp array

        while(i<=mid && j<=right){
            if(nums[i]<nums[j]){
                temp[k++] = nums[i++];
            }else{
                temp[k++] = nums[j++];
            }
        }
        while(i<=mid) temp[k++] = nums[i++];
        while(j<=right) temp[k++] = nums[j++];

        for(k =0, i=left;k<temp.length;k++,i++){
            nums[i] = temp[k];
        }
    }
    public static void mergeSort(int left, int right, int nums[]){
        if(left>=right) return;
        int mid = (right + left)/2;

        mergeSort(left, mid,nums);// left halve
        mergeSort(mid+1,right,nums);//right halve
        merge(left, mid, right, nums); // merging array 
    }
    public static void main(String[] args) {
        int arr[] = {3,2,4,52,2,4,2,6,83,3,6,34,90};
        mergeSort(0,arr.length-1, arr);
        System.out.print(Arrays.toString(arr));
    }
}
