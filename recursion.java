public class recursion {

    static void printTillN(int n){
        if(n==0) return;
        printTillN(n-1);
        System.out.print(n+ " ");
    }

    static void printFromNtill1(int n){
        if(n==0) return;
        System.out.print(n + " ");
        printFromNtill1(n-1);
    }
    
    static void printDecThenInc(int n){
        if(n==0) return;
        System.out.print(n+" ");// for decrising print 
        printDecThenInc(n-1);
        if(n!=1) System.out.print(n+" ");
        
    }

    static void printIncthenDec(int n){
        if(n==0) return; // base case
        printIncthenDec(n-1);
        System.out.print(n+" ");
        // System.out.print(n+" "); 
    }

    static int numbersSum(int n){
        if(n==1) return 1; // base case 
        return n+=numbersSum(n-1);
    }
    
    static int factorial(int n){
        if(n==1) return 1;
        return n*factorial(n-1);
    }

    static void reverse(int arr[], int n){
        reverseHelper(arr, 0, n-1); // using helper function
    }
    static void reverseHelper(int arr[], int startIdx, int endIdx){
        if(startIdx>endIdx){ // base class
            return;
        }
        reverseHelper(arr, startIdx+1, endIdx-1); //recurcive call for next idx 

        // swap
        int temp = arr[startIdx];
        arr[startIdx]=arr[endIdx];
        arr[endIdx]=temp;
    }

    public static boolean palindromeCheck(String s) {
        return palindromeCheckHelper(s, 0, s.length());
    }
    public static boolean palindromeCheckHelper(String s, int i, int n){
        if (s == null) return false;// if string is null.
        if(i>=n/2){ //base case
            return true;
        }
        if(s.charAt(i)!=s.charAt(n-i-1)) return false; //mismatch case

        return palindromeCheckHelper(s, i+1, n);//recursive call
    }

    public static int fib(int n) {
        if(n==0) return 0;
        if(n<=2) return 1;

        return fib(n-1)+fib(n-2);
    }
    
    // using memoization.
    static int firstOccurance(int arr[], int target){
        if(arr.length==0) return -1;
        return firstOccuranceHelper(arr, target, 0);
    }
    static int firstOccuranceHelper(int[] arr, int target, int idx){
        if(idx>arr.length-1) return -1;
        if(arr[idx]==target) return idx;
        return firstOccuranceHelper(arr, target, idx+1);
    }
    
    
    public static void main(String[] args) {
        // Scanner sc=new Scanner(System.in);

        /*// 1. print till n using memoization/recursion
        int n = sc.nextInt(); 
        System.out.print("Numbers from 1 till "+n+" are \n");
        printTillN(n);*/

        /*// 2. print from n till 1
        int n =sc.nextInt();
        printFromNtill1(n);*/

        /*// 3. retrun the of n numbers using recursion
        int n=sc.nextInt();
        System.out.print("Sum of numbers till "+n+" is : "+numbersSum(n));*/

        /*// 4. factorial of n using recursion
        int n=sc.nextInt();
        System.out.print("Factorial of "+n+" is : "+factorial(n));*/

        // 5. reverse array using recursion
        /*int arr[]={2,5,6,7,8};
        int size=arr.length;
        reverse(arr, size);
        for(int i=0;i<size;i++){
            System.out.print(arr[i]+" ");
        }*/

        /*// 6. check isPalindrome by using recursion.
        String s = "aabbcccdbbaa"; //"aabbaaa"//"hannah"//"aabbcccdbbaa"
        if(palindromeCheck(s)) System.out.print(s+" is a palindrome number."); 
        else System.out.print(s+" is not a pallindrome number.");
        */

        /*// 7. fibonacci series using recursion
        int n=sc.nextInt();
        System.out.print("Element at "+fib(n));*/

        /*// 8. find the first occurance in array
        int arr[]={2,3,4,5,6,4,7,8};
        int target=5;
        System.out.print(target+" is at index : "+firstOccurance(arr, target)+" in array.");*/


        // 9. print Decreasing , then increasing.
        printIncthenDec(5);

    }
}
