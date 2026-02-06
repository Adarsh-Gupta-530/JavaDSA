import java.util.*;

public class MajorityElement {
    // Solving for more then n/3 times .

    public static int majorityElement(int arr[]){ // better approach -> O(n);
        HashMap<Integer, Integer> map = new HashMap<>();
        for(int i=0;i<arr.length;i++){ // store freq in map
            int num = arr[i];
            if(map.containsKey(num)){
                map.put(num, map.get(num)+1);
            }else{
                map.put(num,1);
            }  
        }
        // System.out.print(map);
        Set<Integer> keys = map.keySet();
        for(int key : keys){
            if(map.get(key) > arr.length/3){
                return key;
            }
        }
        return -1;
    }

    public static int majorityOptimal(int arr[]){
        // boyer moore voting algorithm
        int majority = arr[0];
        int voting = 1;

        for(int i=1;i<arr.length;i++){
            if(arr[i]==majority){
                voting++;
            }else if(arr[i] != majority && voting>=1){
                voting--;
            }else{
                majority=arr[i];
                voting = 1;
            }
        }
        return majority;

    }
    public static void main(String[] args) {
        int[] arr = {1,3,2,5,1,3,1,5,1};
        System.out.println("Element : "+majorityOptimal(arr)+" is majority elemwnt.");
    }
}
