//Stack class

public class Stack {
    Node top;

    //Empty constructor to create a stack 
    public Stack() {
        top = null;
    }
    //Constructor specifying the top of the stack
    public Stack(Node top) {
        this.top = top;
    }
    //Returns true if stack is empty, returns false otherwise
    public Boolean isEmpty() {
        if (top == null)
            return true;
        return false;
    }
    //Push function to insert an element into the stack
    public void push (char c) {
        Node oldTop = top;
        top = new Node();
        //Create new node for new top, populates with recieved char and points to the next node
        top.item = c;
        top.next = oldTop;
    }
    //Pop function to remove an element from the top of the stack
    public char pop() {
        char returnVal = '0';
        if (!isEmpty()) {
            //Removes top element, and makes new top the next element in the stack
           returnVal = top.item;
           top = top.next; 
        }
        else {
            System.out.println("Stack Underflow");
        }
        return returnVal;
    }



    
}