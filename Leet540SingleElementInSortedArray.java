public class Leet540SingleElementInSortedArray {
    public static int singleNonDuplicateBrute(int arr[]){
        // TC->O(n)
        if(arr.length == 1) return arr[0]; // BC
        for(int i = 0; i<arr.length;i++){
            if(i==0){
                if(arr[i] != arr[i+1]) return arr[i];
            }else if(i==arr.length-1){
                if(arr[i]!= arr[i-1]) return arr[i];
            }
            else{
                if(arr[i]!=arr[i-1] && arr[i]!=arr[i+1]) return arr[i];
            }
        }
        return -1;
    }
     public static int singleNonDuplicate(int arr[]){
        // TC->O(logn)
        //BC
        if(arr.length == 1) return arr[0];
        if(arr[0]!=arr[1]) return arr[0];
        if(arr[arr.length-1] != arr[arr.length-2]) return arr[arr.length-1];

        //reduced search space
        int left = 1;
        int right = arr.length-2;
        
        //Main logic
        while(left<=right){
            int mid = (left+right)/2;
            if(arr[mid]!=arr[mid+1] && arr[mid] != arr[mid-1]) return arr[mid];

            // elemination part
            if((mid%2==1 && arr[mid] == arr[mid-1]) ||
                (mid%2==0 && arr[mid] == arr[mid+1])){   //element at right half -> eleminate left half
                left = mid+1;
            }else{// element at left half , eleminate righthalf
                right = mid-1;
            }
        }
        return -1;
     }
    public static void main(String[] args) {
        int arr[] = {1,1,2,3,3,4,4,8,8};
        System.out.println(singleNonDuplicateBrute(arr));
    }
}
