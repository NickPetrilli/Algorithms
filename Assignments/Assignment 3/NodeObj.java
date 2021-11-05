public class NodeObj {
    String item;
    NodeObj next;

    //Empty constructor 
    public NodeObj() {
        item = "";
        next = null;
    }
    //Constructor to create a NodeObj with string item and a pointer to the next node
    public NodeObj(String item, NodeObj next) {
        this.item = item;
        this.next = next;
    }
    //Setter function to set the item of node
    public void setItem(String item) {
        this.item = item;
    }
    //Setter function to set the pointer of next node
    public void setNext(NodeObj next) {
        this.next = next;
    }
    //Getter function to return the name of the node
    public String getItem() {
        return this.item;
    }
    //Getter function to return the next node
    public NodeObj getNext() {
        return this.next;
    }
}
