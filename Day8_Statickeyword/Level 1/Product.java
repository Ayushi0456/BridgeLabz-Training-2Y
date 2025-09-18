class Product {
    static double discount = 10.0; 

    final int productID;
    String productName;
    double price;
    int quantity;

    Product(int productID, String productName, double price, int quantity) {
        this.productID = productID;
        this.productName = productName;
        this.price = price;
        this.quantity = quantity;
    }

    static void updateDiscount(double newDiscount) {
        discount = newDiscount;
    }

    void displayProductDetails() {
        if (this instanceof Product) {
            System.out.println("ProductID: " + productID + ", Name: " + productName +
                               ", Price: " + price + ", Quantity: " + quantity +
                               ", Discount: " + discount + "%");
        }
    }

    public static void main(String[] args) {
        Product p1 = new Product(101, "Laptop", 50000, 2);
        Product p2 = new Product(102, "Phone", 20000, 5);
        p1.displayProductDetails();
        p2.displayProductDetails();
        Product.updateDiscount(15);
        p1.displayProductDetails();
    }
}

