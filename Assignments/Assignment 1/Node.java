//Node class for singly linked list

public class Node {
    char item;
    Node next;

    // Empty constructor to create a new Node without specifying the attributes
    public Node() {
        item = 0;
        next = null;
    }
    //Constructor to create a node with char item and a pointer to the next node
    public Node(char item, Node next) {
        this.item = item;
        this.next = next;
    }
    //Setter function to set the  of node
    public void setItem(char item) {
        this.item = item;
    }
    //Setter function to set the pointer of next node
    public void setNext(Node next) {
        this.next = next;
    }
    //Getter function to return the name of the node
    public char getItem() {
        return this.item;
    }
    //Getter function to return the next node
    public Node getNext() {
        return this.next;
    }



}