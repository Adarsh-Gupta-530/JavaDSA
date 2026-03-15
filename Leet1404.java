public class Leet1404 {
    public static int numSteps(String s) {
        // Brute force -> TC->O(nlogn), SC->O(1)
        int num = Integer.parseInt(s, 2); // TC->O(n) to convert binary string to integer
        int steps = 0;
        while(num>1){ // TC->O(logn) because in each step we are either dividing by 2 or adding 1, which reduces the number of bits in the binary representation of num -> givs wrong ans for large input
            if(num%2==0){
                num= num/2;
                steps++;
            }else{
                num+=1;
                steps++;
            }
        }
        return steps;
    }

    public static int numStepsApproach1(String s) {  //TC->O(n^2), SC->O(n)
        StringBuilder sb = new StringBuilder(s);  // SC->O(n)
        int operations = 0;
        while(sb.length()>1){  // TC->O(n)
            int n = sb.length();
            if(sb.charAt(n-1)=='1'){ // odd -> add 1
                addOne(sb); // TC->O(n)
            }else{  // even -> divide by 2
                sb.deleteCharAt(n-1);
            }
            operations++;
        }
        return operations;
    }
    public static void addOne(StringBuilder sb){  // TC->O(n)
        int  i = sb.length()-1;
        while(i>=0 && sb.charAt(i)=='1'){  // make all 1's to 0 befre first zero
            sb.setCharAt(i, '0');   
            i--;
        }
        if(i<0) sb.insert(0, '1'); //if all are ones add '1' at begining ->'111' + 1 = 1000
        else sb.setCharAt(i, '1');  // other wise make just it 1
    }

    public static int numStepsOptimal(String s) {   //TC->O(n), SC->O(1)
        int n = s.length();
        int operations = 0;
        int carry = 0;

        for(int i = n-1; i>=1; i--){
            if(((s.charAt(i) + '0') + carry)%2==1){ // odd
                operations += 2;
                carry = 1;
            }else{  // even 
                operations+=1;
            }
        }

        return (operations+carry); // return operation + carry 
    }

    public static void main(String[] args) {
        String s = "1101";
        System.out.println(numStepsOptimal(s));
    }
}
