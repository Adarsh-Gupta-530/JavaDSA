public class Pattern6InvertedNumsTriangle {
    // inverted nmbers triangle -
    // 12345
    // 1234
    // 123
    // 12
    // 1

    public static void main(String[] args) {
        for(int i=5;i>0;i--){
            int num=1;
            for(int j=0;j<i;j++){
                System.out.print((num++)+" ");
            }
            System.out.println();
        }
    }
    
}
