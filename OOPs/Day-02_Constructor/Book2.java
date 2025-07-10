public class Book2 {
    String title;
    String author;
    double price;
    boolean isAvailable;

    public Book2(String title, String author, double price, boolean isAvailable) {
        this.title = title;
        this.author = author;
        this.price = price;
        this.isAvailable = isAvailable;
    }

    public void borrowBook() {
        if (isAvailable) {
            isAvailable = false;
            System.out.println("You have successfully borrowed: " + title);
        } else {
            System.out.println("Sorry, '" + title + "' is currently not available.");
        }
    }

    public void displayDetails() {
        System.out.println("Title: " + title);
        System.out.println("Author: " + author);
        System.out.println("Price: ₹" + price);
        System.out.println("Available: " + (isAvailable ? "Yes" : "No"));
    }

    public static void main(String[] args) {
        Book2 book1 = new Book2("The Hobbit", "J.R.R. Tolkien", 450.0, true);

        book1.displayDetails();
        System.out.println();

        book1.borrowBook();
        book1.displayDetails();
        System.out.println();

        book1.borrowBook(); 
    }
}