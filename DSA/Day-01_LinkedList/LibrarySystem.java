class Book {
    String title;
    String author;
    String genre;
    int bookId;
    boolean isAvailable;
    Book next;
    Book prev;

    public Book(String title, String author, String genre, int bookId, boolean isAvailable) {
        this.title = title;
        this.author = author;
        this.genre = genre;
        this.bookId = bookId;
        this.isAvailable = isAvailable;
    }
}

public class LibrarySystem {
    Book head = null, tail = null;

    // Add at beginning
    public void addAtBeginning(String title, String author, String genre, int id, boolean available) {
        Book newBook = new Book(title, author, genre, id, available);
        if (head == null) {
            head = tail = newBook;
        } else {
            newBook.next = head;
            head.prev = newBook;
            head = newBook;
        }
    }

    // Add at end
    public void addAtEnd(String title, String author, String genre, int id, boolean available) {
        Book newBook = new Book(title, author, genre, id, available);
        if (tail == null) {
            head = tail = newBook;
        } else {
            tail.next = newBook;
            newBook.prev = tail;
            tail = newBook;
        }
    }

    // Add at position
    public void addAtPosition(int position, String title, String author, String genre, int id, boolean available) {
        if (position <= 1) {
            addAtBeginning(title, author, genre, id, available);
            return;
        }
        Book newBook = new Book(title, author, genre, id, available);
        Book temp = head;
        for (int i = 1; temp != null && i < position - 1; i++) temp = temp.next;
        if (temp == null || temp.next == null) {
            addAtEnd(title, author, genre, id, available);
            return;
        }
        newBook.next = temp.next;
        newBook.prev = temp;
        temp.next.prev = newBook;
        temp.next = newBook;
    }

    // Remove by book ID
    public void removeById(int id) {
        Book temp = head;
        while (temp != null) {
            if (temp.bookId == id) {
                if (temp == head) head = head.next;
                if (temp == tail) tail = tail.prev;
                if (temp.prev != null) temp.prev.next = temp.next;
                if (temp.next != null) temp.next.prev = temp.prev;
                return;
            }
            temp = temp.next;
        }
    }

    // Search by title or author
    public void search(String keyword) {
        Book temp = head;
        while (temp != null) {
            if (temp.title.equalsIgnoreCase(keyword) || temp.author.equalsIgnoreCase(keyword)) {
                System.out.println("Found: " + temp.title + " by " + temp.author + ", Genre: " + temp.genre + ", Available: " + temp.isAvailable);
                return;
            }
            temp = temp.next;
        }
        System.out.println("Book not found.");
    }

    // Update availability
    public void updateAvailability(int id, boolean available) {
        Book temp = head;
        while (temp != null) {
            if (temp.bookId == id) {
                temp.isAvailable = available;
                return;
            }
            temp = temp.next;
        }
    }

    // Display forward
    public void displayForward() {
        Book temp = head;
        while (temp != null) {
            System.out.println("Book: " + temp.title + " | Author: " + temp.author + " | Available: " + temp.isAvailable);
            temp = temp.next;
        }
    }

    // Display reverse
    public void displayReverse() {
        Book temp = tail;
        while (temp != null) {
            System.out.println("Book: " + temp.title + " | Author: " + temp.author + " | Available: " + temp.isAvailable);
            temp = temp.prev;
        }
    }

    // Count books
    public void countBooks() {
        int count = 0;
        Book temp = head;
        while (temp != null) {
            count++;
            temp = temp.next;
        }
        System.out.println("Total Books: " + count);
    }

    public static void main(String[] args) {
        LibrarySystem lib = new LibrarySystem();
        lib.addAtEnd("1984", "George Orwell", "Dystopian", 1, true);
        lib.addAtBeginning("The Hobbit", "Tolkien", "Fantasy", 2, true);
        lib.addAtPosition(2, "Pride and Prejudice", "Austen", "Classic", 3, false);

        lib.displayForward();
        lib.displayReverse();
        lib.countBooks();
        lib.search("Tolkien");
        lib.updateAvailability(3, true);
    }
}
