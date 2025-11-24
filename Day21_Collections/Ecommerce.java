import java.util.*;
import java.util.Stack;


class Order {
    int orderId;
    String item;

    public Order(int orderId, String item) {
        this.orderId = orderId;
        this.item = item;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Order)) return false;
        Order order = (Order) o;
        return orderId == order.orderId;
    }

    @Override
    public int hashCode() {
        return Objects.hash(orderId);
    }

    @Override
    public String toString() {
        return "OrderID=" + orderId + ", Item=" + item;
    }
}

public class Ecommerce{
    public static void main(String[] args) {

        List<Order> orderList = new ArrayList<>();
        orderList.add(new Order(101, "Shoes"));
        orderList.add(new Order(102, "Watch"));
        orderList.add(new Order(101, "Shoes Duplicate")); 

        Set<Order> uniqueOrders = new HashSet<>(orderList);

        Queue<Order> processingQueue = new LinkedList<>(uniqueOrders);

        Stack<Order> failedStack = new Stack<>();

      
        while (!processingQueue.isEmpty()) {
            Order o = processingQueue.poll();
            System.out.println("Processing: " + o);

            if (o.orderId == 102) { 
                System.out.println("Order failed, adding to retry stack");
                failedStack.push(o);
            }
        }

        System.out.println("\nRetrying failed orders...");
        while (!failedStack.isEmpty()) {
            Order o = failedStack.pop();
            System.out.println("Retrying: " + o);
        }
    }
}

