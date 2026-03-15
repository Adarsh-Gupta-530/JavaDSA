public class TUFBSLowerBoundAndUpperBound {
    public static int lowerBoundBS(int[] arr, int x, int low, int high){
        int ans = arr.length;
        while(low<=high){
            int mid  = (low+high)/2;
            if(arr[mid]>=x){
                ans = mid;
                high = mid-1;
            }else{
                low = mid+1;
            }
        }
        return ans;
    }
    public static int upperBoundBS(int[] arr, int x, int low, int high){
        int ans = arr.length;
        while(low<=high){
            int mid  = (low+high)/2;
            if(arr[mid]>x){
                ans = mid;
                high = mid-1;
            }else{
                low = mid+1;
            }
        }
        return ans;
    }

    public static void main(String[] args) {
        int arr[] = {1,2,3,3,5,8,8,10,11};
        System.out.println(lowerBoundBS(arr, 9, 0, arr.length-1));
    }
}
