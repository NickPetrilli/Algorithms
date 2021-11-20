public class BST {
     TreeNode root;

    static int totalComparisons = 0;
    static int comparisons = 0;


    public BST() {
        root = new TreeNode();
    }
    //Doesn't work properly, returns an average of around 14 per search when should be 9-10
    public void search(TreeNode treeRoot, String target) {
        comparisons = 0;
        TreeNode current = treeRoot;
        TreeNode parent = null;
        String path = "";
        while (current != null && current.data.compareTo(target) != 0) {
            parent = current;
            if (target.compareTo(current.data) < 0 ) {
                current = current.left;
                path += "L, ";
                comparisons++;
            }
            else {
                current = current.right;
                path += "R, ";
                comparisons++;
            }
        }
        
        if (parent == null) {
            System.out.println("The node with target string " + target + " is the root node");
        }
        else if (target.compareTo(parent.data) < 0) {
            path += "L";
            comparisons++;
        }
        else {
            path += "R";
            comparisons++;
        }
        System.out.println("The path for searching for " + target + " was " + path);
        totalComparisons += comparisons;

    }
    
    
    //Insert a node into the tree
    public void insert(BST tree, TreeNode newNode) {
        String path = "";
        TreeNode trailing = null;
        TreeNode current = tree.root;
        while (current != null) {
            trailing = current;
            if (newNode.data.compareToIgnoreCase(current.data) < 0) {
                current = current.left;
                path += "L, ";
            }
                
            else { //must be >=
                current = current.right;
                path += "R, ";
            } 
                
        }
        newNode.parent = trailing;
        if (trailing == null)
            tree.root = newNode;
        else if (newNode.data.compareToIgnoreCase(trailing.data) < 0) {
            trailing.left = newNode;
            path += "L";
        }
            
        else {
            trailing.right = newNode;
            path += "R";
        }
        System.out.println("The path for inserting " + newNode.data + " was " + path);  
    }
    public void inOrderTraversal(TreeNode node) {
        //base case to know there are no more nodes left
        if (node == null)
            return;
        inOrderTraversal(node.left);
        System.out.println(node.data);
        inOrderTraversal(node.right);
    }
    public int getTotalComparisons() {
        return totalComparisons;
    }
    public int getComparisons() {
        return comparisons;
    }
}