public class leet42TrapingRainWater {
    public static int trapbrute(int height[]){
        // brute force -> TC->O(n^2), sc ->O(n) -> gives TLE
        int ans = 0;
        for(int i = 0;i<height.length;i++){
            int left = height[i];
            int right = height[i];
            if(i == 0){
                ans+=0;
                continue;
            }else if(i==height.length-1){
                right = height[height.length-1];
            }else{
                int j=i;
                int k=i;
                while(j>=0){
                    left = Math.max(left, height[j]);
                    j--;
                }
                while(k<height.length){
                    right  = Math.max(right, height[k]);
                    k++;
                }
            }
            int result = Math.min(left, right)-height[i];
            // System.out.println(result);
            ans+=result<0 ? 0 : result;
        }
        return ans;
    }
    public static int trapBetter(int height[]){
        // better -> TC->O(3n), SC->O(2n) 
        // BC
        if(height.length<3){
            return 0;
        }
        // setp 1:  calculate left max bondary
        int leftMax[] = new int[height.length];
        leftMax[0] = height[0];
        for(int i = 1; i<height.length;i++){
            leftMax[i] = Math.max(leftMax[i-1], height[i]);
        }

        //step 2 : calculate right max boundary
        int rightMax[] = new int[height.length];
        rightMax[height.length-1] = height[height.length-1];
        for(int i = height.length-2; i>=0; i--){
            rightMax[i] = Math.max(rightMax[i+1], height[i]);
        }
        
        int trappedWater = 0;
        // loop to calculate
        for(int i = 0; i<height.length; i++){
            // water level = min(leftmax, rightmax)
            int waterLevel = Math.min(leftMax[i], rightMax[i]);
            // trepped water  = water level - height[i]
            trappedWater += waterLevel - height[i];
        }
        return trappedWater;
    }
    public static int trapOptimal(int height[]){
        // optimal -> TC->O(n), SC->O(1) -> two pointer approach
        int trappedWater = 0;
        int left = 0;
        int right = height.length-1;
        int leftMax = 0;
        int rightMax = 0;

        while(left<right){
            leftMax = Math.max(leftMax, height[left]);
            rightMax = Math.max(rightMax, height[right]);

            if(leftMax<rightMax){ // left boundary is desciding factor
                trappedWater += (leftMax - height[left]);
                left++;
            }else{ // right boundary is desciding factor
                trappedWater += (rightMax - height[right]);
                right--;
            }
        }

        return trappedWater;
    }
    public static void main(String[] args) {
        // int[] height = {4,2,0,6,3,2,5};
        int height[] = {0,1,0,2,1,0,1,3,2,1,2,1};
        System.out.println(trapBetter(height));
    }
}
