import java.io.*;
import java.util.*;

public class Graphs {
    final static int NUM_ITEMS = 666;
    final static int NUM_ITEMS_2 = 42;
    public static void main(String[] args) {
        BST bTree = new BST();
        String[] magicItems = new String[NUM_ITEMS];
        int i = 0;

        File myFile = new File("magicitems.txt");

        try {
            Scanner fileScan = new Scanner(myFile);
        //Populates the array with the lines from text file
        while (fileScan.hasNext()) {
            magicItems[i] = fileScan.nextLine().toLowerCase().replace(" ", "");
            i++;
        }
        fileScan.close();            
        }
        catch (FileNotFoundException e) {
            e.printStackTrace();

        }
        //Creates nodes for each element in the array, and inserts it into the binary search tree
        for (int j = 0; j < NUM_ITEMS; j++) {
            TreeNode temp = new TreeNode(magicItems[j]);
            bTree.insert(bTree, temp);
        }
        //Prints out in order traversal of binary search tree
        bTree.inOrderTraversal(bTree.root);
        
        //Create new array for elements to search for in binary search tree and read in file
        String[] magicItems2 = new String[NUM_ITEMS_2];
        File myFile2 = new File("magicitems-find-in-bst.txt");
        int k = 0;

        try {
            Scanner fileScan = new Scanner(myFile2);
        //Populates the array with the lines from text file
        while (fileScan.hasNext()) {
            magicItems2[k] = fileScan.nextLine().toLowerCase().replace(" ", "");
            k++;
        }
        fileScan.close();            
        }
        catch (FileNotFoundException e) {
            e.printStackTrace();

        }
    





        }

}
