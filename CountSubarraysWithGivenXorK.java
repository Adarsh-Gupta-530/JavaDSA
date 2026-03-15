public class CountSubarraysWithGivenXorK {
    public static int brute(int nums[], int k){
        // TC ->O(n^3)
        int count = 0;
        for(int i = 0;i<nums.length;i++){
            for(int j = 0;j<nums.length;j++){
                int xor = 0;
                for(int l= i;l<=j;l++){
                    xor=xor^nums[l];
                }
                if(xor==k){
                    count++;
                }
            }
        }
        return count;
    }

    public static int better(int nums[], int k){
        // better - > TC->O(n^2),SC->O(n)
        int preXor[] = new int[nums.length];
        int count = 0;
        preXor[0] = nums[0];
        for(int i = 1 ;i<nums.length; i++){
            preXor[i] = preXor[i-1]^nums[i];
        }

        for(int i = 0;i<nums.length;i++){
            for(int j=i;j<nums.length;j++){
                int xor = 0;
                xor = i==0 ? preXor[j] : preXor[j]^preXor[i-1];
                if(xor==k){
                    count ++;
                }
            }
        }
        return count;
    }
    public static void main(String[] args) {
        int arr[]={4, 2, 2, 6, 4};
        int k=6;
        
        // int arr[] = {5, 6, 7, 8, 9};
        // int k=5;

        // System.out.println(brute(arr, k));
        System.out.println(better(arr, k));
    }
}
