import java.util.*;

public class BasicMathProblems {

    static int countDigits(int num){
        /*// brute force -> tc -> O(n)
        int x=num;  // copy the number;
        int count = 0; // initialized the count 
        while(x!=0){
            count++; // increase count
            x=x/10; // reduce the last digit from number that was counted;
        }
        return count;*/

        // optimaised approach -> TC -> O(1)
        int count = (int)(Math.log10(num)+1);
        return count;
    }

    static int reverseNumber(int num){
        int x=num; // copy the actual number  to mathc
        int reverse=0; // initialize
        while(x!=0){
            int lastDigit=x%10;
            x=x/10;
            reverse=reverse*10+lastDigit;
        }
        return (int)reverse;
    }

    static boolean isPalindrome(int num){
        int x=num;
        int reverse =0;
        while(x!=0){
            int lastDigit=x%10;
            x=x/10;
            reverse=reverse*10+lastDigit;
        }
        if(reverse == num) return true;
        return false;
    }

    static int GCD(int n1, int n2){ // greatest commonn divisor

        int GDC=1;// intialized by 1 because minimest HCF is 1 for ani two numbers.
        /*// Brute force
        for(int i=1;i<=Math.min(n1,n2);i++){
            if(n1%i==0 && n2%i==0){
                GDC=i;
            }
        }*/

        // Better Approach 
        for(int i=Math.min(n1,n2); i>=1;i--){
            if(n1%i==0 && n2%i==0){
                return i;
            }
        }
        return GDC;
    }
    
    static boolean isArmstrong(int  num){
        int realN = num;
        int sum=0;
        while(num!=0){
            int lastDigit = num%10;
            sum = sum + (lastDigit*lastDigit*lastDigit);
            num = num/10;
        }
        if(sum==realN){
            return true;
        }
        return false;
    }

    static int[] AllDivisors(int n){
        ArrayList<Integer> list=new ArrayList<>();
        // brute force ->TC-> O(n)
        // for(int i=1;i<=n;i++){
        //     if(n%i==0){
        //         list.add(i);
        //     }
        // }

        // int divisors[]= new int[list.size()];
        // for(int i=0;i<list.size();i++){
        //     divisors[i]=list.get(i);
        // }
        // return divisors;

        // Optimal Approach -> TC->O(logn)
        for(int i=1;i<=(int)Math.sqrt(n);i++){
            if(n%i==0){
                // adding second factor -. if n=36 -> 1X36 -> 1 is first factor and 36 is secont factor.
                list.add(i); // first factor 
                if((n/i)!=i) list.add(n/i); // second factor
            }
        }
        int divisors[]= new int[list.size()];
        for(int i=0;i<list.size();i++){
            divisors[i]=list.get(i);
        }
        Arrays.sort(divisors);
        return divisors;

    }

    static boolean isPrime(int n){
        /*// brute force -> TC- O(n)
        if (n <= 1) return false;   // edge case
        for(int i=2; i<n;i++){
            if(n%i==0) return false;
        }
        return true;*/

        // Optimal Approach -> TC - O(logn)
        if (n <= 1) return false;   // edge case
        for(int i=2;i<=(int)Math.sqrt(n);i++){
            if(n%i==0) return false;
        }
        return true;
    }

    public static void main(String[] args) {

        /*// 1. count digit in a number
        int num=1236678;
        System.out.println("Count of digits in "+num+" is : "+countDigits(num));*/

        //2. reverse number
        /*int num=7789;
        System.out.print("Reverse of number "+num+" is : "+reverseNumber(num));*/

        /*// 3. ispalindrome
        // int num=12321;
        int num = 256752;
        if(isPalindrome(num)) System.out.println(num+" is A Palindrome number.");
        else System.out.println(num+ " is not A Palindrone.");*/

        /*//4. HCF oer GCD 
        int num1=15;
        int num2=20;
        System.out.print("HCF or GCD of "+num1+" and "+num2+" is : "+GCD(num1, num2));*/

        /* 
        // 5 Armstrong number
        // int num=153;
        int num=35;
        System.out.print(num+" is Armstrong : "+isArmstrong(num));*/

        /*// 6. return all divisors 
        int n=36;  
        // System.out.print(Arrays.toString(AllDivisors(n)));
        int arr[]=AllDivisors(n);
        for (int arr2 = 0; arr2 < arr.length; arr2++) {
            System.out.print(arr[arr2]+" ");
        } 
            */

        // 7. is Prime
        int n=17;
        System.out.print(n+" is Prime Number : "+isPrime(n));     
    }
}
