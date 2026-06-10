public class GFGLargestBST {
    static class Node {
        int data;
        Node left, right;
        public Node(int data){
            this.data = data;
            this.left = left;
            this.right = right;
        }
    }

    // public static int findLargestBSTOptimal1(Node root){
    //     int leftSubTree = findLargestBSTHelper(root.left);
    //     int rightSubTree = findLargestBSTHelper(root.right);

    //     return Math.max(leftSubTree, rightSubTree);
    // }
    // public static int findLargestBSTHelper(Node root){
    //     if(root.left == null && root.right == null) return 1; // base case 
    //     // if(root.left == null || root.right == null) return 0; 

    //     if ((root.left == null || root.left.data < root.data) &&
    //         (root.right == null || root.right.data > root.data)){
    //         int left = (root.left!=null) ? findLargestBSTHelper(root.left) : 0;  //  dfs
    //         int right = (root.right!=null) ? findLargestBSTHelper(root.right) : 0; // dfs
    //         int size = (left+right+1);
    //         return size;
    //     }
    //     return 0;
    // }


    //Brute force->Time: O(n²) (brute), Space: O(h)
    public static int findLargestBSTBrute(Node root){
        if(root == null) return 0;

        // 1-> check for bst
        if(isBST(root, Integer.MIN_VALUE, Integer.MAX_VALUE)){
            return size(root);
        }
        // 2-> if bst calculate size
        return Math.max(findLargestBSTBrute(root.left),
                        findLargestBSTBrute(root.right));
    }
    public static boolean isBST(Node root, int min, int max){
        if(root == null) return true;
        if(root.data <= min || root.data >= max) return false;
        return isBST(root.left, min, root.data) &&
            isBST(root.right, root.data, max);
    }
    public static int size(Node root){
        if(root == null) return 0;
        return 1 + size(root.left) + size(root.right);
    }

    //Optimal ->
    public static void main(String[] args) {
        // Constructing the binary tree
        Node root = new Node(5);
        root.left = new Node(2);
        root.right = new Node(4);
        root.left.left = new Node(1);
        root.left.right = new Node(3);
        System.out.println("Size : " + findLargestBSTBrute(root));    
    }
}
