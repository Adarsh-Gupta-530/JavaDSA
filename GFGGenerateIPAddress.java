import java.util.*;

class GFGGenerateIPAddress{
    public static boolean validOctate(String s){
        if(s.length() > 1 && s.charAt(0) == '0'){
            return false;
        }
        int num = Integer.parseInt(s);
        return num >=0 && num<=255 ;
    }
    public static ArrayList<String> generateIp(String s) {
        ArrayList<String> ans = new ArrayList<>();
        int n = s.length();
        if(n<4 || n>12) return ans;  //BC
        for(int  i=1; i<=3;i++){
            for(int j = 1; j<=3;j++){
                for(int k =1; k<=3;k++){
                    int l = n-(i+j+k);
                    if(l<1 || l>3) continue;

                    String A = s.substring(0, i);
                    String B = s.substring(i, i + j);
                    String C = s.substring(i + j, i + j + k);
                    String D = s.substring(i + j + k, n);

                    if(validOctate(A) && validOctate(B) && validOctate(C) && validOctate(D) ){
                        ans.add(A+"."+B+"."+C+"."+D);
                    }
                }
            }
        }
        return ans;

    }
    public static void main(String[] args) {
        String s = "255678166";
        System.out.print(generateIp(s));
    }
}