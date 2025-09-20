import java.util.*;

class Product {
    private String name;
    private double price;
    public Product(String n, double p){ name=n; price=p; }
    public String getName(){ return name; }
    public double getPrice(){ return price; }
}

class Order {
    private static int nextId = 1;
    private int id;
    private List<Product> products = new ArrayList<>();
    public Order(){ id = nextId++; }
    public void addProduct(Product p){ products.add(p); }
    public double total(){
        double sum=0; for(Product p: products) sum += p.getPrice(); return sum;
    }
    public void printInvoice(){
        System.out.println("Order #" + id);
        for(Product p : products) System.out.println("- " + p.getName() + " : " + p.getPrice());
        System.out.println("Total: " + total());
    }
}

class Customer {
    private String name;
    public Customer(String name){ this.name = name; }
    public Order placeOrder(){
        System.out.println(name + " places an order.");
        return new Order();
    }
}

public class EcommerceDemo {
    public static void main(String[] args){
        Product p1 = new Product("Phone", 15000);
        Product p2 = new Product("Charger", 500);

        Customer cust = new Customer("Ayushi");
        Order order = cust.placeOrder();
        order.addProduct(p1);
        order.addProduct(p2);
        order.printInvoice();
    }
}

