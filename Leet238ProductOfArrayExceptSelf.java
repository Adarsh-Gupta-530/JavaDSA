import java.util.Arrays;

public class Leet238ProductOfArrayExceptSelf {
    // bruteForce Approach for returning product of array except self
    public static int[] bruteForce(int arr[]){
        int result[] = new int[arr.length];
        for(int i=0;i<arr.length;i++){
            int product=1;
            for(int j=0;j<arr.length;j++){
                if(j!=i) product*=arr[j];
            }
            result[i]=product;
        }
        // System.out.print(Arrays.toString(result));
        return result;
    }

    public static int[] betterApproach(int arr[]){
        int n = arr.length;
        int result[] = new int[n];
        int prefix[]=new int[n];
        int suffix[]=new int[n];

        // prefix -> initialization
        prefix[0]=arr[0];
        for(int i=1; i<n;i++){
            prefix[i]=prefix[i-1]*arr[i];  // storing all the prefix value of product 
        }
        // System.out.print(Arrays.toString(prefix));

        // suffix -> initialization
        suffix[n-1]=arr[n-1];
        for(int i=n-2;i>=0;i--){
            suffix[i] = suffix[i+1] * arr[i];
        }
        // System.out.print(Arrays.toString(suffix));

        for(int i=0;i<n;i++){
            if(i==0) result[i] = suffix[i+1];
            else if(i==n-1) result[i] = prefix[i-1];
            else result[i]=prefix[i-1]*suffix[i+1];
            
        }
        return result;
    } 

    public static int[] optimalApproach(int arr[]){
        int result[] = new int[arr.length];
        int arrayProduct=1;
        for(int i=0;i<arr.length;i++){
            arrayProduct*=arr[i];
        }
        // System.out.println("product is : "+arrayProduct);

        for(int i=0;i<arr.length;i++){
            result[i] = arrayProduct/arr[i];
        }
        return result;
    }
    public static void main(String[] args) {
        int arr[] = {1,2,3,4};
        // bruteForce(arr);
        // System.out.println(Arrays.toString(betterApproach(arr)));
        System.out.println(Arrays.toString(optimalApproach(arr)));
        
    }
}
