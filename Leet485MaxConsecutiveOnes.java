public class Leet485MaxConsecutiveOnes {
    public static int findMaxConsecutiveOnes(int[] nums) { 
        // Better Approach->TC ->O(N)
        int maxCount=0;
        int count=0;
        for(int i=0;i<nums.length;i++){
            if(nums[i]==1){
                count++;
                maxCount = Math.max(count, maxCount);
            } 
            else count=0;
        }
        return maxCount;
        
    }
    public static void main(String[] args) {
        int arr[] = {1,1,0,0,1,1,1,0,1};
        System.out.println("Max number of consicutive 1's are : "+findMaxConsecutiveOnes(arr));
    }
}
