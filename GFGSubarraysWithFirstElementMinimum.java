public class GFGSubarraysWithFirstElementMinimum {
    public static int countSubarraysBrute(int[] arr) {
        int count = 0;
        for(int i = 0; i<arr.length; i++){
            for(int j =i; j<arr.length; j++){
                count += isCountSubarray(arr, i, j);
            }
        }
        return count;
    }
    public static int isCountSubarray(int[] arr, int i, int j){
        if(arr.length == 1) return 1;
        int min = arr[i];  // suppose first is minimum
        for(int k = i+1; k<=j;k++){
            if(arr[k]<min){
                return 0; 
            }
        }
        return 1;
    }
    public static int countSubarraysBetter(int[] arr) {
        // better ->  TC=>O(n^2), SC=>O(1) 
        int count =0;
        for(int i =0; i<arr.length; i++){
            int min = arr[i];
            for(int j = i; j<arr.length; j++){
                min = Math.min(min, arr[j]);
                if(arr[i]==min){
                    count++;
                }
            }
        }
        return count;
    }
    public static void main(String[] args) {
        int arr[] = {1, 2, 1};
        System.out.println(countSubarraysBetter(arr));
    }
}
