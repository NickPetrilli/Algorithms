import java.io.*;
import java.util.*;

public class Hash {
    public static void main(String[] args) {
        final int numItems = 666;
        String[] magicItems = new String[numItems];
        int i = 0;

        File myFile = new File("magicitems.txt");

        try {
            Scanner fileScan = new Scanner(myFile);
        //Populates the array with the lines from text file
        while (fileScan.hasNext()) {
            magicItems[i] = fileScan.nextLine().toLowerCase();
            i++;
        }
        fileScan.close();            
        }
        catch (FileNotFoundException e) {
            e.printStackTrace();
        }

        final int numElements = 42;
        String[] newArray = new String[numElements];
        Random rand = new Random();
        /*
        Randomly picks index number between 0 and 665 of magicItems
        and populates new array with the elements at those random indices
        */ 
        for (int j = 0; j < numElements; j++) {
            int randIndex = rand.nextInt(numItems);
            String randElement = magicItems[randIndex];
            newArray[j] = randElement;
        }
        insertionSort(newArray);
        //or could sort array first and then make new one
        for (int k = 0; k < numElements; k++) {
            linearSearch(newArray, newArray[k]);
        }
        for (int x = 0; x < numElements; x++) {
            binarySearch(newArray, newArray[x]);
        }
        

    }
    public static void insertionSort(String[] arr) {
        int n = arr.length;
        String key = "";
        int i;
        for(int j = 0; j < n - 2; j++) {
            key = arr[j];
            i = j - 1;
            while (i >= 0 && arr[i].compareTo(key) > 0) {
                arr[i + 1] = arr[i];
                i = i - 1;
            }
            arr[i + 1] = key;
        }
    }
    public static int linearSearch(String[] arr, String key) {
        int comparisons = 0;
        for (int i = 0; i < arr.length; i++) {
            comparisons++;
            if (arr[i].compareTo(key) > 0) {
                System.out.println("The number of comparisons for linear search is " + comparisons);
                return i;
            }
        }
        System.out.println("The number of comparisons for linear search is " + comparisons);
        return -1;
    }
    public static int binarySearch(String[] arr, String key) {
        int low = 0;
        int high = arr.length - 1;
        int mid;
        int counter = 0;
    
        while (low <= high) {
            mid = (low + high) / 2;
            if(arr[mid].compareTo(key) < 0) {
                low = mid + 1;
                counter++;
            }
            else if (arr[mid].compareTo(key) > 0) {
                high = mid - 1;
                counter++;
            }
            else {
                counter++;
                System.out.println("The number of comparisons for binary search is " + counter);
                return mid;
            }
        }
        System.out.println("The number of comparisons for binary search is " + counter);
        return -1;
    }
}
