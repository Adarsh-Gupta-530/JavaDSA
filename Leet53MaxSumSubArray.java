public class Leet53MaxSumSubArray {
    public static int maxSumBrute(int arr[]){
        // brute force => using nested loop -> TC => O(n^3)
        if(arr.length == 1) return arr[0]; 
        
        int maxSum=Integer.MIN_VALUE;
        for(int i=0;i<arr.length;i++){
            for(int j=i;j<arr.length;j++){
                int sum=0;
                for(int k=i;k<=j;k++){
                    sum+=arr[k];
                }
                if(maxSum<sum) maxSum = sum;
            }
        }
        return (maxSum == Integer.MIN_VALUE) ? -1 : maxSum;
    }
    public static int maxSumBetter(int arr[]){ // using prefix array -> TC-> O(n^2)
        int[] prefix = new int[arr.length]; // prefix sum array
        int maxSum=Integer.MIN_VALUE;

        // storing first element in prefix array
        prefix[0] = arr[0]; 
        // claculate prefix
        for(int i=1;i<arr.length;i++){ // starting loop from 1 because first eement will must be arr[0];
            prefix[i]=prefix[i-1]+arr[i];
        }

        for(int i=0; i< arr.length;i++){
            int start = i;
            for(int j=i;j<arr.length;j++){
                int sum = 0; // sum 
                int end = j; 
                sum =(start == 0) ? prefix[end] : prefix[end]-prefix[start-1];
                if(sum>maxSum)
                    maxSum=sum;
            }
        }
        return maxSum;
        
    }
    public static int maxSumOptimal(int arr[]){
        // kadans Algorithm -> optimal solution -> O(n) 
        /*
        // if all elements in array are negative -> then edge case
        int minusMax = Integer.MIN_VALUE;
        for(int i=0;i<arr.length;i++){
            if(arr[i]>minusMax) minusMax = arr[i];
        }
        if(minusMax<0) return minusMax;
        // main kadans algorithm
        int maxSum=Integer.MIN_VALUE;
        int currSum=0;

        for(int i=0;i<arr.length;i++){
            currSum = currSum+arr[i];
            if(currSum<0) currSum=0;// if currrSum is negative
            maxSum = Math.max(currSum, maxSum);
        }
        return maxSum;
         */

        // also write kadans algorithm with handled case for if all elements are negative
        int maxSum=Integer.MIN_VALUE;
        int currSum=0;

        for(int i=0;i<arr.length;i++){
            currSum = Math.max(arr[i], currSum+arr[i]);
            maxSum = Math.max(currSum, maxSum);
        }
        return maxSum;
    }
    public static void main(String[] args) {
        int arr[] = {1,-2,6,-1,3}; 
        // int arr[] = {-2,-3,4,-1,-2,1,5,-3};

        // int arr[]={-8,-2,-3,-4};
        // System.out.print("Max Sum Is : "+maxSumBrute(arr));
        System.out.print("Maximum sum is : "+maxSumBetter(arr));
        // System.out.print("Maximum sum is : "+maxSumOptimal(arr));
    }
}
