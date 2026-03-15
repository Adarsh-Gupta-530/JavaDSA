class Leet762PrimeNumberofSetBitsInBinaryRepresentation{
    public static int countPrimeSetBitsBrute(int left, int right) { //TC->O(n)
        // brute
        int result= 0;
        for(int i = left; i<=right;i++){ //O(n)
            int count = Integer.bitCount(i); // getting the count of set bits of  the numbers ->O(1)
            if(isPrime(count)){
                result++;
            }
        }
        return result;
    }
    public static boolean isPrime(int num){ // TC->O(n)
        if(num>0 && num<2){
            return false;
        }
        for(int i = 2;i<=Math.sqrt(num);i++){
            if(num%i==0){
                return false;
            }
        }
        return true;
    }
    public static void main(String[] args) {
        int left = 842;//10; //6;
        int right = 888;//15; //10;
        System.out.print(countPrimeSetBitsBrute(left, right));
    }
}