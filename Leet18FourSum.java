import java.util.*;

public class Leet18FourSum {
    public static List<List<Integer>> fourSumBrute(int nums[], int target){
        // better ->O(n^3), SC->O(n)
        HashSet<List<Integer>> set = new HashSet<>();
        for(int i= 0; i<nums.length;i++){
            for(int j=i+1;j<nums.length;j++){
                HashMap<Long, Integer> map = new HashMap<>();
                for(int k=j+1;k<nums.length;k++){
                    // dont directly add these togather it gives the wrorng output for 2nd expl
                    long sum = nums[i]+nums[j];
                    sum+=nums[k];
                    long l = (long)target-sum;
                    if(map.containsKey(l)){
                        List<Integer> temp = new ArrayList<>(Arrays.asList(nums[i],nums[j],nums[k],(int)l));

                        Collections.sort(temp);
                        set.add(temp);
                    }
                    map.put((long)nums[k], k);
                }
            }
        }
        List<List<Integer>> result = new ArrayList<>(set); 
        return result;
    }
    public static List<List<Integer>> fourSumExtreamBrute(int nums[], int target){ // TC->O(n^4) , SC->O(no of quats) -> Gives TLE
        HashSet<List<Integer>> set = new HashSet();
        for(int i=0;i<nums.length;i++){
            for(int j=i+1;j<nums.length;j++){
                for(int k =j+1;k<nums.length;k++){
                    for(int l=k+1;l<nums.length;l++){
                        long sum = nums[i]+nums[j];
                        sum+=nums[k];
                        sum+=nums[l];
                        if(sum==target){
                            List<Integer> temp = new ArrayList<>(Arrays.asList(nums[i],nums[j],nums[k],nums[l]));
                            Collections.sort(temp);
                            set.add(temp);
                        }
                    }
                }
            }
        }
        List<List<Integer>> result = new ArrayList<>(set);
        return result;
    }
    public static List<List<Integer>> fourSumOptimal(int nums[], int target){
        //Optimal TC =>O(n^3), SC->O(1)
        List<List<Integer>> result = new ArrayList<>();
        Arrays.sort(nums);// step 1. Sort the array
        for(int i = 0;i<nums.length;i++){
            if(i>0 && nums[i]==nums[i-1]) continue;
            for(int j=i+1;j<nums.length;j++){
                if(j!=(i+1) && nums[j]==nums[j-1]) continue;
                int k = j+1;
                int l = nums.length-1;
                while(k<l){
                    long sum = nums[i]+nums[j];
                    sum+=nums[k];
                    sum+=nums[l];
                    if(sum>target){
                        l--;
                    }else if(sum<target){
                        k++;
                    }else{
                        List<Integer> temp = new ArrayList<>(Arrays.asList(nums[i],nums[j],nums[k],nums[l]));
                        result.add(temp);
                        k++;
                        l--;
                        while(k<l && nums[k]==nums[k-1]) k++;
                        while(k<l && nums[l]==nums[l+1]) l--;
                    }
                }
            }
        }
        
        return result;
    }
    public static void main(String[] args) {
        // int arr[] = {1,0,-1,0,-2,2};
        // int target = 0;

        // int arr[] = {1000000000,1000000000,1000000000,1000000000}; // very imp*** test case show that how int value overflow and gives wrong ans ->> this test case teachs how  brute force gives wrong ans
        // int target=-294967296;

        // int arr[] = {-5,5,4,-3,0,0,4,-2};
        // int target = 4;

        // int arr[]={1,1,1,2,2,2,3,3,3,4,4,4,5,5};
        // int target = 8;

        int arr[]={2,2,2,2};
        int target = 8;
        // System.out.print(fourSumExtreamBrute(arr, target));
        System.out.print(fourSumOptimal(arr, target));
    }
}
