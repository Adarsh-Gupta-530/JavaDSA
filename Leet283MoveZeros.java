import java.util.Arrays;

public class Leet283MoveZeros {
    public static void moveZerosBrute(int arr[]){ // TC->O(n), SC->O(n)
        int temp[] = new int[arr.length];

        int front=0;
        int end = arr.length-1;

        for(int i=0; i<arr.length;i++){
            if(arr[i]==0) temp[end--]=0;
            else temp[front++]=arr[i]; 
        }
        for(int i=0;i<arr.length;i++){
            arr[i]=temp[i];
        }
        System.out.println(Arrays.toString(arr));
    }
    public static void moveZeros(int arr[]){ // optimal -> O(n)
        int idx=0;
        for(int i=0;i<arr.length;i++){
            if(arr[i]!=0){
                arr[idx++] = arr[i]; 
            }
        }
        for(int i=idx;i<arr.length;i++){
            arr[i]= 0;
        }

        System.out.println(Arrays.toString(arr));


    }
    public static void main(String[] args) {
        int arr[]= {1,2,0,3,0,0,2,0,1};
        // moveZeros(arr);
        moveZerosBrute(arr);
    }
}
