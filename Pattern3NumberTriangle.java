public class Pattern3NumberTriangle {
    // Numbers triangle ->
    // 1
    // 12
    // 123
    // 1234
    // 12345
    public static void main(String[] args) {
        int n=5;
        for(int i=0;i<n;i++){;
            int num=1;
            for(int j=0;j<=i;j++){
                System.out.print((num++)+" ");
            }
            System.out.println();
        }
    }
}
