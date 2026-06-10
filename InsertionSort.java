public class InsertionSort {
    public static void insertionSort(int arr[]){
        int n = arr.length;
        for(int i = 1; i<=n-1; i++){
            int j =i;
            while (j>0 && arr[j-1]>arr[j]) {
                int temp = arr[j-1];
                arr[j-1] = arr[j];
                arr[j] = temp;

                j--;
                System.out.println("Runs");
            }
        }
    }

    public static void printArr(int arr[]){
        for(int i = 0; i<arr.length; i++){
            System.out.print(arr[i]+" ");
        }
        System.out.println();
    }

    public static void main(String[] args) {
        // int arr[] = {14,9,15,12,6,8,13};
        int arr[] = {1,2,3,4,5,7,9};
        printArr(arr);
        insertionSort(arr);
        printArr(arr);
    }
}
