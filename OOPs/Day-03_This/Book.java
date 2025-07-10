public class Book {

    static String libraryName = "Central City Library";
    private final String isbn;
    private String title;
    private String author;

    public Book(String title, String author, String isbn) {
        this.title = title;
        this.author = author;
        this.isbn = isbn;
    }

    public static void displayLibraryName() {
        System.out.println("Library Name: " + libraryName);
    }

    public void displayBookDetails() {
        if (this instanceof Book) {
            System.out.println("Title: " + title);
            System.out.println("Author: " + author);
            System.out.println("ISBN: " + isbn);
        } else {
            System.out.println("Invalid book object.");
        }
    }

    public static void main(String[] args) {
        Book b1 = new Book("The Alchemist", "Paulo Coelho", "ISBN12345");
        Book b2 = new Book("1984", "George Orwell", "ISBN67890");

        b1.displayBookDetails();
        System.out.println();
        b2.displayBookDetails();
        System.out.println();

        Book.displayLibraryName();
    }
}