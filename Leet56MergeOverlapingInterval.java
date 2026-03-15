import java.util.*;
public class Leet56MergeOverlapingInterval {

    public static int[][] mergeOverlapingIntervalBrute(int[][] intervals) { // TC->O(nlogn)+O(2n), SC->O(n)
        int n = intervals.length;
        // Sort intervals by start time
        Arrays.sort(intervals, (a, b) -> Integer.compare(a[0], b[0]));
        List<int[]> result = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            int start = intervals[i][0];
            int end = intervals[i][1];
            // Skip if already covered
            if (!result.isEmpty() && end <= result.get(result.size() - 1)[1]) {
                continue;
            }
            // Check next intervals for overlap
            for (int j = i + 1; j < n; j++) {
                if (intervals[j][0] <= end) {
                    end = Math.max(end, intervals[j][1]);
                } else {
                    break;
                }
            }
            result.add(new int[]{start, end});
        }
        // Convert List<int[]> to int[][]
        int[][] ans = new int[result.size()][2];
        for (int i = 0; i < result.size(); i++) {
            ans[i] = result.get(i);
        }
        return ans;
    }
    public static int[][] mergeOverlapingIntervalOptimal(int[][] intervals) {   // TC->O(n)
        int n = intervals.length;
        Arrays.sort(intervals, (a, b) -> Integer.compare(a[0], b[0]));
        List<int[]> preAns = new ArrayList<>(); 

        for(int i=0;i<n;i++){
            if(preAns.isEmpty() || intervals[i][0] > preAns.get(preAns.size()-1)[1]){
                preAns.add(new int[]{intervals[i][0], intervals[i][1]});
            }else{
                preAns.get(preAns.size()-1)[1] = Math.max( preAns.get(preAns.size()-1)[1], intervals[i][1]);
            }
        }
        int[][] ans = new int[preAns.size()][2];
        for (int i = 0; i < preAns.size(); i++) {
            ans[i] = preAns.get(i);
        }
        return ans;
    }

    public static void main(String[] args) {
        int arr[][]={{1,3},{2,6},{8,9},{9,11},{8,10},{2,4},{15,18},{16,17}};

        // int arr2[][] = mergeOverlapingIntervalBrute(arr);
        // for(int i = 0; i<arr2.length;i++){
        //     System.out.println(arr2[i][0]+" "+arr2[i][1]);
        // }

        int arr2[][] = mergeOverlapingIntervalOptimal(arr);
        for(int i = 0; i<arr2.length;i++){
            System.out.println(arr2[i][0]+" "+arr2[i][1]);
        }
    }
}
