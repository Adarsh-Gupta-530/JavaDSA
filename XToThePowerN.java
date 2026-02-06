public class XToThePowerN{
    public static double myPow(double x, int n) { // Optimized -> O(logn)
        double res = myPowHelper(x, Math.abs(n)); // if n is negative provide it into helper function as positive 

        return (n<0)? 1/res : res; // if power(n)
    }
    public static double myPowHelper(double x, int n){ // it solve for positive power 
        // base case
        if(n==0) return 1;
        if(x==0) return 0;

        // logic.Optimized 
        double halfPower =  myPowHelper(x, n/2);
        double halfPowerSq = halfPower*halfPower;
        if(n%2!=0) 
            halfPowerSq = x * halfPowerSq;

        return halfPowerSq;
    }
    public static void main(String[] args) {
        double x = 2.00000;
        int n = -3;
        System.out.println(myPow(x, n));
    }
}