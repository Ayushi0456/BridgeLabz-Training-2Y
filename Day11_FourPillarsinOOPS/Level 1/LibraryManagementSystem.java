// Reservable interface
interface Reservable {
    void reserveItem(String borrowerName);
    boolean checkAvailability();
}

// Abstract LibraryItem class
abstract class LibraryItem {
    // Encapsulated fields
    private String itemID;
    private String title;
    private String author;
    private String borrower; // sensitive detail

    // Constructor
    public LibraryItem(String itemID, String title, String author) {
        this.itemID = itemID;
        this.title = title;
        this.author = author;
        this.borrower = null; // initially no borrower
    }

    // Abstract method
    public abstract int getLoanDuration(); // in days

    // Concrete method
    public void getItemDetails() {
        System.out.println("Item ID: " + itemID);
        System.out.println("Title: " + title);
        System.out.println("Author: " + author);
        System.out.println("Loan Duration: " + getLoanDuration() + " days");
    }

    // Encapsulation for borrower
    public String getBorrower() {
        return borrower;
    }

    protected void setBorrower(String borrower) { // protected setter
        this.borrower = borrower;
    }

    public boolean isBorrowed() {
        return borrower != null;
    }
}

// Book class
class Book extends LibraryItem implements Reservable {
    private boolean reserved;

    public Book(String itemID, String title, String author) {
        super(itemID, title, author);
        this.reserved = false;
    }

    @Override
    public int getLoanDuration() {
        return 21; // 3 weeks
    }

    @Override
    public void reserveItem(String borrowerName) {
        if (!reserved) {
            reserved = true;
            setBorrower(borrowerName);
            System.out.println("Book reserved by " + borrowerName);
        } else {
            System.out.println("Book is already reserved.");
        }
    }

    @Override
    public boolean checkAvailability() {
        return !reserved;
    }
}

// Magazine class
class Magazine extends LibraryItem implements Reservable {
    private boolean reserved;

    public Magazine(String itemID, String title, String author) {
        super(itemID, title, author);
        this.reserved = false;
    }

    @Override
    public int getLoanDuration() {
        return 7; // 1 week
    }

    @Override
    public void reserveItem(String borrowerName) {
        if (!reserved) {
            reserved = true;
            setBorrower(borrowerName);
            System.out.println("Magazine reserved by " + borrowerName);
        } else {
            System.out.println("Magazine is already reserved.");
        }
    }

    @Override
    public boolean checkAvailability() {
        return !reserved;
    }
}

// DVD class
class DVD extends LibraryItem implements Reservable {
    private boolean reserved;

    public DVD(String itemID, String title, String author) {
        super(itemID, title, author);
        this.reserved = false;
    }

    @Override
    public int getLoanDuration() {
        return 14; // 2 weeks
    }

    @Override
    public void reserveItem(String borrowerName) {
        if (!reserved) {
            reserved = true;
            setBorrower(borrowerName);
            System.out.println("DVD reserved by " + borrowerName);
        } else {
            System.out.println("DVD is already reserved.");
        }
    }

    @Override
    public boolean checkAvailability() {
        return !reserved;
    }
}

// Main class to test
public class LibraryManagementSystem {
    public static void main(String[] args) {
        // Polymorphism: library item reference
        LibraryItem[] items = new LibraryItem[3];

        items[0] = new Book("B001", "Java Programming", "James Gosling");
        items[1] = new Magazine("M001", "Tech Monthly", "Editorial Team");
        items[2] = new DVD("D001", "Inception", "Christopher Nolan");

        // Process each item
        for (LibraryItem item : items) {
            item.getItemDetails();

            if (item instanceof Reservable) {
                Reservable reservableItem = (Reservable) item;

                System.out.println("Available: " + reservableItem.checkAvailability());
                reservableItem.reserveItem("Alice");
                System.out.println("Available after reservation: " + reservableItem.checkAvailability());
            }

            System.out.println("----------------------");
        }
    }
}

