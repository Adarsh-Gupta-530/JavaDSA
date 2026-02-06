import java.util.*;
public class Leet15Problem3sum { // brute force-> TC ->O(n^3), Sc->O(no. of triplaets)
    public static List<List<Integer>> threeSumBrute(int nums[]){ 
        HashSet<List<Integer>> set = new HashSet<>(); 
        //to store unique List which sum is zero
        for(int i=0;i<nums.length;i++){
            for(int j=i+1;j<nums.length;j++){
                for(int k=j+1;k<nums.length;k++){
                    if(nums[i]+nums[j]+nums[k]==0){ 
                        List<Integer> temp = new ArrayList<>();
                        temp.add(nums[i]);
                        temp.add(nums[j]);
                        temp.add(nums[k]);
                        Collections.sort(temp); //in sorted manner -> TC->O(1)

                        set.add(temp); 
                    }
                }
            }
        }
        List<List<Integer>> ans  = new ArrayList<>(set);
        return ans;
    }

    public static List<List<Integer>> threeSumBetter(int nums[]){
        // better ->TC->O(n^2), SC->O(n)+O(no. of triplets)
        HashSet<List<Integer>> set = new HashSet<>();
        for(int i= 0; i<nums.length;i++){
            HashMap<Integer, Integer> map = new HashMap<>(); // hash map to store it 
            for(int j = i+1;j<nums.length;j++){
                int k = -(nums[i]+nums[j]);
                if(map.containsKey(k)){
                    List<Integer> temp = new ArrayList<>();
                    temp.add(nums[i]);
                    temp.add(nums[j]);
                    temp.add(k);

                    Collections.sort(temp); // TC->O(1)
                    set.add(temp);
                }
                map.put(nums[j], j); // store it into map.
            }
        }
        List<List<Integer>> result = new ArrayList<>(set);
        return result;
    }

    public static List<List<Integer>> threeSumOptimal(int nums[]){ // TC->O(n*n)+O(nlogn) = O(n^2)
        List<List<Integer>> result = new ArrayList<>();
        Arrays.sort(nums);// strep 1 -> sort the array; // TC->O(n)
        for(int i=0;i<nums.length;i++){  //TC->O(n)
            if(i>0 && nums[i]==nums[i-1]) continue;
            int j = i+1;
            int k= nums.length-1;
            while(j<k){ // TC->O(n)
                int sum = nums[i]+nums[j]+nums[k];
                if(sum<0) j++;  // step 2 -> if sum is less then 0 make increase value of j
                else if(sum>0) k--; // step 3; if sum is grater then 0 make decrease the value of k
                else{
                    List<Integer> temp = new ArrayList<>(Arrays.asList(nums[i], nums[j], nums[k])); // triplet findes store it into list 
                    result.add(temp);
                    j++; // inc j
                    k--; // dec k

                    while(j<k && nums[j]==nums[j-1]) j++;//move j until gets diff from previous value
                    while(j<k && nums[k]==nums[k+1]) k--;//move k until gets diff from next value
                }
            }
        }
        return result;
    }
    public static void main(String[] args) {
        // int arr[] = {-1,0,1,2,-1,-4};
        // int arr[] = {0,1,1};
        // int arr[] = {0,0,0,0};
        // int arr[] = {-100,-70,-60,110,120,130,160};
        int arr[] = {-2,-2,-2,-1,-1,-1,0,0,0,2,2,2};
        // System.out.println(threeSumBrute(arr));
        System.out.println(threeSumBetter(arr));
    }
}
