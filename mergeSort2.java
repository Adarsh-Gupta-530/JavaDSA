public class mergeSort2 {   // TC=> O(nlogn)
    public static void merge(int arr[], int left, int mid, int right){

        int temp[] = new int[right-left+1];
        int i = left;
        int j = mid+1;
        int k = 0;

        while(i<=mid && j<=right){
            if(arr[i]<=arr[j]){
                temp[k++] = arr[i++];
            }else{
                temp[k++] = arr[j++];
            }
        }
        while(i<=mid) temp[k++] = arr[i++];
        while(j<=right) temp[k++] = arr[j++]; 

        for(k = 0, i=left;k<temp.length;k++,i++){
            arr[i] = temp[k];
        }

    }
    public static void mergeSort(int arr[], int left, int right){
        if(left >= right) return;

        int mid = (left+right)/2;

        mergeSort(arr, left, mid);
        mergeSort(arr, mid+1, right);

        merge(arr, left, mid, right);
    }
    public static void printArr(int arr[]){
        for(int i = 0; i<arr.length ; i++){
            System.out.print(arr[i]+" ");
        }
        System.out.println();
    }
    public static void main(String[] args) {
        int arr[] = {3,1,2,4,1,5,2,6,4};
        printArr(arr);
        mergeSort(arr, 0, arr.length-1);
        printArr(arr);
    }
}
