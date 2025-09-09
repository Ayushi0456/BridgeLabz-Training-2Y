class Book {
    public String ISBN;      
    protected String title;   
    private String author;   
    Book(String ISBN, String title, String author) {
        this.ISBN = ISBN;
        this.title = title;
        this.author = author;
    }

    public String getAuthor() {   
        return author;
    }

    public void setAuthor(String author) {
        this.author = author;
    }
}

class EBook extends Book {
    double fileSize;

    EBook(String ISBN, String title, String author, double fileSize) {
        super(ISBN, title, author);
        this.fileSize = fileSize;
    }

    void displayDetails() {
        System.out.println("ISBN: " + ISBN);        
        System.out.println("Title: " + title);      
        System.out.println("Author: " + getAuthor());
        System.out.println("File Size: " + fileSize + " MB");
    }

    public static void main(String[] args) {
        EBook ebook = new EBook("978-12345", "Java Programming", "James Gosling", 5.2);
        ebook.displayDetails();
        ebook.setAuthor("Oracle Corp");
        System.out.println("Updated Author: " + ebook.getAuthor());
    }
}

