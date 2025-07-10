
public class Book {
    private String title;
    private String author;
    private int price;
    Book(){
        title = "XYZ";
        author = "unknown";
        price = 0;

    }
    Book(String title, String author, int price) {
        this.title = title;
        this.author=author;
        this.price=price;
    }

    public void displayBookDetails(){
        System.out.println("Title: "+title);
        System.out.println("Author: "+author);
        System.out.println("Price: "+price);
    }
    public static void main(String[] args) {
        Book book1 = new Book();
        book1.displayBookDetails();
        System.out.println();
        Book book2 = new Book("Harry Potter", "J.K. Rowling", 20);
        book2.displayBookDetails();   
    }   
}