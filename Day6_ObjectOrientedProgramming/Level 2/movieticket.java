class movieticket {
    String movieName;
    int seatNumber;
    double price;

    movieticket(String movieName) {
        this.movieName = movieName;
        this.seatNumber = -1;  
        this.price = 0.0;
    }

    
    void bookTicket(int seatNumber, double price) {
        if (this.seatNumber == -1) {
            this.seatNumber = seatNumber;
            this.price = price;
            System.out.println("Ticket booked successfully!");
        } else {
            System.out.println("Seat already booked!");
        }
    }

    
    void displayTicket() {
        if (seatNumber == -1) {
            System.out.println("No ticket booked yet.");
        } else {
            System.out.println("Movie: " + movieName);
            System.out.println("Seat Number: " + seatNumber);
            System.out.println("Price: " + price);
        }
    }

    public static void main(String[] args) {
        movieticket ticket1 = new movieticket("Inception");
        ticket1.displayTicket();

        ticket1.bookTicket(12, 250.0);
        ticket1.displayTicket();

        ticket1.bookTicket(15, 300.0); 
    }
}

