import java.util.*;
public class GFGPredecessorandSuccessor {
    static class Node {
        int data;
        Node left, right;
        public Node(int data){
            this.data = data;
            this.left = left;
            this.right = right;
        }
    }
    public static ArrayList<Integer> findpreSuc(Node root, int key){
        // TC->O(h), SC->O(1)
        int pre = -1, suc = -1;
        Node temp = root;
        while(root!=null){ // Predecessor
            if(root.data < key){
                pre = root.data;
                root = root.right;
            }else{
                root = root.left;
            }
        }
        root = temp; // reset root as root

        while(root!=null){        // successor
            if(root.data > key){
                suc = root.data;
                root = root.left;
            }else{
                root = root.right;
            }
        }

        ArrayList<Integer> ans = new ArrayList<>();
        ans.add(pre);
        ans.add(suc);
        return ans;
    }
    public static void main(String[] args) {
        // Constructing the binary tree
        Node root = new Node(5);
        root.left = new Node(2);
        root.right = new Node(8);
        root.left.left = new Node(1);
        root.left.right = new Node(3);

        int key = 2;
        System.out.print(findpreSuc(root, key));
    }
}