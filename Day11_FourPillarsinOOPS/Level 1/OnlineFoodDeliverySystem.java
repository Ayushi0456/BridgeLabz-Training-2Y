// Discountable interface
interface Discountable {
    void applyDiscount(double percentage);
    String getDiscountDetails();
}

// Abstract FoodItem class
abstract class FoodItem {
    // Encapsulated fields
    private String itemName;
    private double price;     // price per unit
    private int quantity;
    private double discountApplied;

    // Constructor
    public FoodItem(String itemName, double price, int quantity) {
        this.itemName = itemName;
        this.price = price;
        this.quantity = quantity;
        this.discountApplied = 0;
    }

    // Abstract method
    public abstract double calculateTotalPrice();

    // Concrete method
    public void getItemDetails() {
        System.out.println("Item: " + itemName);
        System.out.println("Price per unit: " + price);
        System.out.println("Quantity: " + quantity);
        System.out.println("Discount applied: " + discountApplied);
        System.out.println("Total Price: " + calculateTotalPrice());
    }

    // Encapsulation (Getters & Setters)
    public String getItemName() {
        return itemName;
    }

    public double getPrice() {
        return price;
    }

    protected void setPrice(double price) {
        this.price = price; // protected to restrict external changes
    }

    public int getQuantity() {
        return quantity;
    }

    protected void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    public double getDiscountApplied() {
        return discountApplied;
    }

    protected void setDiscountApplied(double discountApplied) {
        this.discountApplied = discountApplied;
    }
}

// VegItem class
class VegItem extends FoodItem implements Discountable {
    private static final double EXTRA_CHARGE = 5; // packaging charge

    public VegItem(String itemName, double price, int quantity) {
        super(itemName, price, quantity);
    }

    @Override
    public double calculateTotalPrice() {
        return (getPrice() * getQuantity() + EXTRA_CHARGE) - getDiscountApplied();
    }

    @Override
    public void applyDiscount(double percentage) {
        double discount = (getPrice() * getQuantity() * percentage) / 100;
        setDiscountApplied(discount);
    }

    @Override
    public String getDiscountDetails() {
        return "Veg Item Discount: " + getDiscountApplied();
    }
}

// NonVegItem class
class NonVegItem extends FoodItem implements Discountable {
    private static final double EXTRA_CHARGE = 20; // handling charge

    public NonVegItem(String itemName, double price, int quantity) {
        super(itemName, price, quantity);
    }

    @Override
    public double calculateTotalPrice() {
        return (getPrice() * getQuantity() + EXTRA_CHARGE) - getDiscountApplied();
    }

    @Override
    public void applyDiscount(double percentage) {
        double discount = (getPrice() * getQuantity() * percentage) / 100;
        setDiscountApplied(discount);
    }

    @Override
    public String getDiscountDetails() {
        return "Non-Veg Item Discount: " + getDiscountApplied();
    }
}

// Main class to test
public class OnlineFoodDeliverySystem {
    // Polymorphic method to process orders
    public static void processOrder(FoodItem item) {
        item.getItemDetails();
        if (item instanceof Discountable) {
            Discountable discountItem = (Discountable) item;
            System.out.println(discountItem.getDiscountDetails());
        }
        System.out.println("----------------------");
    }

    public static void main(String[] args) {
        FoodItem[] order = new FoodItem[3];

        order[0] = new VegItem("Paneer Butter Masala", 250, 2);
        order[1] = new NonVegItem("Chicken Biryani", 350, 1);
        order[2] = new VegItem("Veg Burger", 120, 3);

        // Apply discounts
        ((Discountable) order[0]).applyDiscount(10); // 10% discount
        ((Discountable) order[1]).applyDiscount(5);  // 5% discount
        ((Discountable) order[2]).applyDiscount(15); // 15% discount

        // Process all items polymorphically
        for (FoodItem item : order) {
            processOrder(item);
        }
    }
}

