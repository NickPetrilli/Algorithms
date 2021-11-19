import java.io.*;
import java.util.*;

public class Graphs {
    final static int NUM_ITEMS = 666;
    final static int NUM_ITEMS_2 = 42;
    final static int NUM_LINES_IN_GRAPHS = 375;

    static GraphMatrix graphMatrix;
    static GraphLinkedObjects graphLinkedObjects;


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
        //Creates nodes for each element in the array, and inserts them into the binary search tree
        for (int j = 0; j < NUM_ITEMS; j++) {
            TreeNode temp = new TreeNode(magicItems[j]);
            bTree.insert(bTree, temp);
        }

        System.out.println("\n**In Order Traversal of Binary Search Tree**");

        //Prints out in order traversal of binary search tree
        bTree.inOrderTraversal(bTree.root);
        
        //Create new array for elements to search for in binary search tree and read in file
        String[] magicItems2 = new String[NUM_ITEMS_2];
        File myFile2 = new File("magicitems-find-in-bst.txt");
        int k = 0;

        try {
            Scanner fileScan2 = new Scanner(myFile2);
        //Populates the array with the lines from text file
        while (fileScan2.hasNext()) {
            magicItems2[k] = fileScan2.nextLine().toLowerCase();
            k++;
        }
        fileScan2.close();            
        }
        catch (FileNotFoundException e) {
            e.printStackTrace();

        }
        //Search for each of the 42 magic items in the binary search tree
        
        for (int m = 0; m < NUM_ITEMS_2; m++) {
            System.out.println(bTree.root.data);
            bTree.search(bTree.root, magicItems2[m]);
            System.out.println("The number of comparisons was " + bTree.getComparisons());
        }
        double average = bTree.getTotalComparisons() / NUM_ITEMS_2;
        System.out.println("The average number of comparisons for a search in a binary search tree is: " + average);
        System.out.println(bTree.root.data);
        
        String[] graphInstructions = new String[NUM_LINES_IN_GRAPHS];
        
        int n = 0;

        File myFile3 = new File("graphs1.txt");

        try {
            Scanner fileScan3 = new Scanner(myFile3);
        //Populates the array with the lines from text file
        while (fileScan3.hasNext()) {
            graphInstructions[n] = fileScan3.nextLine().toLowerCase();
            n++;
        }
        fileScan3.close();            
        }
        catch (FileNotFoundException e) {
            e.printStackTrace();

        }

        int graphNum = 0;

