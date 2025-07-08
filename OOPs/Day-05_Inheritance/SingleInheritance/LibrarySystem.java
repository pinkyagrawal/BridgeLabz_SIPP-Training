class Book {
    protected String title;
    protected int publicationYear;

    public Book(String title, int publicationYear) {
        this.title = title;
        this.publicationYear = publicationYear;
    }

    public void displayInfo() {
        System.out.println("Title: " + title);
        System.out.println("Publication Year: " + publicationYear);
    }
}

class Author extends Book {
    private String name;
    private String bio;

    public Author(String title, int publicationYear, String name, String bio) {
        super(title, publicationYear);
        this.name = name;
        this.bio = bio;
    }

    @Override
    public void displayInfo() {
        super.displayInfo();
        System.out.println("Author Name: " + name);
        System.out.println("Author Bio: " + bio);
    }
}

public class LibrarySystem {
    public static void main(String[] args) {
        Author book1 = new Author("The Alchemist", 1988, "Paulo Coelho",
                "Brazilian author known for spiritual fiction.");
        Author book2 = new Author("1984", 1949, "George Orwell", "British novelist, essayist, and critic.");

        book1.displayInfo();
        System.out.println();
        book2.displayInfo();
    }
}