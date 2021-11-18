public class BST {
    TreeNode root;

    public BST() {
        root = null;
    }
    public static TreeNode search(TreeNode root, String target) {
        if (root.data == null || root.data.compareTo(target) == 0) 
            return root;
        else if (root.data.compareTo(target) > 0) 
            BST.search(root.left, target);
            else
                BST.search(root.right, target);
        return root;
    }

    public void insert(BST tree, TreeNode newNode) {
        TreeNode trailing = null;
        TreeNode current = tree.root;
        while (current != null) {
            trailing = current;
            if (newNode.data.compareToIgnoreCase(current.data) < 0)
                current = current.left;
            else //must be >=
                current = current.right;
        }
        newNode.parent = trailing;
        if (trailing == null)
            tree.root = newNode;
        else if (newNode.data.compareToIgnoreCase(trailing.data) < 0) {
            trailing.left = newNode;
        }
            
        else {
            trailing.right = newNode;
        }  
    }
    public void inOrderTraversal(TreeNode node) {
        //base case to know there are no more nodes left
        if (node == null)
            return;
        inOrderTraversal(node.left);
        System.out.println(node.data);
        inOrderTraversal(node.right);
    }
}