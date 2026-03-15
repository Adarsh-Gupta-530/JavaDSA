import java.util.*;
class BinaryTreeBuildTree{
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
    static class BinaryTree{
        static int index = -1; // index
        public static Node buildTree(int nodes[]){   // TC-> O(n), SC-> O(1)
            index++;
            if(nodes[index] == -1) return null; // inorder arrayb is empty
            
            Node newNode = new Node(nodes[index]);  //create a new node 
            newNode.left = buildTree(nodes);  // left subtree
            newNode.right = buildTree(nodes);  //right subtree

            return newNode;
        }

        public static void preOrder(Node root){
            //TC->O(n), SC->O(n)
            if(root == null) return;
            // if(root == null){
            //     System.out.print("-1 ");
            //     return;
            // } 
            System.out.print(root.data+" ");
            preOrder(root.left);
            preOrder(root.right);
        }
        public static void inOrder(Node root){
            //TC->O(n), SC->O(n)
            if(root == null) return;
            // if(root == null){
            //     System.out.print("-1 ");
            //     return;
            // } 
            preOrder(root.left);
            System.out.print(root.data+" ");
            preOrder(root.right);
        }
        public static void postOrder(Node root){
            //TC->O(n), SC->O(n)
            if(root == null) return;
            // if(root == null){
            //     System.out.print("-1 ");
            //     return;
            // } 
            preOrder(root.left);
            preOrder(root.right);
            System.out.print(root.data+" ");
        }

        public void levelOrder(Node root){
            if(root == null) return;
            Queue<Node> q = new LinkedList<>();
            q.add(root);
            q.add(null);

            while(!q.isEmpty()){
                Node currNode = q.remove();
                if(currNode == null){
                    System.out.println();
                    if(q.isEmpty()) break;
                    else q.add(null);
                }else{
                    System.out.print(currNode.data+" ");
                    if(currNode.left!=null) q.add(currNode.left);
                    if(currNode.right!= null) q.add(currNode.right);
                }
            }
        }
    }
    public static void main(String[] args) {
        int nodes[] = {1,2,4,-1,-1,5,-1,-1,3,-1,6,-1,-1}; // preorder

        BinaryTree tree = new BinaryTree();
        Node root = tree.buildTree(nodes);
        // System.out.println(root.data);
        // tree.preOrder(root);
        // System.out.println();
        // tree.inOrder(root);
        // System.out.println();
        // tree.postOrder(root);
        tree.levelOrder(root);
    }
}