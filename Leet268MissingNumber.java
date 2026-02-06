import java.util.*;

public class Leet268MissingNumber{

    public static int missingNumber(int arr[]){ // brute force -> TC->O(n) , SC->O(n)

        HashMap<Integer, Integer> map = new HashMap<>();

        for(int i=0;i<arr.length;i++){ // storing arr element into map
            if(map.containsKey(arr[i])) map.put(arr[i], map.get(arr[i])+1);
            else map.put(arr[i], 1);
        }
        for(int i=0;i<=arr.length;i++){ //  check for all 0 to n element which is not present 
            if(!map.containsKey(i)) return i; // return that number i ;
        }
        return -1; // otherwise return -1;
    }
    public static void main(String[] args) {
        int nums[] = {3,0,1};
        System.out.println(missingNumber(nums));
    }
}
