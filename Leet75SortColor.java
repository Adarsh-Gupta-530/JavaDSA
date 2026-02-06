import java.util.Arrays;

public class Leet75SortColor {
    public static void sortColorBrute(int nums[]){ //TC->O(n^2)
        // brute force -> using bubble sort
        for(int i=0;i<nums.length-1;i++){
            for(int j=0;j<nums.length-1;j++){
                if(nums[j]>nums[j+1]){
                    int temp = nums[j];
                    nums[j]= nums[j+1];
                    nums[j+1] = temp;
                }
            }
        }
    }
    public static void sortColorBetter(int nums[]){ 
        // TC->O(2n), SC->O(1)
        int countZeros = 0;
        int countOnes = 0;
        int countTwos = 0;

        // pass 1 ->O(n)
        for(int i=0;i<nums.length;i++){
            if(nums[i]==0) countZeros++;
            else if(nums[i]==1) countOnes++;
            else countTwos++;
        }
        // pass -> 2 ->O(n)
        int idx=0;
        for(int i=0;i<countZeros;i++){
            nums[idx++] = 0;
        }
        for(int i=0;i<countOnes;i++){
            nums[idx++] = 1;
        }
        for(int i=0;i<countTwos;i++){
            nums[idx++]=2;
        }
    }
    public static void sortColorOptimal(int nums[]){  // we traverse in a single pass single pass
        // Algorithm -> Dutch national flag algorithm
        int low=0;
        int mid=0;
        int high = nums.length-1;

        // 0's partition,   1's partition   ,    unsorted part,    2's partition
        // 0    to   low,   low+1 to mid-1,      mid   to  high,   hight+1 to n-1 

        while(mid<=high){ //-> TC->O(n) in worst case
            if(nums[mid]==0){  // for 0
                // swap(nums[l],nums[m])
                int temp = nums[mid];
                nums[mid] = nums[low];
                nums[low]=temp;
                //increase the mid
                mid++;
                // increase low too
                low++;
            }else if(nums[mid]==1){
                // just increse the mid 
                mid++;
            }else{
                // swap(nums[h],nums[m])
                int temp = nums[mid];
                nums[mid]=nums[high];
                nums[high]=temp;
                // decrease high
                high--;
            }
        }

        // after the loop array will got sorted
    }
    public static void main(String[] args) {
        // int arr[]= {2,0,2,1,1,0};
        // int arr[] = {1,2,0,1,2,0,0,1,2,0,2,1};
        // sortColorBrute(arr);
        // sortColorBetter(arr);
        // System.out.println(Arrays.toString(arr));


        int arr[] = {2,0,2,1,1,0,1,2,0,0};
        sortColorOptimal(arr);
        System.out.print(Arrays.toString(arr));
    }
    
}
