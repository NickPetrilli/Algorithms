import java.util.*;

public class GraphLinkedObjects {
    
    ArrayList<Vertex> graphLinkedObjects;
    

    public GraphLinkedObjects(int numVerticies) {
        graphLinkedObjects = new ArrayList<>(numVerticies);
        
    }
    //Add edge in both directions for undirected graph
    public void addEdge(int vertex1, int vertex2) {
        graphLinkedObjects.get(vertex1).neighbors.add(new Vertex(vertex2));
        graphLinkedObjects.get(vertex2).neighbors.add(new Vertex(vertex1));
    }
    public void depthFirstTraversal(Vertex v) {
        if (!(v.processed)) {
            System.out.print(v.id + " ");
            v.processed = true;
        }
        for (Vertex n: v.neighbors) {
            if (!(n.processed)) {
                depthFirstTraversal(n);
            }
        }
    }
    public void breadthFirstTraversal(Vertex v) {
        Queue2 queue = new Queue2();
        queue.enqueue(v);
        v.processed = true;
        Vertex currentVertex = new Vertex();
        while (!(queue.isEmpty())) {
            currentVertex = queue.dequeue();
            System.out.print(currentVertex.id + " ");

            for (Vertex n: currentVertex.neighbors) {
                if (!(n.processed)) {
                    queue.enqueue(n);
                    n.processed = true;
                }//end if
            }//end for
            
        }//end while
        
    }
    public void reset() {
        for (int i = 0; i < graphLinkedObjects.size(); i++) {
            graphLinkedObjects.get(i).processed = false;
        }
    }
    /*
    public void printGraph() {
        for (Vertex v: graphLinkedObjects) {
            System.out.print("Vertex " + v.id);
            for (int x = 0; x < v.neighbors.size(); x++) {
                System.out.println(" has neighbors " + v.neighbors.get(x));
            }
        }
    }
    */
}
