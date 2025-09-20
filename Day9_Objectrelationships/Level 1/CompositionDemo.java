import java.util.*;

class Book {
    private String title;
    Book(String title){ this.title = title; }
    public String getTitle(){ return title; }
}

class Library {

    private List<Book> books = new ArrayList<>();
    public Book addBook(String title){
        Book b = new Book(title);
        books.add(b);
        return b;
    }
    public void listBooks(){
        System.out.println("Library books:");
        for(Book b : books) System.out.println("- " + b.getTitle());
    }
    
    public void clearLibrary(){
        books.clear();
        System.out.println("Library cleared (books deleted).");
    }
}

public class CompositionDemo {
    public static void main(String[] args){
        Library lib = new Library();
        lib.addBook("Java Fundamentals");
        lib.addBook("Data Structures");
        lib.listBooks();
        lib.clearLibrary();
        lib.listBooks();
    }
}
