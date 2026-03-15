public class Leet152MaximumProductSubarray {
    public static int maxProductBrute(int nums[]){ // TC->O(n^3), Sc->O(1)
        int maxProduct = Integer.MIN_VALUE;
        for(int i = 0;i<nums.length;i++){
            for(int j = i+1; j<nums.length ; j++){
                int product = 1 ;
                for(int k = i;k<=j;k++){
                    product*=nums[k];
                }
                maxProduct = Math.max(maxProduct,product);
            }
        }
        return maxProduct;
    }
    public static int maxProductBetter(int nums[]){
        // batter -> TC->O(n^2), SC->O(n)
        int maxProduct = Integer.MIN_VALUE;
        int preProduct[] = new int[nums.length];

        preProduct[0] = nums[0];
        for(int i= 1; i<nums.length;i++){
            preProduct[i]=preProduct[i-1]*nums[i];
        }
        for(int i=0;i<nums.length;i++){
            for(int j = i+1; j<nums.length;j++){
                int currProduct = (i==0) ? preProduct[j] :(int)(preProduct[j]/preProduct[i-1]);
                maxProduct = Math.max(maxProduct, currProduct);
            }
        }
        return maxProduct;
    }
    public static void main(String[] args) {
        // int arr[] = {2,3,-2,4};
        int arr[] = {-2};
        System.out.println(maxProductBetter(arr));
    }
}
