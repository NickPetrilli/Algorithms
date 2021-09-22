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
    public void push (String s) {
        Node oldTop = newTop;
        newTop = new Node();
        newTop.name = s;
        newTop.next = oldTop;
    }
    //Pop function to delete an element in the stack
    public String pop() {
         

    }



    
}