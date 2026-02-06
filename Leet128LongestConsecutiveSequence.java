import java.util.*;
public class Leet128LongestConsecutiveSequence {
    public static int longestConsecutiveBruteForce(int[] nums) { 
        // TC ->O(n^2) approax 
        int largest=0;
        for(int i=0; i<nums.length;i++){
            int currVal = nums[i];
            int count = 1;
            while(linearSearch(nums, currVal+1)){
                currVal +=1; // search for the next value in the array
                count++; // increase the count 
                largest = Math.max(largest, count);
            }
        }
        return largest;
    }
    public static boolean linearSearch(int nums[], int target){
        for(int i=0;i<nums.length;i++){
            if(nums[i]==target){
                return true;
            }
        }
        return false;
    }

    // better approach
    public static int longestConsecutiveBetter(int[] nums) { 
        Arrays.sort(nums); // sort the array ->O(nlogn)

        int largest=0;
        int count = 1;
        for(int i=0;i<nums.length-1;i++){ // tc->O(n)
            if(nums[i] == nums[i+1]) {  // if next is duplicate element the just continue 
                continue;
            }else if(nums[i]+1 == nums[i+1]){ // else if nums[i]+1==nums[i+1] -> means consicutiveness happends.
                count++; // increase  count by 1 
                largest = Math.max(count, largest); //  store the maximum consicutive length
            }else{
                count = 1;
            }    
        }
        return largest;
    }
    // better approach2
    public static int longestConsecutiveBetter2(int[] nums) {
        Arrays.sort(nums); // O(nlogn)

        int largest = 1;
        int currCount = 1;
        int last_Smallest = nums[0];
        for (int i = 1; i < nums.length; i++) {
            int currEle = nums[i];
            if (currEle - 1 == last_Smallest) {
                currCount++;
                last_Smallest = currEle;
            } 
            else if (currEle == last_Smallest) {
                continue; // skip duplicates
            } 
            else {
                last_Smallest = currEle;
                currCount = 1;
            }
            largest = Math.max(largest, currCount);
        }
        return largest;
    } 

    // optimal 
    public static int longestConsecutiveOptimal(int[] nums) { //TC->O(3n)
        int n=nums.length;
        if(n==0) return 0;
        int count=0;
        int largest = 1; // largest is one for any element initially
        HashMap<Integer, Integer> map = new HashMap<>(); // sore all the elements 
        for(int i=0; i<n;i++ ){ // storing into map ->O(n)
            if(map.containsKey(nums[i])) map.put(nums[i], map.get(nums[i])+1);
            else map.put(nums[i], 1);
        }

        Set<Integer> keys = map.keySet();
        for(int key : keys){ // O(2n)
            int currEle = key;
            count = 1;
            while(map.containsKey(currEle+1)){ // if greater value isnt exists means i am the start point.
                currEle = currEle+1;
                count++;
            }
            largest = Math.max(largest, count);
        }
        return largest;
    }

    public static void main(String[] args) {
        // int arr[] = {0,0,100,4,200,1,3,2};
        int arr[] = {0,3,7,2,5,8,4,6,0,1};
        // System.out.println(longestConsecutiveBruteForce(arr));
        // System.out.println(longestConsecutiveBetter(arr));
        // System.out.println(longestConsecutiveBetter2(arr));
        System.out.println(longestConsecutiveBetter(arr));
    }
}
