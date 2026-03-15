public class Factorial {
    public static int fact(int n){
        if(n == 0 || n==1) return 1;
        int dp[] = new int[n+1];

        if(dp[n]!=-1) return dp[n]; // altready computed

        dp[n] = n*fact(n-1);
        return dp[n];
    }
    public static void main(String[] args) {
        int n = 5;
        System.out.println(fact(n));
    }
}
