import java.util.HashMap;

public class GFGKSumPath {
    static class Node{
        int data;
        Node left, right;

        Node(int data){
            this.data = data;
            this.left = null;
            this.right = null;
        }
    }
    public static void main(String[] args) {
        Node root = new Node(10);
        root.left = new Node(5);
        root.right = new Node(-3);
        root.left.left = new Node(3);
        root.left.right = new Node(2);
        root.right.right = new Node(11);
        root.left.left.left = new Node(3);
        root.left.left.right = new Node(-2);
        root.left.right.right = new Node(1);

        int k = 8;
        HashMap<Long, Integer> map = new HashMap<>();
        map.put(0L, 1); // Base case: there's one way to have a sum of 0 (by taking no nodes)
        int result = checkSum(root, k, map, 0L);
        System.out.println("Number of paths with sum " + k + ": " + result);
    }
    public static int checkSum(Node root, int k, HashMap<Long,Integer> map, long sum){

        if(root == null) return 0;

        int ans = 0;

        sum += root.data;

        if(map.containsKey(sum - k))
            ans += map.get(sum - k);

        map.put(sum, map.getOrDefault(sum, 0) + 1);

        ans += checkSum(root.left, k, map, sum);
        ans += checkSum(root.right, k, map, sum);

        map.put(sum, map.get(sum) - 1); // backtracking

        return ans;
    }
}
