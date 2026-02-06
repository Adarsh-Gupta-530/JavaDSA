import java.util.HashMap;

public class ValidAnagramsLeet242 {
    public static boolean isAnagram(String s, String t){
        if(s.length()!=t.length()) return false; // base case
        HashMap<Character, Integer> map = new HashMap<>();

        for(int i=0;i<s.length();i++){ // storing chars and their frequencies in map
            char ch = s.charAt(i);
            if(map.containsKey(ch)) map.put(ch, map.getOrDefault(ch, 0) + 1);
            else map.put(s.charAt(i), 1);
        }
        for(int i=0;i<t.length();i++){ //  poping out elements freq
            char ch=t.charAt(i);
            if(map.get(ch)!=null){
                if(map.get(ch)==1){
                    map.remove(ch);
                }else{
                    map.put(ch, map.get(ch)-1);
                }
            }else{
                return false;
            } 
        }
        return map.isEmpty();
       
    }
    public static void main(String[] args) {
        String s = "anagram";
        String t = "nagaram";
        System.out.println(isAnagram(s,t));
    }
}
