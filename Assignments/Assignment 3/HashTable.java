
public class HashTable {

    final static int HASH_TABLE_SIZE = 250;
    NodeObj[] nodes = new NodeObj[HASH_TABLE_SIZE];

    //Creates a hash table and initializes all items in the hash table to null
    public HashTable() {
        for (int i = 0; i < HASH_TABLE_SIZE; i++) {
            nodes[i] = new NodeObj();
        }
    }
    public void put(String input, int key) {
        //need to check if there are already nodes there
        if (nodes[key].next == null){
            nodes[key].item = input;
        }
        else {
            nodes[key].next = new NodeObj();
            nodes[key].next.item = input;
        }
    
    }
    public void printHash() {
        for (int i = 0; i < HASH_TABLE_SIZE; i++) {
            System.out.println(nodes[i].item);
            System.out.println();
        }
    }

    public int get(String input) {
        int index = makeHashCode(input);
        int counter = 0;
        NodeObj n = nodes[index];
        while (n != null && n.getItem() != input) {
            n = n.getNext();
            counter++;
        }    
        if (n == null) {
            counter++;
            return counter;
        }   
        
        return counter;

    }
    public  int makeHashCode(String str) {
        str = str.toUpperCase();
        int length = str.length();
        int letterTotal = 0;
        // Iterate over all letters in the string, totalling their ASCII values.
        for (int i = 0; i < length; i++) {
            char thisLetter = str.charAt(i);
            int thisValue = (int)thisLetter;
            letterTotal = letterTotal + thisValue;

            // Test: print the char and the hash.
            /* 
            System.out.print(" ["); 
            System.out.print(thisLetter); 
            System.out.print(thisValue); 
            System.out.print("] "); 
            // */
        }
        
        // Scale letterTotal to fit in HASH_TABLE_SIZE.
        int hashCode = (letterTotal * 1) % HASH_TABLE_SIZE;  // % is the "mod" operator
        
           
        return hashCode;
        }

}