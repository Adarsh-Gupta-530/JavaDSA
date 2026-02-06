import java.util.*;
public class Leet645SetMisMatch{  //brute force approach-> TC->O(n), SC->O(n) 
    public static int[] findErrorNums(int[] arr) {  //brute force -> TC->O(n), SC->O(n)
        int result[] = new int[2];
        HashMap<Integer, Integer> map = new HashMap<>(); // hashmap to store the frequency of elements.

        // phase 1;
        for(int i=0;i<arr.length;i++){ // storing values in hash map
            if(map.containsKey(arr[i])) map.put(arr[i], map.get(arr[i])+1); 
            else map.put(arr[i], 1);
        }

        // phase2 :check
        for(int i=1;i<=arr.length;i++){
            if(map.get(arr[i-1])==2){ // which element occurs more then one time 
                result[0] = arr[i-1];
            }
            if(!map.containsKey(i)){ // which element is skipped 
                result[1] = i; 
            }
        }
        return result;
    }

    // way2-> using boolean array -> TC->O(n), SC->O(n)

    // way3 -> better approach -> by negative arr numbers 
    public static int[] findErrorNumsBetter(int arr[]){ //TC->O(n)
        int n=arr.length;
        int missing = -1;
        int duplicate = -1;
        for(int i=0;i<n;i++){ // get duplicate
            if(arr[Math.abs(arr[i])-1] < 0){  // if value is already in minus means already visited
                duplicate = arr[i]; // that is our duplicate value
            }else{
                arr[Math.abs(arr[i])-1]*=(-1); //if not visited make it minus to mark as visited
            }
        }

        // for missing number
        for(int i=0;i<n;i++){
            if(arr[i]>0){ // if vslue is positive means we can'nt reach this index 
                missing = i+1; // means (i + 1) value is missing
            }
        }
        return new int[]{duplicate,missing};
    }
    public static void main(String[] args) {
        int arr[]={1,2,2,4};
        // int arr[] = {1,1};
        // int arr[] = {2,2};
       System.out.println(Arrays.toString(findErrorNumsBetter(arr)));

    }
}