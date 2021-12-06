import java.io.*;
import java.util.*;

public class DynamicProgramming {

    public static int numVerticies = 0;
    public static int numEdges = 0;
    public static void main(String[] args) {

    readAndParseGraphFile();

    }
    public static void readAndParseGraphFile() {

        File myFile = new File("graphs2.txt");


        try {
            Scanner fileScan = new Scanner(myFile);
        //Populates the array with the lines from text file
        while (fileScan.hasNext()) {
            String line = fileScan.nextLine();
            String[] words = line.split(" ");

            ArrayList<Integer> edgeList = new ArrayList<Integer>();
            ArrayList<Integer> vertexList = new ArrayList<Integer>();
            
            for (int i = 0; i < words.length; i++) {
                if (line.contains("new") && i == 0) {
                    System.out.println("Generating New Graph");
                    numVerticies = 0;
                    numEdges = 0;
                }//if
                else if (line.contains("add") && isNumber(words[i])) {
                    if (line.contains("vertex")) {
                        vertexList.add(Integer.parseInt(words[i]));
                        numVerticies++;
                    }//if
                    else if (line.contains("edge")) {
                        edgeList.add(Integer.parseInt(words[i]));
                        numEdges++;
                    }//else if
                }//else if
                //empty line means the graph is finished adding its verticies and edges
                else if (line.isEmpty()) {
                    System.out.println("Blankline");
                    int verticies = numVerticies;
                    int edges = numEdges / 3; //divide by three because the weights were in the same line and accounted for

                    System.out.println("Number of verticies in graph is: " + verticies + " and edges " + edges);
                }//else if
            }//for
            
        }
        fileScan.close();            
        }
        catch (FileNotFoundException e) {
            e.printStackTrace();

        }

    }
    public static boolean isNumber(String str) {
        if (str == null || str.length() == 0) {
            return false;
        }
        for (char c: str.toCharArray()) {
            if (!(Character.isDigit(c))) {
                return false;
            }
        }
        return true;
    }

}
