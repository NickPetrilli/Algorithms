public class Queue2 {
    QueueNode head;
    QueueNode tail;

    public Queue2() {
        head = null;
        tail = null;
    }
    //Returns true when queue is empty, false otherwise
    public Boolean isEmpty() {
        if (head == null)
            return true;
        return false;
    }
    //Adds vertex to the back of the queue
    public void enqueue(Vertex v) {
        QueueNode oldTail = tail;
        tail = new QueueNode();
        //Creates a new node for the new tail, populates it with the recieved vertex and next is null because it is the last node
        tail.item = v;
        tail.next = null;
        if (isEmpty()) {
            head = tail;
        }
        else {
            oldTail.next = tail;
        }
    }
    //Removes the vertex element from the front of the queue
    public Vertex dequeue() {
        Vertex returnVal = new Vertex();
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
