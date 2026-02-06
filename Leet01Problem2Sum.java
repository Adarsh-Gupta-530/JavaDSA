import java.util.*;

public class Leet01Problem2Sum {
    public static int[] twoSumBrute(int nums[], int target){
        // brute force -> TC->O(n^2)
        int n=nums.length;
        int result[] = new int[2];
        for(int i=0;i<n;i++){
            for(int j=i+1;j<n;j++){
                if(nums[i]+nums[j] == target){
                    result[0]=i;
                    result[1]=j;
                    return result;
                }
            }
        }
        return result;
    }

    public static int[] twoSumBetter(int nums[], int target){ 
        //TC->O(2n) , SC->O(n) 
        int result[] = new int[2]; // taking result arr to return 
        HashMap<Integer,Integer> map = new HashMap<>(); // creating a hashmap to store values 

        for(int i=0;i<nums.length;i++){ // store all values in map with index
            map.put(nums[i], i);
        }

        for(int i=0;i<nums.length;i++){ 
            if(map.containsKey(target-nums[i]) &&  map.get(target-nums[i])!=i){ //suppose test case 2-> if 6-3 =3 map contains means true bt that was itself so we check intdex of 3 in map -> 3-> 0 and in array -> 0 so dont add it in the result array 
                result[0] = i; // store the first index
                result[1] = map.get(target-nums[i]); // store second as well
                return result; //return  both as ans 
            }
        }
        return result;
    }

    public static int[] twoSumOptimal(int nums[], int target){ 
        // optimal solution-> TC->O(n) in worst case else take lesser time then O(n)
        HashMap<Integer, Integer> map = new HashMap<>();

        for(int i=0;i<nums.length;i++){
            if(map.containsKey(target-nums[i])){  // if target-element exists  
                return new int[]{map.get(target-nums[i]), i}; //return both [index of target-element, index of element]
            }
            map.put(nums[i],i); // put them into map
        }
        return new int[]{0,0}; // if not exists return the empty array
    }

    public static boolean twoSumOptimalForVarity1(int nums[], int target){ // TC->O(nlogn)
        int left = 0;
        int right = nums.length-1;
        Arrays.sort(nums); // sort the array first
        while(left<right){
            if(nums[left]+nums[right]==target) return true; 
            else if(nums[left]+nums[right]>target)  right--;
            else left++;
        }
        return false;
    }
        public static void main(String[] args) {
            // int arr[] = {-2,1,-3,4,-1,2,1,-5,4}; 
            // int target = 6;

            // int arr[]= {2,7,11,15};
            // int target = 9;

            int arr[] = {3,2,4};
            int target = 6;

            // System.out.println(Arrays.toString(twoSumBrute(arr, target)));
            // System.out.println(Arrays.toString(twoSumBetter(arr, target)));
            System.out.println(Arrays.toString(twoSumOptimal(arr, target)));
            System.out.println(twoSumOptimalForVarity1(arr, target));
        }
}
