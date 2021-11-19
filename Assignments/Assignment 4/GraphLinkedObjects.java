import java.util.*;

public class GraphLinkedObjects {
    
    List<List<Integer>> linkedObjectsGraph;
    boolean[] processed;

    public GraphLinkedObjects(int numVerticies) {
        linkedObjectsGraph = new ArrayList<>();
        processed = new boolean[numVerticies];
    }
    //Add edge in both directions for undirected graph
    public void addEdge(int vertex1, int vertex2) {
        linkedObjectsGraph.get(vertex1).add(vertex2);
        linkedObjectsGraph.get(vertex2).add(vertex1);
    }
    public void depthFirstTraversal(Vertex v) {
        if (!(v.processed)) {
            System.out.println(v.id);
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
            System.out.println(currentVertex.id);

            for (Vertex n: currentVertex.neighbors) {
                if (!(n.processed)) {
                    queue.enqueue(n);
                    n.processed = true;
                }//end if
            }//end for
            
        }//end while

    }
}
