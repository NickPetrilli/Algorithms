import java.io.*;
import java.util.*;

public class Hash {
    final static int numItems = 666;

    public static void main(String[] args) {
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

        //Shuffle magic items array and take the first 42 elements for the new array
        shuffle(magicItems);
        for (int j = 0; j < numElements; j++) {
            newArray[j] = magicItems[j];
        }
        //Read in magic items array again because the first one was shuffled
        String[] magicItems2 = new String[numItems];
        int j = 0;

        File myFile2 = new File("magicitems.txt");

        try {
            Scanner fileScan = new Scanner(myFile2);
        //Populates the array with the lines from text file
        while (fileScan.hasNext()) {
            magicItems2[j] = fileScan.nextLine().toLowerCase();
            j++;
        }
        fileScan.close();            
        }
        catch (FileNotFoundException e) {
            e.printStackTrace();
        }
        insertionSort(newArray);

        int linearSearchNum = 0;
        int linearSearchSum = 0;
        for (int k = 0; k < numElements; k++) {
            //Send the unshuffled magic items array
            linearSearchNum = linearSearch(magicItems2, newArray[k]);
            linearSearchSum += linearSearchNum;
        }
        int linearSearchAvg = linearSearchSum / numElements;
        System.out.println("The average number of comparisons for linear search is " + linearSearchAvg);
        
        int binarySearchNum = 0;
        int binarySearchSum = 0;
        for (int x = 0; x < numElements; x++) {
            binarySearchNum = binarySearch(magicItems2, newArray[x]);
            binarySearchSum += binarySearchNum;
        }
        int binarySearchAvg = binarySearchSum / numElements;
        System.out.println("The average number of comparisons for binary search is " + binarySearchAvg);

        
        HashTable hash = new HashTable();
        for (int m = 0; m < numItems; m++) {
            int hashCode = hash.makeHashCode(magicItems[m]);
            hash.put(magicItems[m], hashCode);
        }
        //hash.printHash();
        int hashComparisons = 0;
        int hashSum = 0;
        for (int k = 0; k < numElements; k++) {
            hashComparisons = hash.get(newArray[k]);
            hashSum += hashComparisons;
        }
        int hashAvg = hashSum / numElements;
        System.out.println("The average number of comparisons for retrieving an item from the hash table is " + hashAvg);

    }
    public static void shuffle(String[] arr) {
        Random rand = new Random();
        int index;
        String str;
        for (int i = arr.length - 1; i > 0; i--) {
            index = rand.nextInt(i + 1);
            str = arr[index];
            arr[index] = arr[i];
            arr[i] = str;
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
            if (arr[i].compareToIgnoreCase(key) == 0) {
                System.out.println("The number of comparisons for linear search is " + comparisons);
                return i;
            }
        }
        System.out.println("The number of comparisons for linear search is " + comparisons);
        return -1;
    }
    //return counter
    public static int binarySearch(String[] arr, String key) {
        int low = 0;
        int high = arr.length - 1;
        int mid;
        int counter = 0;
    
        while (low <= high) {
            mid = (low + high) / 2;
            if (arr[mid].compareToIgnoreCase(key) == 0) {
                counter++;
                System.out.println("The number of comparisons for binary search is " + counter);
                return counter;
            }
            else if(arr[mid].compareToIgnoreCase(key) < 0) {
                low = mid + 1;
                counter++;
            }
            else if (arr[mid].compareToIgnoreCase(key) > 0) {
                high = mid - 1;
                counter++;
            }

        }
        System.out.println("The number of comparisons for binary search is " + counter);
        return counter;
    }

}
