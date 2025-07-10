import java.util.ArrayList;

public class CartItem {
    String itemName;
    double price;
    int quantity;

    public CartItem(String itemName, double price, int quantity) {
        this.itemName = itemName;
        this.price = price;
        this.quantity = quantity;
    }

    public double getTotalCost() {
        return price * quantity;
    }

    public static void main(String[] args) {
        ArrayList<CartItem> cart = new ArrayList<>();

        cart.add(new CartItem("Laptop", 50000.0, 1));
        cart.add(new CartItem("Mouse", 700.0, 2));
        cart.add(new CartItem("Notebook", 40.0, 5));

        System.out.println("Items in Cart:");
        double total = 0;
        for (CartItem item : cart) {
            System.out.println(item.itemName + " | Price: ₹" + item.price + " | Quantity: " + item.quantity);
            total += item.getTotalCost();
        }

        cart.removeIf(item -> item.itemName.equalsIgnoreCase("Mouse"));

        System.out.println("\nCart After Removing 'Mouse':");
        total = 0;
        for (CartItem item : cart) {
            System.out.println(item.itemName + " | Price: ₹" + item.price + " | Quantity: " + item.quantity);
            total += item.getTotalCost();
        }

        System.out.println("\nTotal Cost: ₹" + total);
    }
}