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
            magicItems[i] = fileScan.nextLine().toLowerCase();
            i++;
        }
        fileScan.close();            
        }
        catch (FileNotFoundException e) {
            e.printStackTrace();
        }

        mergeSort(magicItems);

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
    public static void mergeSort(String[] arr) {
        int length = arr.length;
        int mid = length / 2;

        if (arr.length < 2) {
            return;
        }

        //Create left and right side arrays
        String[] leftArr = new String[mid];
        String[] rightArr = new String[length - mid];

        //Populate left side array with the first half of elements from orignal array
        for (int i = 0; i < mid; i++) {
            leftArr[i] = arr[i];
        }
        //Populate right side array with second half of elements from original array
        for (int j = mid; j < length; j++) {
            rightArr[j - mid] = arr[j];
        }

        mergeSort(leftArr);
        mergeSort(rightArr);

        merge(arr, leftArr, rightArr);
    
    }
    public static void merge(String[] arr, String[] leftArr, String[] rightArr) {
        int leftSize = leftArr.length;
        int rightSize = rightArr.length;

        //Three variables to keep track of the left array (i), right array (j), and the result array (k)
        int i = 0;
        int j = 0;
        int k = 0;

        //Loop until run out of elements in left or right array
        while (i < leftSize && j < rightSize) {
            //If the element in the left array comes first alphabetically, it is added to the result array
            // and i gets incremented because the element was just added
            if (leftArr[i].compareTo(rightArr[j]) < 0) {
                arr[k] = leftArr[i];
                i++;
            }
            else {
                // Else means the element in the right array comes first alphabetically so it is added into the result array
                // and j is incremented to move onto the next element
                arr[k] = rightArr[j];
                j++;
            }
            //Outside of the if statement, either way an element is being added to the result array
            // so k has to be incremented to move to the next index
            k++;
        }
        //Adds remaining elements of the left array if the right array was finished first
        while (i < leftSize) {
            arr[k] = leftArr[i];
            i++;
            k++;
        }
        //Adds remaning elements of right array if the left array finished first
        while (j < rightSize) {
            arr[k] = rightArr[j];
            j++;
            k++;
        }       
    }  
}
