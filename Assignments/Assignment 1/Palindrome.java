import java.io.*;
import java.util.*;

public class Palindrome {

    public static void main(String[] args) {

        Stack myStack = new Stack();
        Queue myQueue = new Queue();

        String normal = "";
        String reverse = "";

        int numItems = 666;
        String[] magicItems = new String[numItems];
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
        //For loop for every element (every line)
        for (int j = 0; j < numItems; j++) {
            //For loop to push and enqueue every character of each line
            for (int k = 0; k < magicItems[j].length(); k++) {
                myStack.push(magicItems[j].charAt(k));
                myQueue.enqueue(magicItems[j].charAt(k));
            }
            //Pop and dequeue each character until the stack (and queue) is empty
            while (!myStack.isEmpty()) {
                reverse += myStack.pop();
                normal += myQueue.dequeue();
            }
            //Check to see if the element is equal to itself reversed
            if (reverse.equals(normal)) {
                System.out.println(normal + " is a palindrome.");
            }
            //reset the strings to empty for the next element
            normal = "";
            reverse = "";
            
        }

        
    }
    
}
