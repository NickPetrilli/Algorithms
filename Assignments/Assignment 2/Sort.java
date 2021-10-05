import java.io.*;
import java.util.*;

public class Sort {

    public static void main(String[] args) {
        final int numItems = 666;
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

        insertionSort(magicItems);
    }
    public static void selectionSort(String[] arr) {
        int n = arr.length;
        String temp = "";
        int counter = 0;
        for (int i = 0; i < n - 2; i++) {
            for (int j = i + 1; j < n - 1; j++) {
                counter++;
                if (arr[i].compareTo(arr[j]) > 0) {
                    temp = arr[i];
                    arr[i] = arr[j];
                    arr[j] = temp;
                }
            }
        }

        System.out.println("The number of comparisons for selection sort is " + counter);        
    }

    public static void insertionSort(String[] arr) {
        int n = arr.length;
        String key = "";
        int i;
        int counter = 0;
        for(int j = 0; j < n - 2; j++) {
            key = arr[j];
            i = j - 1;
            while (i >= 0 && arr[i].compareTo(key) > 0) {
                counter++;
                arr[i + 1] = arr[i];
                i = i - 1;
            }
            arr[i + 1] = key;
        }

            System.out.println("The number of comparisons for insertion sort is " + counter);
        
    }
    
}
