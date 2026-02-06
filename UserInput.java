import java.util.Scanner;

public class UserInput {
    // take u forward -> prob 1st ->Input Output
    public static void printNumber(Scanner sc) {
            int input=sc.nextInt();
            System.out.println(input);
    }

    public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);
        printNumber(sc);
    }
}
