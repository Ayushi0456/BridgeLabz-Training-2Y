class LibraryBook {
    String title;
    String author;
    double price;
    boolean available;

  
    LibraryBook(String title, String author, double price) {
        this.title = title;
        this.author = author;
        this.price = price;
        this.available = true;
    }

    void borrowBook() {
        if (available) {
            available = false;
            System.out.println(title + " has been borrowed.");
        } else {
            System.out.println(title + " is not available.");
        }
    }

    void display() {
        System.out.println("Title: " + title + ", Author: " + author + ", Price: " + price + ", Available: " + available);
    }

    public static void main(String[] args) {
        LibraryBook b1 = new LibraryBook("Java Fundamentals", "James Gosling", 450);
        b1.display();
        b1.borrowBook();
        b1.display();
    }
}
