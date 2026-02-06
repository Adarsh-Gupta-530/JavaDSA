public class validPalindromeLeet125 {

    public static boolean isPalindrome(String s) {
        StringBuilder sb=new StringBuilder("");
        for(int i=0;i<s.length();i++){
            if(Character.isLetterOrDigit(s.charAt(i))) 
                sb.append(Character.toLowerCase(s.charAt(i)));
        }
        String s2=sb.toString();
        // System.out.println(sb);
        // System.out.println(s2);
        return isPalindromeHelper(s2,0,s2.length()-1);
    }
    public static boolean isPalindromeHelper(String s2, int startIdx, int endIdx){

        if(startIdx >= endIdx) return true;
        //check
        if(s2.charAt(startIdx)!=s2.charAt(endIdx)){
            return false;
        }
        return isPalindromeHelper(s2, startIdx+1, endIdx-1); // call for next idx 
    }
    public static void main(String[] args) {
        String s="A man, a plan, a canal: Panama";
        System.out.println(isPalindrome(s));
    }
}
