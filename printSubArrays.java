public class printSubArrays {
    public static void printSubarrays(int arr[]){
        int totalSubArrays = 0;
        for(int i=0;i<arr.length;i++){
            for(int j=i;j<arr.length;j++){
                System.out.print("[ ");
                for(int k = i;k<=j;k++){
                    System.out.print(arr[k]+" ");
                }
                System.out.print("],");
                totalSubArrays++;
            }

            System.out.println();
        }
        System.out.println("Total subArrays are : "+totalSubArrays);
    }

    public static void subArraysFormula(int arr[]){
        int n = arr.length;
        System.out.println("Total SubArrays are : "+(int)(n*(n+1)/2));
    }

    public static void sumOfSubArray(int arr[]){
        int maxSum = Integer.MIN_VALUE; 
        int minSum = Integer.MAX_VALUE;
        for(int i=0;i<arr.length;i++){
            for(int j=i;j<arr.length;j++){
                int sum = 0;
                for(int k = i;k<=j;k++){
                    sum+=arr[k];
                }
                // System.out.println(sum);
                if(sum>maxSum){
                    maxSum=sum;
                }
                if(sum<minSum){
                    minSum = sum;
                }
            }

            // System.out.println();
        }
        System.out.println("Maximum Sum of SubArrays is : "+maxSum);
        System.out.println("Maximum Sum of SubArrays is : "+minSum);
    }
    public static void main(String[] args) {
        int arr[] = {2,4,6,8,10};
        // printSubarrays(arr);
        // subArraysFormula(arr);
        sumOfSubArray(arr);
    }
}
