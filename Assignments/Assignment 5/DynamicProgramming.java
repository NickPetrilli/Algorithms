import java.io.*;
import java.util.*;

public class DynamicProgramming {

    public static int numVerticies = 0;
    public static int numEdges = 0;
    public static void main(String[] args) {

        //readAndParseGraphFile();

        readAndParseSpiceFile();

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
                    //System.out.println("Blankline");
                    int verticies = numVerticies;
                    int edges = numEdges / 3; //divide by three because the weights were in the same line and accounted for

                    System.out.println("Number of verticies in graph is: " + verticies + " and edges " + edges);
                    DirectedGraph graph = new DirectedGraph(verticies, edges);
                    //graph.bellmanFord(graph, 0);
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

    public static void readAndParseSpiceFile() {

        File myFile = new File("spice.txt");

        List<KnapsackItem> items = new ArrayList<>();
        Knapsack knapsack = new Knapsack(items, 0);

        try {
            Scanner fileScan = new Scanner(myFile);

        //Populates the array with the lines from text file
        while (fileScan.hasNext()) {
            String line = fileScan.nextLine();
            
            String spiceName = "";
            double totalPrice = 0;
            int quantity = 0;
            int knapsackCapacity = 0;

            if (!line.isEmpty() && !line.contains("--")) {
                String[] words = line.split(";");
                for (int i = 0; i < words.length; i++) {
                    //each line is split by semi-colon, so finding the last index of a space and adding one is anything after the equal sign
                    //which is the information that we want
                    String target = words[i].substring(words[i].lastIndexOf(" ") + 1);
                    if (words[i].contains("spice name")) {
                        spiceName = target;
                        //System.out.println(spiceName);
                    }//if
                    else if (words[i].contains("total_price")) {
                        totalPrice = Double.parseDouble(target);
                        //System.out.println(totalPrice);
                    }//else if
                    else if (words[i].contains("qty")) {
                        quantity = Integer.parseInt(target);
                        //System.out.println(quantity);
                    }//else if
                    else if (words[i].contains("capacity")) {
                        knapsackCapacity = Integer.parseInt(target);
                        //System.out.println(knapsackCapacity);
                    }
                }//for

                //now need to create a knapsack and add these items in

                knapsack.addItem(spiceName, totalPrice, quantity);
                System.out.println("Added the following item to the knapsack: " + "spiceName = " + spiceName + " totalPrice = " + totalPrice + " quantity = " + quantity);
            }
            
        }
        fileScan.close();            
        }
        catch (FileNotFoundException e) {
            e.printStackTrace();

        }
    }

}
