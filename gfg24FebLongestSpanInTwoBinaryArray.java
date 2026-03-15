import java.util.HashMap;

public class gfg24FebLongestSpanInTwoBinaryArray{
    public static int equalSumSpan(int[] a1, int[] a2) { // better -> TC->O(n2), Sc->O(2n)
        int maxSpanLength = 0;
        int preSum1[] = new int[a1.length];
        int preSum2[] = new int[a2.length];

        preSum1[0] = a1[0];
        preSum2[0] = a2[0];

        for(int i = 1; i < a1.length; i++ ){
            preSum1[i] = preSum1[i-1]+a1[i];
            preSum2[i] = preSum2[i-1]+a2[i];
        }

        for(int i = 0 ;i<a1.length; i++){
            for(int j=i; j<a1.length;j++){
                int sum1 = 0;
                int sum2 = 0;
                if(i==j){
                    sum1 = a1[j];
                    sum2 = a2[j];
                }else{
                    sum1 = (i==0) ? preSum1[j] : preSum1[j]-preSum1[i-1];
                    sum2 = (i==0) ? preSum2[j] : preSum2[j]-preSum2[i-1];
                }
                

                if(sum1==sum2){
                    int currLen = j-i+1;
                    maxSpanLength = Math.max(maxSpanLength, currLen);
                }
            }
        }
        return maxSpanLength;
    }

    public static int equalSumSpanOptimal(int[] a1, int[] a2) {
         int n = a1.length;
        HashMap<Integer, Integer> map = new HashMap<>();
        
        int prefixSum = 0;
        int maxLen = 0;

        map.put(0, -1);

        for (int i = 0; i < n; i++) {
            
            prefixSum += (a1[i] - a2[i]);

            if (map.containsKey(prefixSum)) {
                int prevIndex = map.get(prefixSum);
                maxLen = Math.max(maxLen, i - prevIndex);
            } else {
                map.put(prefixSum, i);
            }
        }

        return maxLen;
    }
    public static void main(String[] args) {
        int arr1[] = {0, 1, 0, 0, 0, 0};
        int arr2[] = {1, 0, 1, 0, 0, 1};
        // System.out.println(equalSumSpan(arr1, arr2));
        System.out.println(equalSumSpanOptimal(arr1, arr2));
    }
}