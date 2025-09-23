import java.util.*;

abstract class Product {
    private int id;
    private String name;
    private double price;

    public Product(int id, String name, double price) {
        this.id = id;
        this.name = name;
        this.price = price;
    }   

    public int getId() { return id; }
    public void setId(int id) { this.id = id; }

    public String getName() { return name; }
    public void setName(String name) { this.name = name; }

    public double getPrice() { return price; }
    public void setPrice(double price) { this.price = price; }

    public abstract double getDiscountedPrice();

    public void displayProductInfo() {
        System.out.println("ID: " + id + ", Name: " + name + ", Base Price: " + price +
                ", Discounted Price: " + getDiscountedPrice());
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) return true;
        if (!(obj instanceof Product)) return false;
        Product other = (Product) obj;
        return this.id == other.id;
    }

    @Override
    public String toString() {
        return "Product ID: " + id + ", Name: " + name + ", Base Price: " + price +
                ", Discounted Price: " + getDiscountedPrice();
    }
}

class OrganicProduct extends Product {
    public OrganicProduct(int id, String name, double price) {
        super(id, name, price);
    }

    @Override
    public double getDiscountedPrice() {
        return getPrice() - (0.10 * getPrice()); // 10% discount
    }

    @Override
    public String toString() {
        return super.toString();
    }
}

class RecycledProduct extends Product {
    public RecycledProduct(int id, String name, double price) {
        super(id, name, price);
    }

    @Override
    public double getDiscountedPrice() {
        return getPrice() - (0.05 * getPrice()); // 5% discount
    }

    @Override
    public String toString() {
        return super.toString();
    }
}

class Cart {
    private List<Product> products;
    private static int totalCartsCreated = 0;
    private static final double TAX_RATE = 0.05; // 5% GST

    public Cart() {
        products = new ArrayList<>();
        totalCartsCreated++;
    }

    
    public void addItem(Product product) {
        products.add(product);
        System.out.println("Added: " + product.getName());
    }

    public void addItem(Product... items) {
        for (Product p : items) {
            products.add(p);
            System.out.println("Added: " + p.getName());
        }
    }

    public void addItem(int productId, int quantity, Product sampleProduct) {
        for (int i = 0; i < quantity; i++) {
            products.add(sampleProduct);
        }
        System.out.println("Added " + quantity + " units of Product ID " + productId);
    }

    public static int getCartCount() {
        return totalCartsCreated;
    }

    public void printCartItems() {
        System.out.println("Cart Items:");
        for (Product p : products) {
            System.out.println(p);
        }
    }

    public void printBill() {
        double total = 0;
        for (Product p : products) {
            double discountedPrice = p.getDiscountedPrice();
            double tax = discountedPrice * TAX_RATE;
            double finalPrice = discountedPrice + tax;
            total += finalPrice;
            System.out.println(p.getName() + " | Discounted: " + discountedPrice + " | Tax: " + tax + " | Final: " + finalPrice);
        }
        System.out.println("Grand Total: " + total);
    }
}


public class EcoCart {
    public static void main(String[] args) {
        OrganicProduct op1 = new OrganicProduct(1, "Organic Rice", 100);
        RecycledProduct rp1 = new RecycledProduct(2, "Recycled Bag", 200);

        op1.displayProductInfo();
        rp1.displayProductInfo();

        Cart cart1 = new Cart();

        cart1.addItem(op1);
        cart1.addItem(rp1);
        cart1.addItem(op1, rp1);
        cart1.addItem(1, 2, op1);

        cart1.printCartItems();

        System.out.println("Total carts created: " + Cart.getCartCount());

        cart1.printBill();
    }
}




