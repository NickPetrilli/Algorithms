import java.util.List;

public class Knapsack {

    private List<KnapsackItem> knapsackItems;
    private int knapsackCapacity;

    public Knapsack(List<KnapsackItem> items, int capacity) {
        knapsackItems = items;
        knapsackCapacity = capacity;
    }

    public void addItem(String name, double price, int quantity) {
        KnapsackItem item = new KnapsackItem(name, price, quantity);
        knapsackItems.add(item);
    }
    
    
}
