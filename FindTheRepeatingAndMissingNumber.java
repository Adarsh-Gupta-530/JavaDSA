import java.util.*;
public class FindTheRepeatingAndMissingNumber {
    public static int[] findMissingRepeatingNumberBrute(int nums[]){
        int ans[] = new int[2];
        for(int i = 1;i<=nums.length;i++){
            int count = 0;
            for(int j=0;j<nums.length;j++){
                if(nums[j] == i) count++;
            }
            if(count == 2) ans[0] = i;
            if(count == 0) ans[1] = i;
        }
        return ans;
    }
    public static int[] findMissingRepeatingNumbers(int[] nums) {
        // better1-> TC->O(2n), SC->O(n)
        // int ans[] = new int[2];
        // HashMap<Integer, Integer> map = new HashMap<>();
        // for(int i=0;i<nums.length;i++){
        //     if(map.containsKey(nums[i])) map.put(nums[i], map.get(nums[i])+1);
        //     else map.put(nums[i], 1);
        // }
        // // System.out.println(map);
        // for(int i = 1;i<=nums.length;i++){
        //     if(!map.containsKey(i)){
        //         ans[1] = i;
        //         continue;
        //     } 
        //     if(map.get(i)==2){
        //         ans[0]=i;
        //     }
        // }
        // return ans;

        // better2 -> using frequency array -> TC->O(n),Sc->O(n)
        int ans[] = new int[2];
        int freq[] = new int[nums.length+1];
        for(int i = 0 ; i<nums.length;i++){
            int ele = nums[i];
            if(freq[ele]==1) freq[ele]+=1;
            else freq[ele] = 1;
        }
        for(int i=1;i<freq.length;i++){
            if(freq[i]==2) ans[0]=i;
            if(freq[i]==0) ans[1]=i;
        }
        return ans;
    } 
    public static int[] closeToOptimal(int nums[]){
        // TC->O(n), SC->O(1)
        int ans[]  = new int[2];
        long n = nums.length;
        // S , Sn -> x-y
        // S2, S2n
        long Sn = (n*(n+1))/2; // sum of n numbers 
        long S2n = (n*(n+1)*(2*n+1))/6; // sum of square of n natural numbers 
        long S=0;
        long S2=0;
        for(int i =0 ;i<n;i++){
            S +=nums[i]; // normal sum
            S2 +=(long)nums[i]*(long)nums[i]; // square sum
        }
        long val1 = S-Sn;  // x-y
        long val2 = S2 - S2n; // x^2 - y^2
        val2 = val2/val1; // gives x+y 
        long x = (val1+val2)/2;
        long y = (x-val1);

        return new int[]{(int)x,(int)y};

    }
    public static void main(String[] args) {
        // System.out.println(Arrays.toString(findMissingRepeatingNumbers(new int[]{3,4,5,1,1,})));
        // System.out.println(Arrays.toString(findMissingRepeatingNumberBrute(new int[]{3,4,5,1,1,})));
        System.out.print(Arrays.toString((closeToOptimal(new int[]{3,4,5,1,1}))));
    }
}
