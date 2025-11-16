import java.util.*;

public class InventoryManager {

    public static void main(String[] args) {

        Map<String, Integer> inventory = new HashMap<>();
        inventory.put("Apple", 50);
        inventory.put("Milk", 20);
        inventory.put("Soap", 15);
        inventory.put("Bread", 10);
        System.out.println("Initial Inventory:");
        printInventory(inventory);

        System.out.println("\nCustomer buys 12 Apples...");
        reduceStock(inventory, "Apple", 12);

        System.out.println("Customer buys 20 Milk...");
        reduceStock(inventory, "Milk", 20);

        System.out.println("Customer buys 5 Bread...");
        reduceStock(inventory, "Bread", 5);

        printInventory(inventory);
        System.out.println("\nNew shipment: adding 30 Soap and 10 Milk...");
        
        increaseStock(inventory, "Soap", 30);
        increaseStock(inventory, "Milk", 10);

        printInventory(inventory);
        System.out.println("\nManager checks quantity of 'Soap':");
        queryProduct(inventory, "Soap");

        System.out.println("Manager checks quantity of 'Juice':");
        queryProduct(inventory, "Juice");

        System.out.println("\nOut-of-stock products:");
        printOutOfStock(inventory);
    }

    public static void reduceStock(Map<String, Integer> inv, String product, int amount) {
        if (!inv.containsKey(product)) {
            System.out.println(product + " is not stocked!");
            return;
        }

        int newQty = inv.get(product) - amount;

        if (newQty <= 0) {
            System.out.println(product + " is now OUT OF STOCK!");
            inv.put(product, 0); 
        } else {
            inv.put(product, newQty);
        }
    }
    public static void increaseStock(Map<String, Integer> inv, String product, int amount) {
        inv.put(product, inv.getOrDefault(product, 0) + amount);
    }
    public static void queryProduct(Map<String, Integer> inv, String product) {
        if (!inv.containsKey(product)) {
            System.out.println(product + " is NOT stocked.");
        } else {
            System.out.println(product + " quantity = " + inv.get(product));
        }
    }

    public static void printInventory(Map<String, Integer> inv) {
        System.out.println("Current Inventory:");
        for (Map.Entry<String, Integer> entry : inv.entrySet()) {
            System.out.println(entry.getKey() + " = " + entry.getValue());
        }
    }

    public static void printOutOfStock(Map<String, Integer> inv) {
        boolean found = false;
        for (Map.Entry<String, Integer> entry : inv.entrySet()) {
            if (entry.getValue() == 0) {
                System.out.println(entry.getKey());
                found = true;
            }
        }
        if (!found) {
            System.out.println("No products are out of stock!");
        }
    }
}

