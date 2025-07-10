class Movie {
    String title;
    String director;
    int year;
    double rating;
    Movie next;
    Movie prev;

    public Movie(String title, String director, int year, double rating) {
        this.title = title;
        this.director = director;
        this.year = year;
        this.rating = rating;
        this.next = null;
        this.prev = null;
    }
}

public class MovieDoublyLinkedList {
    Movie head = null;
    Movie tail = null;

    // 1. Add at beginning
    public void addAtBeginning(String title, String director, int year, double rating) {
        Movie newMovie = new Movie(title, director, year, rating);
        if (head == null) {
            head = tail = newMovie;
        } else {
            newMovie.next = head;
            head.prev = newMovie;
            head = newMovie;
        }
    }

    // 2. Add at end
    public void addAtEnd(String title, String director, int year, double rating) {
        Movie newMovie = new Movie(title, director, year, rating);
        if (tail == null) {
            head = tail = newMovie;
        } else {
            tail.next = newMovie;
            newMovie.prev = tail;
            tail = newMovie;
        }
    }

    // 3. Add at specific position (1-based index)
    public void addAtPosition(int position, String title, String director, int year, double rating) {
        if (position <= 1) {
            addAtBeginning(title, director, year, rating);
            return;
        }

        Movie newMovie = new Movie(title, director, year, rating);
        Movie current = head;
        for (int i = 1; current != null && i < position - 1; i++) {
            current = current.next;
        }

        if (current == null || current.next == null) {
            addAtEnd(title, director, year, rating);
            return;
        }

        newMovie.next = current.next;
        newMovie.prev = current;
        current.next.prev = newMovie;
        current.next = newMovie;
    }

    // 4. Remove by movie title
    public void removeByTitle(String title) {
        Movie current = head;

        while (current != null) {
            if (current.title.equalsIgnoreCase(title)) {
                if (current == head && current == tail) {
                    head = tail = null;
                } else if (current == head) {
                    head = head.next;
                    head.prev = null;
                } else if (current == tail) {
                    tail = tail.prev;
                    tail.next = null;
                } else {
                    current.prev.next = current.next;
                    current.next.prev = current.prev;
                }
                System.out.println("Movie \"" + title + "\" removed.");
                return;
            }
            current = current.next;
        }
        System.out.println("Movie \"" + title + "\" not found.");
    }

    // 5. Search by director
    public void searchByDirector(String director) {
        Movie current = head;
        boolean found = false;
        while (current != null) {
            if (current.director.equalsIgnoreCase(director)) {
                System.out.println("Found: " + current.title + ", " + current.year + ", Rating: " + current.rating);
                found = true;
            }
            current = current.next;
        }
        if (!found) {
            System.out.println("No movies found by director: " + director);
        }
    }

    // 6. Search by rating
    public void searchByRating(double rating) {
        Movie current = head;
        boolean found = false;
        while (current != null) {
            if (current.rating == rating) {
                System.out.println("Found: " + current.title + ", Directed by: " + current.director + ", Year: " + current.year);
                found = true;
            }
            current = current.next;
        }
        if (!found) {
            System.out.println("No movies found with rating: " + rating);
        }
    }

    // 7. Display all movies forward
    public void displayForward() {
        if (head == null) {
            System.out.println("No movies to display.");
            return;
        }
        System.out.println("Movies (Forward):");
        Movie current = head;
        while (current != null) {
            System.out.println(current.title + " | " + current.director + " | " + current.year + " | Rating: " + current.rating);
            current = current.next;
        }
    }

    // 8. Display all movies in reverse
    public void displayReverse() {
        if (tail == null) {
            System.out.println("No movies to display.");
            return;
        }
        System.out.println("Movies (Reverse):");
        Movie current = tail;
        while (current != null) {
            System.out.println(current.title + " | " + current.director + " | " + current.year + " | Rating: " + current.rating);
            current = current.prev;
        }
    }

    // 9. Update movie rating by title
    public void updateRating(String title, double newRating) {
        Movie current = head;
        while (current != null) {
            if (current.title.equalsIgnoreCase(title)) {
                current.rating = newRating;
                System.out.println("Updated rating for \"" + title + "\" to " + newRating);
                return;
            }
            current = current.next;
        }
        System.out.println("Movie \"" + title + "\" not found.");
    }

    // Main method to test
    public static void main(String[] args) {
        MovieDoublyLinkedList list = new MovieDoublyLinkedList();

        list.addAtEnd("Inception", "Christopher Nolan", 2010, 8.8);
        list.addAtBeginning("Interstellar", "Christopher Nolan", 2014, 8.6);
        list.addAtPosition(2, "The Matrix", "The Wachowskis", 1999, 8.7);
        list.addAtEnd("Parasite", "Bong Joon-ho", 2019, 8.6);

        list.displayForward();
        System.out.println();

        list.displayReverse();
        System.out.println();

        list.searchByDirector("Christopher Nolan");
        System.out.println();

        list.searchByRating(8.6);
        System.out.println();

        list.updateRating("The Matrix", 9.0);
        list.displayForward();
        System.out.println();

        list.removeByTitle("Parasite");
        list.displayForward();
    }
}
