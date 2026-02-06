import java.util.*;

public class Leet2149RearrangeArrayElementBySign {
    public static int[] rearrangeArray(int[] nums) { 
        // Brute Force -> SC -> O(n)+O(n) = O(2n) , TC->O(n)+O(n) -> O(2n)
        ArrayList<Integer> pos = new ArrayList<>();
        ArrayList<Integer> neg = new ArrayList<>();
        for(int i = 0; i<nums.length;i++){  // TC-> O(n)
            if(nums[i]>0){
                pos.add(nums[i]); // storing positive values
            }else{
                neg.add(nums[i]);  // storing neagtive value
            }
        }
        int posIdx =0;
        int negIdx =0; 
        for(int i=0; i<nums.length;i++){
            if(i%2==0){
                nums[i] = pos.get(posIdx);
                posIdx++;
            }else{
                nums[i]= neg.get(negIdx);
                negIdx++;
            }
        }
        return nums;
    }
    public static void main(String[] args) {
        int arr[] = {3,1,-2,-5,2,-4};
        System.out.println(Arrays.toString(rearrangeArray(arr)));
    }
}
