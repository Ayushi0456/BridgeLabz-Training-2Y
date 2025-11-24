import java.util.*;
import java.util.Stack;



class Product {
    String name;
    double price;
    int stock;
    Product(String n, double p, int s) { name=n; price=p; stock=s; }
}

public class InventorySystem {
    Set<String> productNames = new HashSet<>();
    List<Product> products = new ArrayList<>();
    Queue<Product> restockQueue = new LinkedList<>();
    Stack<Product> restockedStack = new Stack<>();

    void addProduct(Product p) {
        if(productNames.add(p.name)) products.add(p);
    }

    void checkLowStock() {
        for(Product p : products) if(p.stock<5) restockQueue.add(p);
    }

    void processRestock() {
        while(!restockQueue.isEmpty()) {
            Product p = restockQueue.poll();
            p.stock += 10;
            restockedStack.push(p);
        }
    }

    void undoRestock() {
        if(!restockedStack.isEmpty()) {
            Product p = restockedStack.pop();
            p.stock -= 10;
        }
    }

    public static void main(String[] a) {
        InventorySystem s = new InventorySystem();
        s.addProduct(new Product("Milk", 40, 2));
        s.addProduct(new Product("Bread", 30, 10));
        s.checkLowStock();
        s.processRestock();
        s.undoRestock();
    }
}

