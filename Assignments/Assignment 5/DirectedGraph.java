public class DirectedGraph {

    int verticies;
    int edges;

    Edge[] edgeArray;

    public DirectedGraph(int verticies, int edges) {
        this.verticies = verticies;
        this.edges = edges;
        edgeArray = new Edge[edges];

        //create edges at each index
        for (int i = 0; i < edges; i++) {
            edgeArray[i] = new Edge();
        }
    }

    public void bellmanFord(DirectedGraph graph, int source) {
        int verticies = graph.verticies;
        int edges = graph.edges;
        int[] distance = new int[verticies];

        //initialze single source
        for (int i = 0; i < verticies; i++) {
            distance[i] = Integer.MAX_VALUE; //estimate of shortest path distance
        }
        distance[source] = 0;

        for (int i = 1; i < verticies - 1; i++) {
            for (int j = 0; j < edges; j++) {
                //get the source, destination and weight for each edge in graph for the "relax" function
                int src = graph.edgeArray[j].source;
                int dest = graph.edgeArray[j].destination;
                int weight = graph.edgeArray[j].weight;
                
                if(distance[src] != Integer.MAX_VALUE && distance[dest] > distance[src] + weight) {
                    distance[dest] = distance[src] + weight;
                }//if
            }//for
        }//for

        //after the nested for loops, check edges again
        for (int j = 0; j < edges; j++) {
            int src = graph.edgeArray[j].source;
            int dest = graph.edgeArray[j].destination;
            int weight = graph.edgeArray[j].weight;

            if (distance[src] != Integer.MAX_VALUE && distance[dest] > distance[src] + weight) {
                System.out.println("There is a negative weight cycle in the graph.");
                return;
            }
        }
        for (int i = 0; i < verticies; i++) {
            System.out.println(i + "\t" + distance[i] + "\t | 0 ---> " + i + " Cost is " + distance[i]);
        }
    }

    

}
