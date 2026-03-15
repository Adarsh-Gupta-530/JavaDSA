import java.util.*;
public class GFGTopViewOfBinaryTree {
    static class Node{
        int data;
        Node left;
        Node right;
        Node(int data){
            this.data = data;
            this.left = null;
            this.right  = null;
        }
    }
    static class Info{
        Node node;
        int hd;
        public Info(Node node , int hd ){
            this.node = node;
            this.hd =  hd;
        }
    }
    public static void TopView(Node root){
        // level order
        Queue<Info> q = new LinkedList<>();
        HashMap<Integer, Node> map = new HashMap<>();
        // ArrayList<Integer> ans  = new ArrayList<>();
        int min = 0, max = 0;
        q.add(new Info(root,0));
        q.add(null);

        while(!q.isEmpty()){
            Info curr = q.remove();
            if(curr == null){
                if(q.isEmpty()){
                    break;
                }else{
                    q.add(null);
                }
            }

            if(map.containsKey(curr.hd)){
                map.put(curr.hd, curr.node); // first time
            }

            if(curr.node.left!=null){
                q.add(new Info(curr.node.left, curr.hd-1));
                min = Math.min(min, curr.hd-1);
            }
            if(curr.node.right !=null){
                q.add(new Info(curr.node.right, curr.hd+1));
                max = Math.max(max, curr.hd+1);
            }
        }
        for(int i =min; i<=max ; i++){
            System.out.println(map.get(i).data);
        }
        System.out.println();

    }
    public static void main(String[] args) {
          /*
                1
              /   \
             2     3
              \   / \
               4 5   6
        */

        Node root = new Node(1);

        root.left = new Node(2);
        root.right = new Node(3);

        root.left.right = new Node(4);

        root.right.left = new Node(5);
        root.right.right = new Node(6);

        TopView(root);
    }
}
