import java.util.*;

class Product {
    String name;
    int price;
    int rating;

    Product(String name, int price, int rating) {
        this.name = name;
        this.price = price;
        this.rating = rating;
    }

    public String toString() {
        return name + " - ₹" + price + " - Rating: " + rating;
    }
}

public class ProductSorting {
    public static void main(String[] args) {

        List<Product> products = Arrays.asList(
            new Product("Shoes", 1500, 4),
            new Product("Watch", 2000, 5),
            new Product("Bag", 900, 3)
        );

        System.out.println("Sort by price:");
        products.sort((a, b) -> a.price - b.price);
        products.forEach(System.out::println);

        System.out.println("\nSort by rating:");
        products.sort((a, b) -> b.rating - a.rating);
        products.forEach(System.out::println);
    }
}

