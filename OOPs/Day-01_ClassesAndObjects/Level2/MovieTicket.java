public class MovieTicket {
    String movieName;
    String seatNumber;
    double price;

    public void bookTicket(String movieName, String seatNumber, double price) {
        this.movieName = movieName;
        this.seatNumber = seatNumber;
        this.price = price;
        System.out.println("Ticket booked successfully.");
    }

    public void displayTicketDetails() {
        System.out.println("Movie Name : " + movieName);
        System.out.println("Seat Number: " + seatNumber);
        System.out.println("Price      : ₹" + price);
    }

    public static void main(String[] args) {
        MovieTicket ticket1 = new MovieTicket();
        ticket1.bookTicket("Avengers: Endgame", "A12", 250.00);
        ticket1.displayTicketDetails();
    }
}