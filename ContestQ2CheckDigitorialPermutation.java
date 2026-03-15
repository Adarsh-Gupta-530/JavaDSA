public class ContestQ2CheckDigitorialPermutation {
    public static boolean isDigitorialPermutation(int n) {
        int x = n;
        int sum = 0;
        while(x!=0){
            int lastDigit = x%10;
            sum+=fact(lastDigit);
            x = x/10;
        }
        return sameFreq(sum, n);
    }
    public static int fact(int n) {
        if (n == 0 || n == 1)
            return 1;

        return n * fact(n - 1);
    }
    public static boolean sameFreq(int sum , int n){ // insted to check for all unique pernumation we simply check frequencies to match the ans 
        int[] freq = new int[10];

        while(sum != 0){ // store freq
            freq[sum % 10]++;
            sum /= 10;
        }
    
        while(n != 0){ // remove freq
            freq[n % 10]--;
            n /= 10;
        }
    
        for(int i = 0; i < 10; i++){ // if empty means  have permutation 
            if(freq[i] != 0)
                return false;
        }
    
        return true;
    }
    public static void main(String[] args) {
        int num = 10;//145; //415;//10;
        System.out.println(isDigitorialPermutation(num));
    }
}
