import java.util.*;

public class LibraryCatalog {

    public static void main(String[] args) {

        Map<String, String> catalog = new TreeMap<>();
        catalog.put("978-1234567890", "Java Basics");
        catalog.put("978-1111111111", "Data Structures");
        catalog.put("978-2222222222", "Operating Systems");
        catalog.put("978-3333333333", "Database Management");

        System.out.println("Initial Catalog:");
        printCatalog(catalog);
        System.out.println("\nSearching for ISBN: 978-1111111111");
        searchByISBN(catalog, "978-1111111111");

        System.out.println("\nSearching for ISBN: 978-9999999999");
        searchByISBN(catalog, "978-9999999999");
        System.out.println("\nRemoving book with ISBN 978-2222222222...");
        catalog.remove("978-2222222222");
        printCatalog(catalog);
        System.out.println("\nSearching for title: 'Java Basics'");
        searchByTitle(catalog, "Java Basics");

        System.out.println("\nSearching for title: 'C Programming'");
        searchByTitle(catalog, "C Programming");
        System.out.println("\nFinal Sorted Catalog:");
        printCatalog(catalog);
    }
    public static void printCatalog(Map<String, String> catalog) {
        System.out.println("ISBN → Title:");
        for (Map.Entry<String, String> entry : catalog.entrySet()) {
            System.out.println(entry.getKey() + " = " + entry.getValue());
        }
    }
    public static void searchByISBN(Map<String, String> catalog, String isbn) {
        if (catalog.containsKey(isbn)) {
            System.out.println("Book found: " + catalog.get(isbn));
        } else {
            System.out.println("Book NOT found!");
        }
    }
    public static void searchByTitle(Map<String, String> catalog, String title) {
        boolean found = false;

        for (Map.Entry<String, String> entry : catalog.entrySet()) {
            if (entry.getValue().equalsIgnoreCase(title)) {
                System.out.println("Book found: ISBN " + entry.getKey());
                found = true;
            }
        }

        if (!found) {
            System.out.println("Book title NOT found!");
        }
    }
}

