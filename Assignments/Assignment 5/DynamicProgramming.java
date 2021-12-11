import java.io.*;
import java.util.*;

public class DynamicProgramming {

    public static int numVerticies = 0;
    public static int numEdges = 0;
    public static void main(String[] args) {

        /*
        int verticies = 5;
        int edges = 10;
        DirectedGraph graph = new DirectedGraph(verticies, edges);

        graph.edgeArray[0].source = 1;
        graph.edgeArray[0].destination = 2;
        graph.edgeArray[0].weight = 5;

        graph.edgeArray[1].source = 1;
        graph.edgeArray[1].destination = 3;
        graph.edgeArray[1].weight = 8;

        graph.edgeArray[2].source = 1;
        graph.edgeArray[2].destination = 4;
        graph.edgeArray[2].weight = -4;

        graph.edgeArray[3].source = 2;
        graph.edgeArray[3].destination = 1;
        graph.edgeArray[3].weight = -2;

        graph.edgeArray[4].source = 3;
        graph.edgeArray[4].destination = 2;
        graph.edgeArray[4].weight = -3;

        graph.edgeArray[5].source = 3;
        graph.edgeArray[5].destination = 4;
        graph.edgeArray[5].weight = 9;

        graph.edgeArray[6].source = 4;
        graph.edgeArray[6].destination = 2;
        graph.edgeArray[6].weight = 7;

        graph.edgeArray[7].source = 4;
        graph.edgeArray[7].destination = 0;
        graph.edgeArray[7].weight = 2;

        graph.edgeArray[8].source = 0;
        graph.edgeArray[8].destination = 1;
        graph.edgeArray[8].weight = 6;

        graph.edgeArray[9].source = 0;
        graph.edgeArray[9].destination = 3;
        graph.edgeArray[9].weight = 7;

        graph.bellmanFord(graph, 0);

        */


        //readAndParseGraphFile();
        System.out.println("\n");
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

            
            for (int i = 0; i < words.length; i++) {
                if (line.contains("new") && i == 0) {
                    System.out.println("Generating New Graph");
                    numVerticies = 0;
                    numEdges = 0;
                }//if
                else if (line.contains("add") && isNumber(words[i])) {
                    if (line.contains("vertex")) {
                        numVerticies++;
                    }//if
                    else if (line.contains("edge")) {
                        numEdges++;
                    }//else if
                }//else if
                //empty line means the graph is finished adding its verticies and edges
                else if (line.isEmpty()) {
                    //System.out.println("Blankline");
                    int verticies = numVerticies;
                    int edges = numEdges / 3; //divide by three because the weights were in the same line and accounted for

                    System.out.println("Number of verticies in graph is  " + verticies + " and number of edges is " + edges);
                    DirectedGraph graph = new DirectedGraph(verticies, edges);
                    graph.bellmanFord(graph, 0);
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

                
                if (knapsackCapacity == 0) {
                double unitPrice = totalPrice / quantity;
                knapsack.addItem(spiceName, totalPrice, quantity, unitPrice);
                System.out.println("Added the following item to the knapsack: " + "spiceName = " + spiceName + " totalPrice = " + 
                totalPrice + " quantity = " + quantity + " unitPrice = " + unitPrice);
                }//if
                else {
                    System.out.println("Running with capacity: " + knapsackCapacity);
                    knapsack.sortKnapsack();
                    Knapsack knapsackSolution = knapsack.solveHeist(knapsackCapacity);
                    System.out.println("Knapsack of capacity " + knapsackCapacity + " is worth " + knapsackSolution.totalWorth() + " quatloos");
                }//else

            }
            
        }
        fileScan.close();            
        }
        catch (FileNotFoundException e) {
            e.printStackTrace();

        }
    }

}
