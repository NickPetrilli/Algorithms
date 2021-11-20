import java.util.*;

public class GraphAdjacencyList {
    ArrayList<ArrayList<Integer>> graphAdjacencyList;

    public GraphAdjacencyList(int numVerticies) {
        graphAdjacencyList = new ArrayList<>(numVerticies);

    }
    public void addEdge(int vertex1, int vertex2) {
        graphAdjacencyList.get(vertex1).add(vertex1);
        graphAdjacencyList.get(vertex2).add(vertex2);
    }
    public void printGraph() {
        for (List newList: graphAdjacencyList) {
            for (Object m: newList) {
                System.out.println(newList.get((int) m));

            }
        }
    }
    
}
