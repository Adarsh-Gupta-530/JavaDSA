public class Leet344ReverseString {
    public static void reverseString(char[] s) {
        if(s.length==0) return;
        reverseStringHelper(s,0,s.length-1);
    }
    public static void reverseStringHelper(char[] s, int startIdx, int endIdx){
        if(startIdx>=endIdx) return;

        // swap
        char ch = s[startIdx];
        s[startIdx] = s[endIdx];
        s[endIdx] = ch;

        // call for remaining values
        reverseStringHelper(s, startIdx+1, endIdx-1); 
    }
    public static void main(String[] args) {
        char[] s ={'A',' ','m','a','n',',',' ','a',' ','p','l','a','n',',',' ','a',' ','c','a','n','a','l',':',' ','P','a','n','a','m','a'};
        reverseString(s);
        for (int i = 0; i < s.length; i++) {
            System.out.print("'"+s[i]+"' ");
        }
    }
}