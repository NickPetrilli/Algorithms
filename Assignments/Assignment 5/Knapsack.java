import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

public class Knapsack {

    private List<KnapsackItem> knapsackItems;
    private int knapsackCapacity;

    private final int totalSpices = 20;

    private int spiceAdded = 0;

    public Knapsack(List<KnapsackItem> items, int capacity) {
        knapsackItems = items;
        knapsackCapacity = capacity;
    }

    public void addItem(String name, double price, int quantity, double unitPrice) {
        KnapsackItem item = new KnapsackItem(name, price, quantity, unitPrice);
        knapsackItems.add(item);
    }
    
    public Knapsack solveHeist(int capacity) {
        ArrayList<KnapsackItem> solution = new ArrayList<>();
        Knapsack knapsackSolution = new Knapsack(solution, 0);

        knapsackCapacity = capacity;
        boolean remainingSpace = true;
        spiceAdded = 0;

        int counter = 0;
        while (remainingSpace) {
            if (knapsackCapacity == 0) {
                remainingSpace = false; //base case, capacity is decremented each time an item gets added to knapsackSolution
            }//if
            else if (spiceAdded == totalSpices) {
                remainingSpace = false;
            }//else if
            else {
                int tempQuantity = knapsackItems.get(counter).getQuantity();
                while (tempQuantity > 0 && knapsackCapacity > 0) {
                    //System.out.println(knapsackCapacity);
                    if(existsInSolution(knapsackItems.get(counter).getSpiceName(), solution)) {
                        int tempQuantity2 = solution.get(counter).getQuantity();
                        tempQuantity2++;
                        solution.get(counter).setQuantity(tempQuantity2);
                        System.out.println("Adding another scoop of " + knapsackItems.get(counter).getSpiceName());
                        spiceAdded++;
                    }//if
                    else {
                        String spiceName = knapsackItems.get(counter).getSpiceName();
                        double price = knapsackItems.get(counter).getTotalPrice();
                        double unitPrice = knapsackItems.get(counter).getUnitPrice();
                        System.out.println("Adding to the solution Knapsack the first scoop of " + spiceName);
                        spiceAdded++;
                        knapsackSolution.addItem(spiceName, price, 1, unitPrice); //quantity is hard-coded as a 1 because only one scoop is added at a time
                    }//else
                    //item gets added to the knapsack so the quantity of the spice is decremented as well as the capacity of the knapsack
                    tempQuantity--;
                    knapsackCapacity--;

                }//while
                counter++;
            }//else

        }//while

        return knapsackSolution;
        

    }

    //tests if a scoop of spice was already added in order to update the quantity
    public boolean existsInSolution(String name, ArrayList<KnapsackItem> solution) {
        for (int i = 0; i < solution.size(); i++) {
            if (solution.get(i).getSpiceName().compareToIgnoreCase(name) == 0) {
                return true;
            }
        }
        return false;
    }


    /* https://www.techiedelight.com/sort-list-of-objects-using-comparator-java/
    Referenced this website on how to sort arraylists using comparators
    */
    public void sortKnapsack() {
        //need to sort by unit price in order to take the higher value spices before the lower value ones
        Collections.sort(knapsackItems, Comparator.comparing(KnapsackItem::getUnitPrice));
        //by default the arraylist gets sorted in increasing unit price order, so need to reverse list
        Collections.reverse(knapsackItems);
    }
    
    public double totalWorth() {
        double totalWorth = 0.0;
        for (int i = 0; i < knapsackItems.size(); i++) {
            totalWorth += knapsackItems.get(i).getUnitPrice() * knapsackItems.get(i).getQuantity();
        }
        return totalWorth;
    }


}
