import java.util.Scanner;

class Book {
    
    String bookID;
    String title;
    String author;
    boolean available;
    int[] ratings;

    
    Book(String bookID, String title, String author, boolean available, int[] ratings) {
        this.bookID = bookID.toUpperCase();  
        this.title = title;
        this.author = author;
        this.available = available;
        this.ratings = ratings;
    }


    void displayBookDetails() {
        System.out.println("Book ID: " + bookID);
        System.out.println("Title: " + title.toUpperCase());  
        System.out.println("Author: " + author + " (Length: " + author.length() + ")");
        System.out.println("Available: " + (available ? "Yes" : "No"));
    }


    void processRatings() {
        if (ratings.length == 0) {
            System.out.println("No ratings available!");
            
        }

        int sum = 0;
        boolean poorRating = false;

        System.out.print("Ratings: ");
        for (int rating : ratings) {
            System.out.print(rating + " ");
            sum += rating;
            if (rating == 1) {
                poorRating = true;
            }
        }
        System.out.println();

        if (poorRating) {
            System.out.println("⚠ 1 user gave a poor rating.");
        }

        double avg = (double) sum / ratings.length;
        System.out.println("Average Rating: " + avg);

        if (avg >= 4) {
            System.out.println("This is a HIGHLY RATED book!");
        } else {
            System.out.println("This is an AVERAGE book.");
        }
    }
}

public class librarybook {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        // Taking user input
        System.out.print("Enter Book ID: ");
        String bookID = sc.nextLine();

        System.out.print("Enter Book Title: ");
        String title = sc.nextLine();

        System.out.print("Enter Author Name: ");
        String author = sc.nextLine();

        System.out.print("Is the book available? (true/false): ");
        boolean available = sc.nextBoolean();

        System.out.print("Enter number of ratings: ");
        int n = sc.nextInt();
        int[] ratings = new int[n];

        for (int i = 0; i < n; i++) {
            System.out.print("Enter rating " + (i + 1) + ": ");
            ratings[i] = sc.nextInt();
        }

        
        Book b1 = new Book(bookID, title, author, available, ratings);

        System.out.println("\n--- BOOK DETAILS ---");
        b1.displayBookDetails();

        System.out.println("\n--- RATING DETAILS ---");
        b1.processRatings();
    }
}

