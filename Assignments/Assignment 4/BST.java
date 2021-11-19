public class BST {
    TreeNode root;

    int totalComparisons = 0;
    int tempComparisons = 0;


    public BST() {
        root = null;
    }
    /*
    public TreeNode search(String target) {
        TreeNode current = root;
        String path = "";

        //when the current.data is equal to the target, it breaks out of while loop and returns current node
        while(current.data.compareTo(target) != 0) {
            tempComparisons++;
            if (current.data.compareTo(target) < 0) {
                tempComparisons++;
                path += "L";
                current = current.left;
            }
            else { //must be >=
                tempComparisons++;
                path += "R";
                current = current.right;
            }
            if (current == null) {
                return current;
            }
        }
        System.out.println("The path for inserting " + target + " was " + path);
        System.out.println("The number of comparisons was " + tempComparisons);
        totalComparisons += tempComparisons;
        return current;
    }
    */
    public static TreeNode search(TreeNode treeRoot, String target) {
        if (treeRoot.data == null || treeRoot.data.compareTo(target) == 0) {
            return treeRoot;
        }
        else if (treeRoot.data.compareTo(target) < 0) {
            BST.search(treeRoot.left, target);
        }
        else {
            BST.search(treeRoot.left, target);
        }
        return treeRoot;
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
        System.out.println(path);  
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
        return tempComparisons;
    }
}