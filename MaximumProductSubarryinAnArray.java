public class MaximumProductSubarryinAnArray {
    public static int brute(int arr[]){
        int maxProduct = Integer.MIN_VALUE;
        // TC-> O(n^3)
        for(int i = 0; i<arr.length; i++){
            for(int j = i;j<arr.length; j++){
                int currProduct =1;
                for(int k = i; k<=j;k++){
                    currProduct *=arr[k];
                }
                maxProduct = Math.max(currProduct,maxProduct);
            }
        }
        return maxProduct;
    }
    public static int better(int arr[]){
        // TC->O(n^2)
        int maxProduct = Integer.MIN_VALUE;
        int preProduct[] = new int[arr.length];

        preProduct[0] = arr[0];
        for(int i = 1; i<arr.length;i++){
            preProduct[i] = preProduct[i-1]*arr[i];
        }

        for(int i = 0; i<arr.length; i++){
            for(int j = i; j<arr.length; j++){
                int currProduct = (i==0) ? preProduct[j] : (preProduct[i-1]!=0)?preProduct[j]/preProduct[i-1]:0;
                maxProduct = Math.max(currProduct, maxProduct);
            }
        }
        return maxProduct;
    }
    public static int better2(int arr[]){ // tc ->O(n^2)
        int maxi = Integer.MIN_VALUE;
        for(int i = 0; i<arr.length; i++){
            int product = 1;
            for(int j = i; j<arr.length;j++){
                product *=arr[j];
                maxi = Math.max(product, maxi);
            }
        }
        return maxi;
    }
    public static void main(String args[]){
        // int arr[] = {4, 5, 3, 7, 1, 2};
        // int arr[] = {-5, 0, -2};
        int arr[] = {0,2};
        System.out.println("Maximum Product of subArray is : "+better2(arr));
    }
}
