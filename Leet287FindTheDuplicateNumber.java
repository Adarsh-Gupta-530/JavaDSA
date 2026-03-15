import java.util.*;
public class Leet287FindTheDuplicateNumber {
    public static int findDuplicate(int[] nums) { // TC->O(n^2) -> TLE
        int n = nums.length;
        for(int i = 0; i<n;i++){
            for(int j = i+1; j<n;j++){
                if(nums[i]==nums[j]) return nums[j];
            }
        }
        return -1;
    }

    
    public static int findDuplicateBetter(int nums[]){
        //better1 -> TC->O(n), SC->O(n) 
        // HashMap<Integer, Integer> map = new HashMap<>();
        // for(int i = 0 ; i < nums.length;i++){
        //     if(map.containsKey(nums[i])) return nums[i];
        //     else map.put(nums[i],1);
        // }
        // return -1;

        // better 2 -> TC->O(nlogn), SC ->O(1)
        Arrays.sort(nums);
        for(int i = 0; i<nums.length-1;i++){
            if(nums[i]==nums[i+1] ) return nums[i];
        } 
        return -1;
    }
    public static int findDuplicateOptimal(int nums[]){ 
        int slow = 0;
        int fast = 0;
        // Step 1 ->  iterate untill they meet
        do{
            slow = nums[slow];
            fast = nums[nums[fast]];
        }while(slow!=fast);
        // Step 2 ->  get the start point of cycle
        slow = 0;
        while(slow!=fast){
            slow = nums[slow];
            fast = nums[fast];
        }
        return slow;

    }
    public static void main(String[] args) {
        int arr[ ] = {1,3,4,2,2};
        // int arr[] = {3,3,3,3,3};
        // int arr[] = {3,1,3,4,2};
        System.out.println(findDuplicateOptimal(arr));
    }
}
