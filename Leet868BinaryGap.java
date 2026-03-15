public class Leet868BinaryGap {
    public static int binaryGapBrute(int n) { // brute force  -> TC->O((log n)²) and SC->O(log n) for binary string
        String binaryNum = Integer.toBinaryString(n);
        int maxCount = 0;
        for(int i = 0; i<binaryNum.length();i++){
            if(binaryNum.charAt(i)=='1'){
                int count = 0;
                int j = i+1;
                while(j<binaryNum.length()){
                    count++;
                    if(binaryNum.charAt(j)=='1'){
                        maxCount=Math.max(count, maxCount);
                        break;
                    }
                    j++;
                }
            }
        }
        return maxCount;
    }
    public static int binaryGapBetter(int n) { // TC->O(long), SC->O(logn)
        String binaryNum = Integer.toBinaryString(n);
        int maxCount = 0;
        int count = 0;
        for(int i = 0;i<binaryNum.length();i++){
            if(binaryNum.charAt(i)=='1'){
                count++;
                maxCount = Math.max(count, maxCount);
                count = 0;
            }else{
                count++;
            }

        }
        return maxCount;
    }
    public int binaryGapbetter2(int n) { // better using two pointer
        String binary = Integer.toBinaryString(n);
        int maxGap = 0;
        int prevIndex = -1;

        for (int i = 0; i < binary.length(); i++) {
            if (binary.charAt(i) == '1') {
                if (prevIndex != -1) {
                    maxGap = Math.max(maxGap, i - prevIndex);
                }
                prevIndex = i;
            }
        }

        return maxGap;
    }
    public static int binaryGapCloseToOptimal(int n) {
        // close to optimal => TC->O(logn), SC->O(1)
        int curr = 0;
        int prev = -1;
        int result = 0;

        while(n>0){
            if((n&1)>0){
                result = (prev!=-1) ?Math.max(result, curr-prev) : result;
                prev = curr;
            }
            curr++;
            n>>=1;
        }
        return result;

    } 
    public static int binaryGapOptimal(int n) {
        // optimal approach -> TC->O(1), SC->O(1)
        int prev = -1;
        int result = 0;
        for(int curr = 0;curr<32;curr++){ // going for 32 bits thats  why run for 32 times
            if(((n>>curr)&1)>0){ // means curr bit is set 
                result = (prev!=-1) ? Math.max(result, curr-prev) : result;
                prev = curr;
            }
        }
        return result;
    }
    public static void main(String[] args) {
        int n = 22;
        // System.out.println(Integer.toBinaryString(n));
        // System.out.println(binaryGapBrute(n));
        // System.out.println(binaryGapBetter(n));
        // System.out.println(binaryGapCloseToOptimal(n));
        System.out.println(binaryGapOptimal(n));
    }
}
