import java.util.ArrayList;
import java.util.List;

class Book {
    private String title;
    private String author;

    public Book(String title, String author) {
        this.title = title;
        this.author = author;
    }

    public void displayBook() {
        System.out.println("Title: " + title + ", Author: " + author);
    }
}

class Library {
    private String name;
    private List<Book> books;

    public Library(String name) {
        this.name = name;
        this.books = new ArrayList<>();
    }

    public void addBook(Book book) {
        books.add(book);
    }

    public void displayLibraryBooks() {
        System.out.println("Books in " + name + ":");
        for (Book book : books) {
            book.displayBook();
        }
        System.out.println();
    }
}

public class AggregationExample {
    public static void main(String[] args) {
        Book b1 = new Book("1984", "George Orwell");
        Book b2 = new Book("The Alchemist", "Paulo Coelho");
        Book b3 = new Book("To Kill a Mockingbird", "Harper Lee");

        Library lib1 = new Library("City Library");
        Library lib2 = new Library("University Library");

        lib1.addBook(b1);
        lib1.addBook(b2);

        lib2.addBook(b2); 
        lib2.addBook(b3);

        lib1.displayLibraryBooks();
        lib2.displayLibraryBooks();
    }
}