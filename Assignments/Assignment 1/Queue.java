//Queue class with head and tail attributes as nodes
public class Queue {
    Node head;
    Node tail;

    public Queue() {
        head = null;
        tail = null;
    }
    //Returns true when queue is empty, false otherwise
    public Boolean isEmpty() {
        if (head == null)
            return true;
        return false;
    }
    //Adds another character to the back of the queue
    public void enqueue(char c) {
        Node oldTail = tail;
        tail = new Node();
        //Creates a new node for the new tail, populates it with the recieved char and next is null because it is the last node
        tail.item = c;
        tail.next = null;
        if (isEmpty()) {
            head = tail;
        }
        else {
            oldTail.next = tail;
        }
    }
    //Removes the char element from the front of the queue
    public char dequeue() {
        char returnVal = 0;
        if (!isEmpty()) {
            //If the queue isn't empty, remove the head and change it to the next element
            returnVal = head.item;
            head = head.next;
            if (isEmpty()) {
                tail = null;
            }
        }
        else {
            System.out.println("Underflow");
        }
        return returnVal;
    }
    
}
