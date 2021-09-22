//Node class for singly linked list

public class Node {
    String name;
    Node next;

    // Empty constructor to create a new Node without specifying the attributes
    public Node() {
        name = null;
        next = null;
    }
    //Constructor to create a node with a string name and a pointer to the next node
    public Node(String name, Node next) {
        this.name = name;
        this.next = next;
    }
    //Setter function to set name of node
    public void setName(String name) {
        this.name = name;
    }
    //Setter function to set the pointer of next node
    public void setNext(Node next) {
        this.next = next;
    }
    //Getter function to return the name of the node
    public String getName() {
        return this.name;
    }
    //Getter function to return the next node
    public Node getNext() {
        return this.next;
    }

}