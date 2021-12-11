public class KnapsackItem {
    
    private String spiceName;
    private double totalPrice;
    private int quantity;
    private double unitPrice;

    public KnapsackItem(String name, double price, int quantity, double unitPrice) {
        spiceName = name;
        totalPrice = price;
        this.quantity = quantity;
        this.unitPrice = unitPrice;

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
    public double getUnitPrice() {
        return unitPrice;
    }
    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }


}
