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
    public void enqueue(char c) {
        Node oldTail = tail;
        tail = new Node();
        tail.item = c;
        tail.next = null;
        if (isEmpty()) {
            head = tail;
        }
        else {
            oldTail.next = tail;
        }
    }

    public char dequeue() {
        char returnVal = 0;
        if (!isEmpty()) {
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
