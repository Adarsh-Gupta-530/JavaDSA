public class SelectionSort{
    public static void sortSelection(int[] arr){   //O(n^2)
        int n = arr.length;
        for(int i = 0; i<n ; i++){   // O(n)
            int min = i;
            for(int j = i; j<n; j++){  //O(n)
                if(arr[min]>arr[j]){
                    min = j;
                }
            }
            //swap
            int temp = arr[i];
            arr[i] = arr[min];
            arr[min] = temp;
        }
    }
    public static void printArr(int arr[]){
        for(int i = 0; i<arr.length; i++){
            System.out.print(arr[i]+" ");
        }
        System.out.println();
    }
    public static void main(String[] args) {
        int arr[] =  {13,46,24,52,20,9};
        printArr(arr);
        sortSelection(arr);
        printArr(arr);
    }
}