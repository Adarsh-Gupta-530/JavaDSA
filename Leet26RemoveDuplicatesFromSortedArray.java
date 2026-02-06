import java.util.*;
public class Leet26RemoveDuplicatesFromSortedArray {
    public static int removeDuplicates(int[] arr) { //brute force ->TC->O(n), SC->O(k)
        // way 1 -> USing hashmap -> but it throw an error sometimes because hashmap does not have any order to store values which may some time lead an error in sequence of sortness.
        /*HashMap<Integer, Integer> map = new HashMap<>();
        for(int i=0;i<arr.length;i++){
            if(map.containsKey(arr[i])) map.put(arr[i], map.get(arr[i])+1);
            else map.put(arr[i], 1);
        }
        Set<Integer> keys = map.keySet();
        int i=0;
        for(int key : keys){
            arr[i++] = key;
        }
        System.out.print(Arrays.toString(arr));
        return i;*/

        // way->2 -> using arraylist because it have a proper order so this will not mess the right order and gives the correct output.
        ArrayList<Integer> checker = new ArrayList<>();
        checker.add(arr[0]);//initialization
        int index=0;
        for(int i=1;i<arr.length;i++){
            if(checker.get(index)!=arr[i]){
                checker.add(arr[i]);
                index++;
            } 
        }
    
        int idx=0;
        for(int i=0;i<checker.size();i++){
            arr[idx++]=checker.get(i);
        }
        System.out.println(Arrays.toString(arr));
        return idx;
    }

    public static int removeDuplicatesBetter(int arr[]){ 
        // TC->O(n)
        // using two pointer
        int prev = arr[0]; // initialized 
        int curr;
        int idx=1; // trace the unique element indexes
        for(int i=1;i<arr.length;i++){
            curr = arr[i];
            // if(prev < curr){ // but can also usse this one
            if(prev != curr){ // this condition works proper
                arr[idx++] = curr;
                prev = curr;
            }
        }
        System.out.print(Arrays.toString(arr));
        return idx;
    }
    public static void main(String[] args) {
        // int arr[] = {-3,-1,0,0,0,3,3};
        int arr[] = {0,0,1,1,1,2,2,3,3,4}; 
        System.out.println(removeDuplicates(arr));
    }
}
