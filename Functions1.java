public class Functions1 {
    // basics of function in java
    static int fact(int n){ // 1. call by value -> parameterised function // formal parameters/parameters
        // 1. call by value -> change does'nt reflect on main function. 
        if(n==1){
            return 1;
        }
        int factorial= n * fact(n-1);
        return factorial;
    }
    public static void main(String[] args) {
        System.out.print("Factorial of 7 is : "+ fact(7)); // function call -> arguments/ actual parameters

        // ****JAVA always call function by value -> there is no concept of "call by reference" in java because there is no concept of pointers in java.
        // 2. call by reference-> changes reflect of main function.
    }
}
