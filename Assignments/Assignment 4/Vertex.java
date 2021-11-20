import java.util.*;

public class Vertex {
    int id;
    boolean processed;
    ArrayList<Vertex> neighbors;

    public Vertex(int id) {
        this.id = id;
        processed = false;
        neighbors = new ArrayList<>();
    }
    public Vertex() {
        id = 0;
        processed = false;
        neighbors = new ArrayList<>();
    }
    
}
