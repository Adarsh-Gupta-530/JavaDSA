public class Leet162PeakElement {
    public static int peakElementBrute(int arr[]){  // TC->O(n),SC->O(1)
       for(int i = 0; i< arr.length ; i++){
            if((i == 0 || arr[i-1]<arr[i]) && (i == arr.length || arr[i]>arr[i+1])){
                return i;
            }
       }
       return -1;
    }
    public static int peakElementOptimal(int arr[]){
         //TC->O(logn), O(1)
        int n = arr.length;
        if(n == 1) return 0;
        if(arr[0]>arr[1]) return 0;  //  first will be peak
        if(arr[n - 1]>arr[n-2]) return n - 1; // last will be peak

            int low=1;
            int high = n-2;
            while(low<=high){
                int mid = (low+high)/2;
                if(arr[mid]>arr[mid-1] && arr[mid]>arr[mid+1]){
                    return mid;
                }else if(arr[mid]>arr[mid-1]){  // lie on right half-> inc curve
                    low = mid+1;
                }else{ // lie on left half-> desc curve  //  and for multiple pesks 
                    high = mid-1;
                }
            }
            return -1;
    }
    public static void main(String[] args) {
        int arr[] = {1,2,1,3,1};
        // int arr[] = {1,2,3,4,5,6,7,8,5,1};
        // System.out.println(peakElementBrute(arr));
        System.out.println(peakElementOptimal(arr));
    }
}