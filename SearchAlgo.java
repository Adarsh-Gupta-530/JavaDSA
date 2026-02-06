public class SearchAlgo {
    public static int linearSearch(int arr[], int key){
        for(int i=0; i<arr.length; i++){
            if(arr[i]==key){
                return i; // key found at index i
            }
        }
        return -1; // key not found
    }
    public static int binarySearch(int arr[], int key){
        int left =0, right=arr.length-1;
        while(left<=right){
            int mid = left + (right-left)/2;
            if(arr[mid]==key){
                return mid; // key found at index mid
            }
            else if(arr[mid]<key){
                left = mid +1; // search in right half
            }
            else{
                right = mid -1; // search in left half
            }
        }
        return -1; // key not found
    }
    public static void main(String[] args) {
        int arr[] = {2,4,6,8,10,12,14,16,18,20};
        int key = 14;   
        int linearResult = linearSearch(arr, key);
        if(linearResult != -1){
            System.out.println("Linear Search: Key " + key + " found at index " + linearResult);
        } else {
            System.out.println("Linear Search: Key " + key + " not found in the array.");
        }   
        int binaryResult = binarySearch(arr, key);
        if(binaryResult != -1){
            System.out.println("Binary Search: Key " + key + " found at index " + binaryResult);
        } else {
            System.out.println("Binary Search: Key " + key + " not found in the array.");
        }
    }
}
