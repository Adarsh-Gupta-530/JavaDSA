import java.util.*;

public class LongestSubarrayWithAtmostTwoDistinctIntegers {
    public static int totalElementsBrute(int[] arr) {
        // Extream Brute force -> TC-> O(n^3), SC->O(n) 
        int maxLen = 0;
        for(int i = 0 ; i<arr.length; i++){
            for(int j = i+1; j<arr.length; j++){
                HashMap<Integer, Integer> map = new HashMap<>();
                for(int k =i; k<=j ; k++){
                    map.put(arr[k], map.getOrDefault(arr[k], 0)+1);
                }
                if(map.size() == 2){
                    maxLen = Math.max(maxLen, (j-i+1));
                }
            }
        }
        return maxLen;
        
    }
    public static int totalElementsBetter(int[] arr) {
        // better -> TC-> O(n^2), SC->O(n) 
        int maxLen = 0;
        for(int i = 0 ; i<arr.length; i++){
            HashMap<Integer, Integer> map  = new HashMap<>();
            for(int j = i; j<arr.length; j++){
                map.put(arr[j], map.getOrDefault(arr[j], 0)+1);
                if(map.size()>2) break;
                if(map.size() == 2) maxLen = Math.max(maxLen, (j-i+1));
            }

        }
        return maxLen;
    }
    public static int totalElementsOptimal(int arr[]){
        // optimal -> TC-> O(2n), SC->O(1) 
        int maxLen = 0;
        int left = 0;
        HashMap<Integer, Integer> map  = new HashMap<>();
        for(int i = 0 ; i<arr.length; i++){
            map.put(arr[i], map.getOrDefault(arr[i], 0)+1);// puting into a map
            while(map.size() > 2){
                map.put(arr[left], map.get(arr[left]) - 1);
                if(map.get(arr[left]) == 0){
                    map.remove(arr[left]);
                }
                left++;
            }
            maxLen = Math.max(maxLen, (i-left+1));
        }
        return maxLen;
    }
    public static void main(String[] args) {
        // int arr[] = {1, 2, 1, 3, 4};
        int arr[] = {1,1,1,2,3,4,4};
        // int arr[] = {1, 2, 3, 4, 2, 3};
        // int arr[] = {7 ,14 ,17 ,18 ,5 ,9 ,20 ,14 ,19, 7, 16, 11, 7 ,11 ,10 ,10 ,15 ,6 ,14};
        System.out.println(totalElementsOptimal(arr));
    }
}
