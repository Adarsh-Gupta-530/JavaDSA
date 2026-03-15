import java.util.*;
public class GFGPythagoreanTriplet {
    public static boolean isTripletBrute(int arr[]){
        // brute -> O(n^3), o(1)
        for(int i = 0; i<arr.length;i++ ){
            for(int j = i+1; j<arr.length; j++){
                int l = arr[i]*arr[i];
                int b = arr[j] * arr[j];
                for(int k = j+1; k<arr.length;k++){
                    int h = arr[k]*arr[k];
                    if(l+b == h){
                        return true;
                    } 
                }
            }
        }
        return false;
    }
    public static boolean isTripletBetter(int arr[]){
        // TC->O(n^2), SC->O(n)
        HashMap<Integer, Integer> squareMap = new HashMap<>();
        for(int i = 0; i< arr.length;i++){
            squareMap.put(arr[i]*arr[i], i);
        }
        for(int i = 0; i<arr.length; i++){
            for(int j = i+1; j<arr.length;j++){
                int l = arr[i] * arr[i];
                int b = arr[j]*arr[j];
                int h = l+b;
                if(squareMap.containsKey(h) && (squareMap.get(h) != i || squareMap.get(h)!=j)){
                    return true;
                }
            }
        }
        return false;
    }
    public static boolean isTripletOptimal(int arr[]){
        // Optimal -> TC-> O(n^2), O(n) -> inside constaraints
        Set<Integer> set = new HashSet<>();
        for(int i = 0; i<arr.length; i++){
            set.add(arr[i]*arr[i]);
        }
        for(int a : set){
            for(int b : set){
                if(a!=b){
                    if(set.contains(a + b)) {
                        return true;
                    }
                }
            }
        }
        return false;
    }
    public static void main(String[] args) {
        // int[] arr = {3, 2, 4, 6, 5};
        int arr[] = {3, 8, 5};
        System.out.println(isTripletOptimal(arr));
    }
}
