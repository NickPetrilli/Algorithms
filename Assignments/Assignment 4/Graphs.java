import java.io.*;
import java.util.*;

public class Graphs {
    final static int NUM_ITEMS = 666;
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
        for (int j = 0; j < NUM_ITEMS; j++) {
            TreeNode temp = new TreeNode(magicItems[j]);
            bTree.insert(bTree, temp);
        }
        bTree.inOrderTraversal(bTree.root);
        }
    
}
