import java.util.*;
public class Leet987VerticalOrderTreversalofBinaryTree {
    static class Node {
        int data;
        Node left, right;

        Node(int data) {
            this.data = data;
            left = right = null;
        }
    }

    static class Info{
        Node node;
        int hd;
        public Info(Node node , int hd){
            this.node = node;
            this.hd = hd;
        }
    }
    public static ArrayList<ArrayList<Integer>> verticalOrder(Node root){
        //TC->O(n), SC->O(n)
        Queue<Info> q = new LinkedList<>();
        HashMap<Integer, ArrayList<Integer>> map = new HashMap<>();
        int min = 0, max =0;
        
        q.add(new Info(root, 0));
        q.add(null);

        while(!q.isEmpty()){
            Info curr = q.remove();
            if(curr == null){
                if(q.isEmpty()) break;
                q.add(null);
                continue;
            }

            if(!map.containsKey(curr.hd)){  // first time occur
                map.put(curr.hd, new ArrayList<>());
            }
            map.get(curr.hd).add(curr.node.data);  // add data 

            if(curr.node.left!=null){
                q.add(new Info(curr.node.left, curr.hd-1));
                min = Math.min(min, curr.hd-1);
            }

            if(curr.node.right!=null){
                q.add(new Info(curr.node.right, curr.hd+1));
                max = Math.max(max, curr.hd+1);
            }
        }

        ArrayList<ArrayList<Integer>> ans = new ArrayList<>();
        for(int i = min; i<= max; i++){
            ans.add(new ArrayList<>(map.get(i)));
        }
        return ans;
    }
    public static void main(String[] args) {
        Node root = new Node(1);
        root.left = new Node(2);
        root.right = new Node(3);
        root.left.left = new Node(4);
        root.left.right = new Node(5);
        root.right.left = new Node(6);
        root.right.right = new Node(7);

        System.out.println(verticalOrder(root));
    }
}
