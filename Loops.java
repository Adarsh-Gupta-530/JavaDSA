public class Loops {
    public static void main(String[] args) {
        // loops -> for , while , do-while and foreach. -> these are the basic loops in java

        for(int i=1;i<=5;i++){ // 1. for loop
            System.out.print(i+" ");
        }
        System.out.println();
        int i=6;
        while(i<=10){ // 2. while loop
            System.out.print(i+" ");
            i++;
        }
        System.out.println();
        do{ // 3. do-while loop
           System.out.print(i+" "); 
           i++;
        }while(i<=15);

    }
}
