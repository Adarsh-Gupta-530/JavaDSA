import java.util.*;

public class LeadersInArray {
    public static List<Integer> leaders(int[] nums) { // two pointer appraoch -> for gfg
        List<Integer> leaders = new ArrayList<>(); // to store the result

        int lastLeder = Integer.MIN_VALUE;// to preserve last leader
        for(int i = nums.length-1;i>=0;i--){
            int currEle = nums[i];
            if(currEle >= lastLeder){ // also including equal value of leaders
                leaders.addFirst(currEle);// add the leader
                lastLeder = Math.max(lastLeder, currEle);
            }
        }
        return leaders;
    }
    public static List<Integer> leaders2(int[] nums) { // two pointer appraoch -> for gfg
        List<Integer> leaders = new ArrayList<>(); // to store the result

        int lastLeder = Integer.MIN_VALUE;// to preserve last leader
        for(int i = nums.length-1;i>=0;i--){
            int currEle = nums[i];
            if(currEle >= lastLeder){ // also including equal value of leaders
                leaders.add(currEle);// add the leader
                lastLeder = Math.max(lastLeder, currEle);
            }
        }
        Collections.reverse(leaders);
        return leaders;
    }
    public static void main(String[] args) {
        // int arr[] = {1, 2, 5, 3, 1, 2};
        int arr[] = {61,61,17};
        System.out.println(leaders(arr));
        System.out.println(leaders2(arr));
    }
}
