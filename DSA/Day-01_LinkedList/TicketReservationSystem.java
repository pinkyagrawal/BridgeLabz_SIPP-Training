class Ticket {
    int ticketId;
    String customerName;
    String movieName;
    String seatNumber;
    String bookingTime;
    Ticket next;

    public Ticket(int ticketId, String customerName, String movieName, String seatNumber, String bookingTime) {
        this.ticketId = ticketId;
        this.customerName = customerName;
        this.movieName = movieName;
        this.seatNumber = seatNumber;
        this.bookingTime = bookingTime;
        this.next = null;
    }
}

public class TicketReservationSystem {
    Ticket head = null;
    Ticket tail = null;

    // Add ticket at the end
    public void addTicket(int ticketId, String customer, String movie, String seat, String time) {
        Ticket newTicket = new Ticket(ticketId, customer, movie, seat, time);
        if (head == null) {
            head = tail = newTicket;
            tail.next = head;  // Circular link
        } else {
            tail.next = newTicket;
            newTicket.next = head;
            tail = newTicket;
        }
        System.out.println("Ticket booked successfully: " + ticketId);
    }

    // Remove ticket by ID
    public void removeTicket(int ticketId) {
        if (head == null) {
            System.out.println("No tickets to remove.");
            return;
        }

        Ticket current = head;
        Ticket previous = tail;
        boolean found = false;

        do {
            if (current.ticketId == ticketId) {
                found = true;

                if (current == head && current == tail) { // Only one node
                    head = tail = null;
                } else if (current == head) {
                    head = head.next;
                    tail.next = head;
                } else if (current == tail) {
                    previous.next = head;
                    tail = previous;
                } else {
                    previous.next = current.next;
                }

                System.out.println("Ticket removed: " + ticketId);
                break;
            }
            previous = current;
            current = current.next;
        } while (current != head);

        if (!found) {
            System.out.println("Ticket ID " + ticketId + " not found.");
        }
    }

    // Display all tickets
    public void displayTickets() {
        if (head == null) {
            System.out.println("No tickets booked.");
            return;
        }

        Ticket current = head;
        System.out.println("Current Booked Tickets:");
        do {
            System.out.println("Ticket ID: " + current.ticketId +
                               ", Customer: " + current.customerName +
                               ", Movie: " + current.movieName +
                               ", Seat: " + current.seatNumber +
                               ", Time: " + current.bookingTime);
            current = current.next;
        } while (current != head);
    }

    // Search by Customer Name or Movie Name
    public void searchTicket(String keyword) {
        if (head == null) {
            System.out.println("No tickets booked.");
            return;
        }

        boolean found = false;
        Ticket current = head;
        do {
            if (current.customerName.equalsIgnoreCase(keyword) || current.movieName.equalsIgnoreCase(keyword)) {
                System.out.println("Match Found - Ticket ID: " + current.ticketId +
                                   ", Customer: " + current.customerName +
                                   ", Movie: " + current.movieName +
                                   ", Seat: " + current.seatNumber +
                                   ", Time: " + current.bookingTime);
                found = true;
            }
            current = current.next;
        } while (current != head);

        if (!found) {
            System.out.println("No tickets found for: " + keyword);
        }
    }

    // Count total tickets
    public int countTickets() {
        if (head == null) return 0;

        int count = 0;
        Ticket current = head;
        do {
            count++;
            current = current.next;
        } while (current != head);
        return count;
    }

    // Main method to test
    public static void main(String[] args) {
        TicketReservationSystem system = new TicketReservationSystem();

        system.addTicket(101, "Alice", "Inception", "A1", "10:00 AM");
        system.addTicket(102, "Bob", "Interstellar", "B2", "1:00 PM");
        system.addTicket(103, "Charlie", "Inception", "A2", "10:00 AM");

        system.displayTickets();

        system.searchTicket("Inception");
        system.searchTicket("David");

        System.out.println("Total booked tickets: " + system.countTickets());

        system.removeTicket(102);
        system.displayTickets();
        System.out.println("Total booked tickets: " + system.countTickets());
    }
}
