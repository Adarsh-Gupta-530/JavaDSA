import java.util.*;
public class LongestSubstringWithKUniques {
    public static int longestKUniqueBrute(String s, int k){
        // brute -> TC->O(n^2), SC->O(n)
        int maxLen = 0;
        for(int i = 0 ;i<s.length();i++){
            HashMap<Character, Integer> map = new HashMap<>();
            for(int j = i; j<s.length() ; j++){
                map.put(s.charAt(j), map.getOrDefault(s.charAt(j), 0)+1);
                if(map.size()<=k){
                    maxLen = Math.max(maxLen, j-i+1);
                }else{  // if exceeded
                    break;
                }
            }
        }
        return maxLen;
    }
    public static int longestKUniqueOptimal(String s, int k){ 
        // two-pointer , sliding window ->TC->O(2n), SC->O(n)
        int maxLen = 0;
        int l = 0;
        int r = 0; 
        HashMap<Character, Integer> map = new HashMap<>();

        while(r<s.length()){
            map.put(s.charAt(r), map.getOrDefault(s.charAt(r), 0)+1); // put into map
            while(map.size()>k){ // if exceeded 
                    char ch = s.charAt(l);
                    map.put(ch, map.get(ch)-1);
                    if(map.get(ch) == 0) map.remove(ch);
                    l++;
            }
            if(map.size()==k){  // if valid -> update maxLen
                maxLen = Math.max(maxLen, r-l+1);
            }
            r++;
        }
        return maxLen==0 ? -1 : maxLen;
    }
    public static void main(String[] args) {
        // String s = "aabacbebebe";
        // int k = 3;
        String s = "aaaa";
        int k = 2; 

        System.out.println(longestKUniqueOptimal(s, k));
    }
}
