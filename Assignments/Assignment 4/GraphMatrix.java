public class GraphMatrix {
    int graphMatrix[][];
    int numVerticies;

    //Construct matrix graph with number of verticies
    public GraphMatrix(int numVerticies) {
        this.numVerticies = numVerticies;
        graphMatrix = new int[numVerticies][numVerticies];
    }

    public void addEdge(int vertex1, int vertex2) {
        //Add edge for both directions for undirected graph
        graphMatrix[vertex1][vertex2] = 1;

        graphMatrix[vertex2][vertex1] = 1;
    }
    public void printGraphMatrix() {
        for (int i = 0; i < numVerticies; i++) {
            System.out.print(i + "| ");
            for (int j = 0; j < numVerticies; j++) {
                System.out.print(graphMatrix[i][j] + " ");
            }
            System.out.println();
        }
    }
    
}