        ArrayList<Integer> graph1Verticies = new ArrayList<Integer>();
        ArrayList<Integer> graph2Verticies = new ArrayList<Integer>();
        ArrayList<Integer> graph3Verticies = new ArrayList<Integer>();
        ArrayList<Integer> graph4Verticies = new ArrayList<Integer>();
        ArrayList<Integer> graph5Verticies = new ArrayList<Integer>();
        ArrayList<Integer> graph1Edges = new ArrayList<Integer>();
        ArrayList<Integer> graph2Edges = new ArrayList<Integer>();
        ArrayList<Integer> graph3Edges = new ArrayList<Integer>();
        ArrayList<Integer> graph4Edges = new ArrayList<Integer>();
        ArrayList<Integer> graph5Edges = new ArrayList<Integer>();



        
        for (int x = 0; x < NUM_LINES_IN_GRAPHS; x++) {
            //System.out.println(graphInstructions[x]);
            if (graphInstructions[x].contains("new")) {
                graphNum++;
                System.out.println("Creating Graph Number: " + graphNum);
            }//if
            else if (graphInstructions[x].contains("add vertex")) {
                //removes all non numeric text in line
                String num = graphInstructions[x].replaceAll("[^\\d.]", "");
                int vertex = Integer.parseInt(num);
                Vertex v = new Vertex(vertex);

                //determine which number graph list to add the vertex to
                if(graphNum == 1) {
                    graph1Verticies.add(vertex);
                }
                else if(graphNum == 2) {
                    graph2Verticies.add(vertex);
                }
                else if(graphNum == 3) {
                    graph3Verticies.add(vertex);
                }
                else if(graphNum == 4) {
                    graph4Verticies.add(vertex);
                }
                else if(graphNum == 5) {
                    graph5Verticies.add(vertex);
                }
            }
            else if (graphInstructions[x].contains("add edge")) {
                int edge1 = 0;
                int edge2 = 0;
                int counter = 0;
                
                
                //Split the array at the spaces, and check if the new strings are numbers
                //if they are numbers, they are the edge numbers we need to add to the graph
                ArrayList<Integer> intList = new ArrayList<Integer>();
                for (String splitString: graphInstructions[x].split(" ")) {
                    if(isNumber(splitString)) {
                        intList.add(Integer.parseInt(splitString));
                    }//if
            
                }//for
                //there are only two numbers in the line, so they will be the first two elements in the array list
                edge1 = intList.get(0);
                edge2 = intList.get(1);

                System.out.println(edge1 + " and " + edge2);

                if (graphNum == 1) {
                    graph1Edges.add(edge1);
                    graph1Edges.add(edge2);
                }
                else if (graphNum == 2) {
                    graph2Edges.add(edge1);
                    graph2Edges.add(edge2);
                }
                else if (graphNum == 3) {
                    graph3Edges.add(edge1);
                    graph3Edges.add(edge2);
                }
                else if (graphNum == 4) {
                    graph4Edges.add(edge1);
                    graph4Edges.add(edge2);
                }
                else if (graphNum == 5) {
                    graph5Edges.add(edge1);
                    graph5Edges.add(edge2);
                }//else if

                else {
        
                    if (graphNum == 1 && !(graph1Edges.isEmpty())) {
                        //create the graphs 
                        graphMatrix = new GraphMatrix(graph1Verticies.size() + 1);
                        graphLinkedObjects = new GraphLinkedObjects(graph1Verticies.size() + 1);


                        while (!(graph1Edges.isEmpty())) {
                            //add the edges to the graphs
                            System.out.println("adding edges " + graph1Edges.get(0) + " - " + graph1Edges.get(1));
                            graphMatrix.addEdge(graph1Edges.get(0), graph1Edges.get(1));
                            graphLinkedObjects.addEdge(graph1Edges.get(0), graph1Edges.get(1));

                            //remove the two edges that were just added each time until all edges have been added 
                            graph1Edges.remove(0);
                            graph1Edges.remove(0);
                        }//while

                        System.out.println("Graph Matrix:");
                        graphMatrix.printGraphMatrix();
                        //graphLinkedObjects.depthFirstTraversal(v);
                        
                        //depth first and breadth first traversals here
                    }//if
                    else if (graphNum == 2 && !(graph2Edges.isEmpty())) {
                        graphMatrix = new GraphMatrix(graph2Verticies.size() + 1);
                        graphLinkedObjects = new GraphLinkedObjects(graph2Verticies.size() + 1);


                        while(!(graph2Edges.isEmpty())) {
                            graphMatrix.addEdge(graph2Edges.get(0), graph2Edges.get(1));
                            graphLinkedObjects.addEdge(graph2Edges.get(0), graph2Edges.get(1));

                            graph2Edges.remove(0);
                            graph2Edges.remove(0);
                        }//while

                        System.out.println("Graph Matrix:");
                        graphMatrix.printGraphMatrix();

                    }//else if

                    else if (graphNum == 3 && !(graph3Edges.isEmpty())) {
                        graphMatrix = new GraphMatrix(graph3Verticies.size() + 1);
                        graphLinkedObjects = new GraphLinkedObjects(graph3Verticies.size() + 1);


                        while(!(graph3Edges.isEmpty())) {
                            graphMatrix.addEdge(graph3Edges.get(0), graph3Edges.get(1));
                            graphLinkedObjects.addEdge(graph3Edges.get(0), graph3Edges.get(1));

                            graph3Edges.remove(0);
                            graph3Edges.remove(0);
                        }//while

                        System.out.println("Graph Matrix:");
                        graphMatrix.printGraphMatrix();

                    }//else if

                    else if (graphNum == 4 && !(graph4Edges.isEmpty())) {
                        graphMatrix = new GraphMatrix(graph4Verticies.size() + 1);
                        graphLinkedObjects = new GraphLinkedObjects(graph4Verticies.size() + 1);


                        while(!(graph4Edges.isEmpty())) {
                            graphMatrix.addEdge(graph4Edges.get(0), graph4Edges.get(1));
                            graphLinkedObjects.addEdge(graph4Edges.get(0), graph4Edges.get(1));

                            graph4Edges.remove(0);
                            graph4Edges.remove(0);
                        }//while

                        System.out.println("Graph Matrix:");
                        graphMatrix.printGraphMatrix();

                    }//else if

                    else if (graphNum == 5 && !(graph5Edges.isEmpty())) {
                        graphMatrix = new GraphMatrix(graph5Verticies.size() + 1);
                        graphLinkedObjects = new GraphLinkedObjects(graph5Verticies.size() + 1);


                        while(!(graph5Edges.isEmpty())) {
                            graphMatrix.addEdge(graph5Edges.get(0), graph5Edges.get(1));
                            graphLinkedObjects.addEdge(graph5Edges.get(0), graph5Edges.get(1));

                            graph5Edges.remove(0);
                            graph5Edges.remove(0);
                        }//while

                        System.out.println("Graph Matrix:");
                        graphMatrix.printGraphMatrix();

                    }//else if


                }
                    
                    
                   
     
  
                
            }   
        }//for
        


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

