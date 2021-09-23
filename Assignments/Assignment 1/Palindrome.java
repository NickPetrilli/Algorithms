import java.io.*;
import java.util.*;

public class Palindrome {

    public static void main(String[] args) {

        Stack myStack = new Stack();
        Queue myQueue = new Queue();

        int numItems = 666;
        String[] magicItems = new String[numItems];
        int i = 0;

        File myFile = new File("magicitems.txt");

        Scanner input = new Scanner(myFile);
        //Populates the array with the lines from text file
        while (input.hasNext()) {
            magicItems[i] = input.nextLine().toLowerCase().trim();
            i++;
        }
        input.close();
        //For every element (every line)
        for (int j = 0; j < numItems; j++) {
            //For every character of each line
            for (int k = 0; k < magicItems[j].length(); k++) {
                myStack.push(magicItems[j].charAt(k));
                myQueue.enqueue(magicItems[j].charAt(k));
            }
        }

    
    }
    
}
