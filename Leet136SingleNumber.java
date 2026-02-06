import java.util.*;
public class Leet136SingleNumber {
        public static int singleNumberBruteForce(int nums[]){
            //brute force approach -> TC->O(n^2)
            if(nums.length==1) return nums[0];
            for(int i=0;i<nums.length;i++){
                int count=0;
                for(int j = 0;j<nums.length;j++){
                    if(nums[j]==nums[i]) count++;
                }
                if(count==1) return nums[i];
            } 
            return -1;
        }

        public static int singleNumberBetter(int[] nums) {
        // better force ->TC->O(n), SC->O(n/2 + 1)
        if(nums.length==1) return nums[0]; // bc 
        HashMap<Integer, Integer> map = new HashMap<>();
        for(int i=0;i<nums.length;i++){
            if(map.containsKey(nums[i])) map.put(nums[i], map.get(nums[i])+1);
            else map.put(nums[i], 1);
        }
        Set<Integer> keys = map.keySet();
        for(int key : keys){
            if(map.get(key)==1){
                return key;
            }
        }
        return -1;
    }
    public static int singleNumberOptimal(int nums[]){ // using xor -> TC->O(n), SC->O(1)
        int xor = 0; 
        for(int i=0;i<nums.length;i++){
            xor = xor ^ nums[i];
        }
        return xor;
    }
    public static void main(String[] args) {
        // int arr[] = {1,2,3,2,3};
        int arr[] = {4,1,2,1,2};
        // int arr[]={5};
        System.out.println("Single Integer in Array is : "+singleNumberOptimal(arr)); 
    }
}
