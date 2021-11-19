//Used for breadth first traversal, need a queue of verticies
public class QueueNode {
    Vertex item;
    QueueNode next;

    
    public QueueNode() {
        item = new Vertex();
        next = null;
    }
    //Constructor to create a node with vertex item and a pointer to the next node
    public QueueNode(Vertex item, QueueNode next) {
        this.item = item;
        this.next = next;
    }
    //Setter function to set the vertex of node
    public void setItem(Vertex item) {
        this.item = item;
    }
    //Setter function to set the pointer of next node
    public void setNext(QueueNode next) {
        this.next = next;
    }
    //Getter function to return the name of the node
    public Vertex getItem() {
        return this.item;
    }
    //Getter function to return the next node
    public QueueNode getNext() {
        return this.next;
    }



}