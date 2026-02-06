import java.util.*;
public class UnionOfTwoSortedArray {
    public static int[] unionTwoArr(int nums1[] , int nums2[]){
        HashMap<Integer,Integer> map = new HashMap<>(); // brute force -> tc->O(m+n) , sc=>O(m+n)
        for(int i=0;i<nums1.length;i++){
            if(map.containsKey(nums1[i])) map.put(nums1[i], map.get(nums1[i])+1);
            else map.put(nums1[i],1);
        }
        for(int i=0;i<nums2.length;i++){
            if(map.containsKey(nums2[i])) map.put(nums2[i], map.get(nums2[i])+1);
            else map.put(nums2[i],1);
        }

        int result[] = new int[map.size()];
        Set<Integer> keys = map.keySet(); 
        int idx=0;
        for(int key : keys){
            result[idx++] = key;
        }
        return result;
    }
    public static void main(String[] args) {
        int arr1[]={1,2,3,4,5,5,6,7};
        int arr2[] ={2,3,4,8,9};
        System.out.print(Arrays.toString(unionTwoArr(arr1, arr2)));
    }
}
