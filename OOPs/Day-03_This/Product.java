public class Product {

    static double discount = 10.0;

    private final String productID;
    private String productName;
    private double price;
    private int quantity;

    public Product(String productID, String productName, double price, int quantity) {
        this.productID = productID;
        this.productName = productName;
        this.price = price;
        this.quantity = quantity;
    }

    public static void updateDiscount(double newDiscount) {
        discount = newDiscount;
    }

    public void displayProductDetails() {
        if (this instanceof Product) {
            System.out.println("Product ID: " + productID);
            System.out.println("Product Name: " + productName);
            System.out.println("Price: " + price);
            System.out.println("Quantity: " + quantity);
            System.out.println("Current Discount: " + discount + "%");
        } else {
            System.out.println("Invalid product object.");
        }
    }

    public static void main(String[] args) {
        Product p1 = new Product("P001", "Laptop", 50000.0, 2);
        Product p2 = new Product("P002", "Mouse", 800.0, 5);

        p1.displayProductDetails();
        System.out.println();
        p2.displayProductDetails();
        System.out.println();

        Product.updateDiscount(15.0);
        System.out.println("Discount updated.\n");

        p1.displayProductDetails();
        System.out.println();
        p2.displayProductDetails();
    }
}