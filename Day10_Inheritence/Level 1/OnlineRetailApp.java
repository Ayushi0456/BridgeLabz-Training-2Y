import java.time.LocalDate;

class Order {
    protected String orderId;
    protected LocalDate orderDate;

    public Order(String orderId, LocalDate orderDate) {
        this.orderId = orderId;
        this.orderDate = orderDate;
    }

    public String getOrderStatus() {
        return "Order placed on " + orderDate;
    }
}

class ShippedOrder extends Order {
    protected String trackingNumber;

    public ShippedOrder(String orderId, LocalDate orderDate, String trackingNumber) {
        super(orderId, orderDate); 
        this.trackingNumber = trackingNumber;
    }

    @Override
    public String getOrderStatus() {
        return "Order shipped with Tracking Number: " + trackingNumber;
    }
}

class DeliveredOrder extends ShippedOrder {
    private LocalDate deliveryDate;

    public DeliveredOrder(String orderId, LocalDate orderDate, String trackingNumber, LocalDate deliveryDate) {
        super(orderId, orderDate, trackingNumber); 
        this.deliveryDate = deliveryDate;
    }

    @Override
    public String getOrderStatus() {
        return "Order delivered on " + deliveryDate;
    }
}

public class OnlineRetailApp {
    public static void main(String[] args) {
        Order order = new Order("ORD1001", LocalDate.of(2025, 9, 15));
        System.out.println(order.getOrderStatus());

        ShippedOrder shipped = new ShippedOrder("ORD1002", LocalDate.of(2025, 9, 16), "TRK12345");
        System.out.println(shipped.getOrderStatus());

        DeliveredOrder delivered = new DeliveredOrder("ORD1003", LocalDate.of(2025, 9, 17), "TRK54321", LocalDate.of(2025, 9, 20));
        System.out.println(delivered.getOrderStatus());
    }
}

