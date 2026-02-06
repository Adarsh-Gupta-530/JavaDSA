import java.util.*;

public class Leet1200MinimumAbsluteDifference{
    // public static List<List<Integer>> minimumAbsDifference(int[] arr) {
        
    // }
    public static List<List<Integer>> minimumAbsDifference(int arr[]){  // it will gives TLE for large size arrays
        List<List<Integer>> result = new ArrayList<>(); // result list 
        int minAbsDiff = Integer.MAX_VALUE; // track min abslute difference btw pairs
        for(int i=0;i<arr.length;i++){ // loops to get the minimum abs pair diff 
            for(int j=0; j<arr.length;j++){
                if(arr[i]<arr[j]){
                    int min = arr[j] - arr[i];
                    minAbsDiff = Math.min(minAbsDiff, min); // store in minAbsDiff
                }     
            }
        }
        for(int i=0;i<arr.length;i++){ //get those pairs whose diff is equals to minAbsDiff
            for(int j=0; j<arr.length;j++){
                if(arr[i]<arr[j] && (arr[j] - arr[i])==minAbsDiff){
                    List<Integer> pair = new ArrayList<>(); // add in to list 
                    pair.add(arr[i]);
                    pair.add(arr[j]);
                    result.add(pair); // add list int list of list
                }     
            }
        }
        result.sort( // sort the list of list in asc order
            Comparator.comparingInt((List<Integer> a) -> a.get(0))
                    .thenComparingInt(a -> a.get(1))
        );
        return result; // return the result 
    }
    public static void main(String[] args) {
        int arr[] = {4,2,1,3};
        System.out.print(minimumAbsDifference(arr));
    }
}