import java.util.*;
class GFGMinimumKConsecutiveBitFlips{
    public static int kBitFlipsBrute(int[] arr, int k) {
        // brute -> TC-O(n*k) SC-O(1)
        int count  = 0;
        for(int i = 0 ; i<arr.length; i++){
            if(arr[i] == 0){
                for(int j = i; j<=i+k; j++){
                    if(arr[k] == 0){
                        arr[k] = 1;
                    }else{
                        arr[k] = 0;
                    }
                }
                count ++ ;
            }
        }
        return count;
    }
    public static int kBitFlipsOptimal(int[] arr, int k) {
        //Optimal -> TC->O(n), O(k)
        int n = arr.length;
        int ans = 0;
        Queue<Integer> q = new LinkedList<>();
        for(int i =0; i<n;i++){
            if(!q.isEmpty() && q.peek()+k == i){
                q.remove();
            }

            if((arr[i]+q.size()) %2 == 0){
                if((i+k) > n){
                    return -1;
                }
                ans++;
                q.add(i);
            }
        }
        return ans;
    }
    public static void main(String[] args) {
        int arr[] = {1, 1, 0, 0, 0, 1, 1, 0, 1, 1, 1};
        int k = 2;
        System.out.println(kBitFlipsOptimal(arr, k));
    }
}