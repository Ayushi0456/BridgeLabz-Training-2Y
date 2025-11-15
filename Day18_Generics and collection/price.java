import java.util.*;

class Product {
    private double price;
    public Product(double price) { this.price = price; }
    public double getPrice() { return price; }
}

class Mobile extends Product { Mobile(double p){ super(p);} }
class Laptop extends Product { Laptop(double p){ super(p);} }

class PriceCalculator {
    public static double calculateTotal(List<? extends Product> items) {
        double total = 0;
        for (Product p : items) total += p.getPrice();
        return total;
    }

    public static void main(String[] args) {
        List<Mobile> mobiles = List.of(new Mobile(10000), new Mobile(12000));
        System.out.println(calculateTotal(mobiles));
    }
}

