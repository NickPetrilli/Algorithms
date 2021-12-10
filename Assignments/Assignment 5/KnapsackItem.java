public class KnapsackItem {
    
    private String spiceName;
    private double totalPrice;
    private int quantity;

    public KnapsackItem(String name, double price, int quantity) {
        spiceName = name;
        totalPrice = price;
        this.quantity = quantity;

    }
    //Create getters for each member to be accessed from outside of class

    public String getSpiceName() {
        return spiceName;
    }
    public double getTotalPrice() {
        return totalPrice;
    }
    public int getQuantity() {
        return quantity;
    }


}
