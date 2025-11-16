import java.util.*;

public class Shopping {

    public static void main(String[] args) {

        LinkedHashMap<String, Double> priceMap = new LinkedHashMap<>();
        LinkedHashMap<String, Integer> qtyMap = new LinkedHashMap<>();

        addProduct(priceMap, qtyMap, "Laptop", 45000, 1);
        addProduct(priceMap, qtyMap, "Mouse", 500, 2);
        addProduct(priceMap, qtyMap, "Keyboard", 1500, 1);
        addProduct(priceMap, qtyMap, "Headphones", 2000, 1);

        System.out.println("\nProducts in Cart (In Order Added):");
        displayCart(priceMap, qtyMap);

        removeItem(priceMap, qtyMap, "Mouse", 2);   
        removeItem(priceMap, qtyMap, "Keyboard", 1);
        removeItem(priceMap, qtyMap, "Laptop", 0); 

        System.out.println("\nCart After Removing Items:");
        displayCart(priceMap, qtyMap);

        System.out.println("\nFinal Bill Summary:");
        calculateTotal(priceMap, qtyMap);
    }

    public static void addProduct(LinkedHashMap<String, Double> priceMap,
                                  LinkedHashMap<String, Integer> qtyMap,
                                  String product, double price, int qty) {
        priceMap.put(product, price);
        qtyMap.put(product, qty);
        System.out.println("Added: " + product + " | Price: " + price + " | Quantity: " + qty);
    }

    public static void removeItem(LinkedHashMap<String, Double> priceMap,
                                  LinkedHashMap<String, Integer> qtyMap,
                                  String product, int qtyToRemove) {

        if (!qtyMap.containsKey(product)) {
            System.out.println("Product not found: " + product);
            return;
        }

        int currentQty = qtyMap.get(product);
        int newQty = currentQty - qtyToRemove;

        if (newQty <= 0) {
            qtyMap.remove(product);
            priceMap.remove(product);
            System.out.println("Removed entire item: " + product + " (Quantity became 0)");
        } else {
            qtyMap.put(product, newQty);
            System.out.println("Updated: " + product + " New Quantity: " + newQty);
        }
    }

    public static void displayCart(LinkedHashMap<String, Double> prices,
                                   LinkedHashMap<String, Integer> quantity) {

        if (prices.isEmpty()) {
            System.out.println("Cart is empty!");
            return;
        }

        for (String product : prices.keySet()) {
            System.out.println(product + " → Price: " + prices.get(product)
                    + " | Qty: " + quantity.get(product));
        }
    }

    public static void calculateTotal(LinkedHashMap<String, Double> priceMap,
                                      LinkedHashMap<String, Integer> qtyMap) {

        double total = 0;

        for (String product : priceMap.keySet()) {
            total += priceMap.get(product) * qtyMap.get(product);
        }

        System.out.println("Subtotal: Rs. " + total);

        if (total > 5000) {
            double discount = total * 0.10;
            total -= discount;
            System.out.println("Discount Applied (10%): Rs. " + discount);
        }

        System.out.println("Final Total: Rs. " + total);
    }
}

