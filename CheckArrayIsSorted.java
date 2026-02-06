import java.util.*;
public class CheckArrayIsSorted {
    public static boolean isSorted(ArrayList<Integer> nums) {
        for(int i=1;i<nums.size();i++){
            if(nums.get(i-1) > nums.get(i)) return false;
        }
        return true;
    }
    public static void main(String[] args) {
        ArrayList<Integer> arr = new ArrayList<>();
        arr.add(1);
        arr.add(2);
        arr.add(1);
        arr.add(4);
        arr.add(5);
        System.out.print(isSorted(arr));
    }
}
