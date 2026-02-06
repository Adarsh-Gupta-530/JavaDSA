public class Pattern4NumberTriangle2 {
    // Numbers triangle 2-> 
    // 1
    // 22
    // 333
    // 4444
    // 55555
    public static void main(String[] args) {
        int n=5;
        int num=1;
        for(int i=0;i<n;i++){
            for(int j=0;j<=i;j++){
                System.out.print(num+" ");
            }
            System.out.println();
            num++;
        }
    }
    
}
