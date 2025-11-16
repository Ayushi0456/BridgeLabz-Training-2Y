import java.util.*;

class BookNotAvailableException extends Exception {
    public BookNotAvailableException(String msg) {
        super(msg);
    }
}

class InvalidReturnException extends Exception {
    public InvalidReturnException(String msg) {
        super(msg);
    }
}

class UserLimitExceededException extends Exception {
    public UserLimitExceededException(String msg) {
        super(msg);
    }
}

class Library {

    private Map<String, Boolean> books = new HashMap<>(); 
    private Map<String, Set<String>> userRecords = new HashMap<>(); 
    private final int MAX_LIMIT = 2; 
    public Library() {
        books.put("Java Programming", true);
        books.put("Data Structures", true);
        books.put("Operating System", true);
        books.put("DBMS Concepts", true);
    }

    public void borrowBook(String user, String book)
            throws BookNotAvailableException, UserLimitExceededException {

        if (!books.containsKey(book) || !books.get(book)) {
            throw new BookNotAvailableException("The book '" + book + "' is currently NOT available.");
        }

        userRecords.putIfAbsent(user, new HashSet<>());
        Set<String> borrowedBooks = userRecords.get(user);

        if (borrowedBooks.size() >= MAX_LIMIT) {
            throw new UserLimitExceededException(
                    "Borrowing limit exceeded! You can only borrow " + MAX_LIMIT + " books.");
        }
        borrowedBooks.add(book);
        books.put(book, false);
        System.out.println(user + " successfully borrowed: " + book);
    }
    public void returnBook(String user, String book)
            throws InvalidReturnException {

        if (!userRecords.containsKey(user) || !userRecords.get(user).contains(book)) {
            throw new InvalidReturnException("Invalid Return! You never borrowed the book: " + book);
        }

        userRecords.get(user).remove(book);
        books.put(book, true);
        System.out.println(user + " successfully returned: " + book);
    }
}

public class Library1{
    public static void main(String[] args) {

        Library library = new Library();

        try {
            library.borrowBook("Ayushi", "Java Programming");
            library.borrowBook("Ayushi", "Data Structures");
            library.borrowBook("Ayushi", "Operating System");

        } catch (BookNotAvailableException e) {
            System.out.println("Error: " + e.getMessage());
        } catch (UserLimitExceededException e) {
            System.out.println("Error: " + e.getMessage());
        }

        System.out.println();

        try {
            library.returnBook("Ayushi", "Java Programming");

            library.returnBook("Ayushi", "DBMS Concepts");

        } catch (InvalidReturnException e) {
            System.out.println("Error: " + e.getMessage());
        }

        System.out.println("\nLibrary operations completed.");
    }
}

