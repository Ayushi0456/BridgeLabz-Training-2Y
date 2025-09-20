interface Taxable {
    double calculateTax();
    String getTaxDetails();
}

abstract class Product {
    private int productID;
    private String name;
    private double price;

    public Product(int productID, String name, double price) {
        this.productID = productID;
        this.name = name;
        this.price = price;
    }

    public abstract double calculateDiscount();

    public int getProductID() {
        return productID;
    }

    public void setProductID(int productID) {
        this.productID = productID;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public void displayDetails() {
        System.out.println("Product ID: " + productID);
        System.out.println("Name: " + name);
        System.out.println("Price: " + price);
    }
}

class Electronics extends Product implements Taxable {
    private double taxRate; 
    public Electronics(int productID, String name, double price, double taxRate) {
        super(productID, name, price);
        this.taxRate = taxRate;
    }

    @Override
    public double calculateDiscount() {
        return getPrice() * 0.10;
    }

    @Override
    public double calculateTax() {
        return getPrice() * taxRate / 100;
    }

    @Override
    public String getTaxDetails() {
        return "Tax: " + calculateTax();
    }
}

class Clothing extends Product implements Taxable {
    private double taxRate;

    public Clothing(int productID, String name, double price, double taxRate) {
        super(productID, name, price);
        this.taxRate = taxRate;
    }

    @Override
    public double calculateDiscount() {
       
        return getPrice() * 0.15;
    }

    @Override
    public double calculateTax() {
        return getPrice() * taxRate / 100;
    }

    @Override
    public String getTaxDetails() {
        return "Tax: " + calculateTax();
    }
}

class Groceries extends Product {
    public Groceries(int productID, String name, double price) {
        super(productID, name, price);
    }

    @Override
    public double calculateDiscount() {
        return getPrice() * 0.05;
    }
}

public class ECommercePlatform {
    public static void printFinalPrice(Product product) {
        double price = product.getPrice();
        double discount = product.calculateDiscount();
        double tax = 0;

        if (product instanceof Taxable) {
            Taxable taxableProduct = (Taxable) product;
            tax = taxableProduct.calculateTax();
            System.out.println(product.getName() + " | " + taxableProduct.getTaxDetails());
        }

        double finalPrice = price + tax - discount;
        System.out.println(product.getName() + " | Final Price: " + finalPrice);
        System.out.println("----------------------------");
    }

    public static void main(String[] args) {
        Product[] products = new Product[4];

        products[0] = new Electronics(101, "Laptop", 50000, 15);
        products[1] = new Clothing(102, "Jeans", 2000, 5);
        products[2] = new Groceries(103, "Rice", 800);
        products[3] = new Electronics(104, "Smartphone", 30000, 12);

        for (Product p : products) {
            p.displayDetails();
            printFinalPrice(p);
        }
    }
}

