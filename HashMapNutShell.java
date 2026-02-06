// import java.util.HashMap;
import java.util.*;     // import to use hashmap inside program 

public class HashMapNutShell {
    public static void main(String[] args) {
        HashMap<String, Integer> map = new HashMap<>(); //creating hashmap;
        
        // Insert - O(1)
        map.put("India",120);
        map.put("China",150);
        map.put("USA",50);
        // System.out.println(map);

        // Update - O(1)
        map.put("India", 130);
        // System.out.println(map);

        // Get operation - O(1) -> if key exists return its value but if not present it returns null value.
    //    System.out.println( map.get("India"));

    //    containsKey(key) -> O(1) - returns true if key contains else returns false if doesn't exists.
        // System.out.println(map.containsKey("India"));

        // remove(key) ->O(1) -> remove (key, value) from hashmap if key matched else return null
        // System.out.println(map.remove ("China"));
        // System.out.println(map);

        // size of hashmap
        // System.out.println(map.size());

        // IsEmpty
        // System.out.println(map.isEmpty());

        // clear() -> clear the map 
        // map.clear();
        // System.out.println(map);

        // **Iteration on hashmap
        map.put("Nepal", 20);
        map.put("Sweeden", 15);

        // 1. using keySet -> stores keys 
        // 2. using entrySet -> stores pairSet
        Set<String> keys = map.keySet();
        // System.out.print(keys);

        for(String k : keys){ // for each loop
            System.out.println("Key:"+k+", value:"+map.get(k));
        }

        
    }
}
