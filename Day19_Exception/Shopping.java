import java.util.Random;
class OutOfStockException extends Exception {
    public OutOfStockException(String msg) {
        super(msg);
    }
}
class PaymentFailedException extends Exception {
    public PaymentFailedException(String msg) {
        super(msg);
    }
}
class ShoppingSystem {
    public void placeOrder(String product) throws OutOfStockException, PaymentFailedException {

        Random rand = new Random();
        int result = rand.nextInt(3);  

        if (result == 0) {
            throw new OutOfStockException("Product '" + product + "' is OUT OF STOCK!");
        } else if (result == 1) {
            throw new PaymentFailedException("Payment FAILED for product '" + product + "'!");
        } else {
            System.out.println("Order placed SUCCESSFULLY for: " + product);
        }
    }
}

public class Shopping{
    public static void main(String[] args) {

        ShoppingSystem shop = new ShoppingSystem();
        String product = "Laptop";

        try {
            shop.placeOrder(product);
        } 
        catch (OutOfStockException e) {
            System.out.println(e.getMessage());
        } 
        catch (PaymentFailedException e) {
            System.out.println(e.getMessage());
        }

        System.out.println("Thank you for shopping with us!");
    }
}

