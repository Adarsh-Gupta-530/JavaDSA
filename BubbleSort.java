public class BubbleSort {
    public static void bubbleSort(int arr[]){ 
        //TC => O(n^2) 
        // int n = arr.length;
        // for(int i = 0; i < n; i++){//O(n)
        //     for(int j = 1; j<n-i; j++){//O(n)
        //         if(arr[j]<arr[j-1]){
        //             int temp = arr[j];
        //             arr[j] = arr[j-1];
        //             arr[j-1] = temp;
        //         }
        //     }
        // }


        // optimized -> if array is sorted in  asc order 
        int n = arr.length;
        for(int i = 0; i < n; i++){
            boolean isSwap = false;
            for(int j = 1; j<n-i; j++){
                if(arr[j]<arr[j-1]){
                    int temp = arr[j];
                    arr[j] = arr[j-1];
                    arr[j-1] = temp;
                    isSwap = true;
                }
            }
            if(!isSwap){
                break;
            }
            System.out.println("runs");
        }
    }
    public static void printArr(int arr[]){
        for(int i = 0; i<arr.length; i++){
            System.out.print(arr[i]+" ");
        }
        System.out.println();
    }
    public static void main(String[] args) {
        // int arr[] = {13,46,24,52,20,9};
        // int arr[] = {1,4,6,8,19,30};
        int arr[] = {30,27,25,15,12,10,6,2};
        printArr(arr);
        bubbleSort(arr);
        printArr(arr);

    }
}
