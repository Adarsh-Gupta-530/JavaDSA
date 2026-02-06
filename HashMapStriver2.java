import java.util.*;

public class HashMapStriver2 {
    // 2. count frequency of elements in an array using HashMap

    public static List<List<Integer>> countFrequencies(int nums[]){
        List<List<Integer>> result = new ArrayList<>(); // result to return 
        HashMap<Integer, Integer> map = new HashMap<>(); // map to store frequency of array items  
        for(int i=0; i<nums.length;i++){
            if(map.containsKey(nums[i])){
                map.put(nums[i], map.get(nums[i])+1);
            }else{
                map.put(nums[i], 1);
            }
        }
        // System.out.print(map);
        Set<Integer> keys = map.keySet();
        for(Integer key : keys){
            List<Integer> pair = new ArrayList<>(); // creating inner lists 
            pair.add(key); // storing key 
            pair.add(map.get(key)); // storing its frequency 
            result.add(pair); // storing List of pair of keys in list of list of integers 
        }
        return result; // returning result 
    }


    // get most frequent element in the array -> if more than one element have same highest frequency return the smallest one
    public static int mostFrequentElement(int arr[]){
        HashMap<Integer, Integer> map = new HashMap<>(); // store frequency of arrays elements 
        int result = Integer.MAX_VALUE;
        for(int i=0; i<arr.length;i++){
            if(map.containsKey(arr[i])) map.put(arr[i], map.get(arr[i])+1);
            else map.put(arr[i], 1);
        }
        // System.out.print(map);
        Set<Integer> keys = map.keySet();
        int maxFreq = 0;
        for(Integer key : keys){
            if(map.get(key)>maxFreq){
                maxFreq = map.get(key);
            }
        }
        for(Integer key : keys){
            if(map.get(key) == maxFreq && key < result){
                result = key;
            }
        }
        return result;
    }
    public static void main(String[] args) {
        int arr[] = {1,2,3,2,2,1,4,5};

        // 2. return the list<list<Integer>> which stores the count of frequencies of elements 
        // System.out.println(countFrequencies(arr));

        // 3. Highest occuring element in the array -> return the element have highest frequency or if more then elements having same highest freqency return the smallest one;
        System.out.println("Element having most freq is : "+mostFrequentElement(arr));
    }
}
