import java.util.*;
public class Leet46AllPermutation {
    // brute force
    public static List<List<Integer>> allPermutationBrute(int nums[]){ // brute force -> TC->O(n! * n), SC->O(n)+O(n)
        List<List<Integer>> result = new ArrayList<>(); // taking an result list of list to store all permutations 
        List<Integer> ds  = new ArrayList<>(); // dataStructure that stores the one permutation for all recursive calls
        Boolean freq[] = new Boolean[nums.length]; // freq boolean arra to store the visited marked or not  
        Arrays.fill(freq, false); // initially fill it with false value
        recursivePermutation(nums, result, ds, freq); // store all permutation in result
        return result; // returning the result.
    }

    public static void recursivePermutation(int nums[], List<List<Integer>> result, List<Integer> ds, Boolean freq[]){ // recursive helper function
        if(ds.size() == nums.length){  // base case the data structures size is equals to nums means that is a permutation store it in result.
            result.add(new ArrayList<>(ds));
            return;
        }
        for(int i=0;i<nums.length;i++){ // pick all elements at once
            if(!freq[i]){  // if element isnt picked :
                freq[i] = true;  // mark them as picked 
                ds.add(nums[i]);  // store it into a ds 
                recursivePermutation(nums, result, ds, freq); // call for next elements to pick
                ds.remove(ds.size()-1);  // now if reach the base case remove element from data structure 
                freq[i]=false; // and make visite mark as false;
            }
        }
    }


    // optimal
    public static List<List<Integer>> allPermutationsOptimal(int nums[]){ // optimal ->TC->O(n!*n)
        List<List<Integer>>  result = new ArrayList<>();//  returning the output
        recursionPermutationOptimal(nums, 0, result); // call for recursion 
        return result; // return what result we get from it.
    }

    public static void recursionPermutationOptimal(int nums[], int idx, List<List<Integer>> result){ 
        if(idx==nums.length){// if index hit case when it will become nums.length
            List<Integer> ds = new ArrayList<>(); // create a list
            for(int i=0;i<nums.length;i++){
                ds.add(nums[i]); // add arrays elements into it 
            }
            result.add(new ArrayList<>(ds)); // then add that list into the result. 
            return;
        }
        for(int i=idx;i<nums.length;i++){ // if not hit bc
            swap(idx, i, nums); // swap nums[idx] value with nums[i]
            recursionPermutationOptimal(nums, idx+1, result); // call for the next value
            swap(idx, i, nums); // reverse the swap while backtracking to make array as it is for another branch of recursion tree.
        }
    }
    public static void swap(int i, int j, int[] nums){ // swap 
        int temp = nums[i];
        nums[i] = nums[j];
        nums[j]= temp;
    }

    public static void main(String[] args) {
        int arr[] = {1,2,3};
        // System.out.print(allPermutationBrute(arr));
        System.out.println(allPermutationsOptimal(arr));

    }
}
