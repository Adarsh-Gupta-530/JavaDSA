public class Array1 {
    public static void main(String[] args) {
        /*// creation -> 1D Array
        int arr[] = new int[5]; //if empty mean initialized by zero & if strint type arr it will be initialized by -> ""-> empty string.// way 1 
        int arr2[]={1,2,3,4};  // way 2
        String str[]={"Adarsh", "Gupta","From", "JEC"};// string arr

       for (int i = 0; i < arr.length; i++) {
        System.out.print(arr2[i]+ " && "+str[i]+"\n"); // accessing element from arr*/

        // 2D array ->  matrix
        int arr[][] = {{1,2,3},{4,5,6},{7,8,9}};
        for(int i=0;i<arr.length; i++){
            for(int j=0;j<arr[0].length;j++){
                System.out.print(arr[i][j]+" ");
            }
            System.out.println();
        }
    }
}
