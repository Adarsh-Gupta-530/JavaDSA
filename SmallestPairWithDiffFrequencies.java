import java.util.*;

public class SmallestPairWithDiffFrequencies {
    public static int[] minDistinctFreqPair(int[] nums) {
        // Count frequency
        Map<Integer, Integer> freq = new HashMap<>();
        for (int num : nums) {
            freq.put(num, freq.getOrDefault(num, 0) + 1);
        }
        if (freq.size() < 2) {  // base case
            return new int[]{-1, -1};
        }
        //Sort unique elements
        List<Integer> keys = new ArrayList<>(freq.keySet());
        Collections.sort(keys);

        //Track smallest element
        int first = keys.get(0);

        for (int i = 1; i < keys.size(); i++) {
            int second = keys.get(i);
            if (!freq.get(first).equals(freq.get(second))) {
                return new int[]{first, second};
            }
        }

        return new int[]{-1, -1};
    }
    public static void main(String[] args) {
        // int arr[] ={1,1,2,2,3,4};
        int arr[] = {1,5};
        System.out.println(Arrays.toString(minDistinctFreqPair(arr)));
    }
}
