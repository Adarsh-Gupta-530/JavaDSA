import java.util.*;
public class Leet205IsomorphicString {
    public static boolean isIsomorphicBrute(String s, String t) { // brute force -> O(n^2), o(n)
        HashMap<Character,Character> map = new HashMap<>();
        for(int i=0;i<s.length();i++){
            if(map.containsKey(s.charAt(i)) && map.get(s.charAt(i)) != t.charAt(i)){ 
                return false;
            }else if(map.containsKey(s.charAt(i)) && map.get(s.charAt(i)) == t.charAt(i)){
                continue;
            }
            else{
                Set<Character> keys = map.keySet();
                for(char key : keys ){
                    if(map.get(key) == t.charAt(i)) return false;
                }
                map.put(s.charAt(i), t.charAt(i));
            } 
        }
        return true;    
    }
    public static boolean isIsomorphicBetter(String s, String t) {
        // Optimal using hashmap ->TC->O(n), SC->O(n)
        HashMap<Character, Character> map1 = new HashMap<>();
        HashMap<Character, Character> map2 = new HashMap<>();

        for(int i=0;i<s.length();i++){
            if((map1.containsKey(s.charAt(i)) && map1.get(s.charAt(i)) != t.charAt(i)) || (map2.containsKey(t.charAt(i)) && map2.get(t.charAt(i)) != s.charAt(i))){
                return false;
            }
            map1.put(s.charAt(i), t.charAt(i));
            map2.put(t.charAt(i), s.charAt(i));
        }
        return true;
    }
    public static boolean isIsomorphicOptimal(String s, String t) {
        // optimal using array based approach -> TC->O(n) , SC->O(1) 
        // why 256 size because ASCII table contains 256 char
        int map1[] = new int[256];
        int map2[] = new int[256];

        for(int i = 0; i<s.length();i++){
            char c1 = s.charAt(i);
            char c2 = t.charAt(i);
            if(map1[c1]==0 && map2[c2]==0){
                map1[c1] = c2;  // map s->t char
                map2[c2] = c1;  // map t->s char
            }else if(map1[c1]!=c2 || map2[c2] != c1){
                return false;
            }
        }
        return true;
    }
    public static void main(String[] args) {
        // String s = "egg";
        // String t = "odd";
        String s = "abc";
        String t = "xxy";
        System.out.println(isIsomorphicOptimal(s, t));
    }
}
