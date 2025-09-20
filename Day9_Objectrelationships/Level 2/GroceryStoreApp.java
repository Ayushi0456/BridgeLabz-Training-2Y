import java.util.*;

class Product {
    private String name;
    private double quantity;
    private double pricePerUnit;

    public Product(String name, double quantity, double pricePerUnit) {
        this.name = name;
        this.quantity = quantity;
        this.pricePerUnit = pricePerUnit;
    }

    public String getName() {
        return name;
    }

    public double getQuantity() {
        return quantity;
    }

    public double getPricePerUnit() {
        return pricePerUnit;
    }

    public double getCost() {
        return quantity * pricePerUnit;
    }
}

class Customer {
    private String name;
    private List<Product> products;

    public Customer(String name) {
        this.name = name;
        this.products = new ArrayList<>();
    }

    public void addProduct(Product product) {
        products.add(product);
    }

    public List<Product> getProducts() {
        return products;
    }

    public String getName() {
        return name;
    }
}

class BillGenerator {
    public double generateBill(Customer customer) {
        double total = 0.0;
        for (Product p : customer.getProducts()) {
            total += p.getCost();
        }
        return total;
    }
}

public class GroceryStoreApp {
    public static void main(String[] args) {
        
        Customer customer = new Customer("Alice");

      
        customer.addProduct(new Product("Apples", 2, 3.0)); // 2 kg @ $3
        customer.addProduct(new Product("Milk", 1, 2.0));   // 1 liter @ $2

       
        BillGenerator generator = new BillGenerator();
        double totalBill = generator.generateBill(customer);

      
        System.out.println("Customer: " + customer.getName());
        for (Product p : customer.getProducts()) {
            System.out.println("Product: " + p.getName() + 
                               " | Quantity: " + p.getQuantity() + 
                               " | Price/unit: $" + p.getPricePerUnit() + 
                               " | Cost: $" + p.getCost());
        }
        System.out.println("Total Bill: $" + totalBill);
    }
}

