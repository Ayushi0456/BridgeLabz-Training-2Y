class Book {
    static String libraryName = "GLA Library";

    final String isbn;
    String title, author;

    Book(String isbn, String title, String author) {
        this.isbn = isbn;
        this.title = title;
        this.author = author;
    }

    static void displayLibraryName() {
        System.out.println("Library Name: " + libraryName);
    }

    void displayBookDetails() {
        if (this instanceof Book) {
            System.out.println("ISBN: " + isbn + ", Title: " + title + ", Author: " + author);
        }
    }

    public static void main(String[] args) {
        Book b1 = new Book("111", "Java Basics", "James");
        Book b2 = new Book("222", "DBMS", "Navathe");
        b1.displayBookDetails();
        b2.displayBookDetails();
        Book.displayLibraryName();
    }
}

