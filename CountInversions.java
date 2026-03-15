public class CountInversions {
    public static int countInversionBrute(int nums[]){
        //TC->O(n^2), SC->O(1)
        int count = 0;
        for(int i = 0 ;i<nums.length;i++){
            for(int j = i+1; j<nums.length;j++){
                if(nums[i]>nums[j] && i<j){
                    count++;
                }
            }
        }
        return count;
    }

    public static void main(String[] args) {
        // int arr[] = {2, 3, 7, 1, 3, 5};
        int arr[] = {-10, -5, 6, 11, 15, 17};
        System.out.println(countInversionBrute(arr));
    }
}
