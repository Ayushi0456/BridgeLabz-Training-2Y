class SeatUnavailableException extends Exception {
    public SeatUnavailableException(String msg) {
        super(msg);
    }
}

class PaymentFailedException extends Exception {
    public PaymentFailedException(String msg) {
        super(msg);
    }
}

public class Flight{
    static void checkSeatAvailability() throws SeatUnavailableException {
        throw new SeatUnavailableException("Seat is unavailable!");
    }

    static void processPayment() throws PaymentFailedException {
        throw new PaymentFailedException("Payment failed!");
    }

    static void bookTicket() throws Exception {
        checkSeatAvailability();
        processPayment();
    }

    public static void main(String[] args) {
        try {
            bookTicket();
        } catch (SeatUnavailableException e) {
            System.out.println(e.getMessage());
        } catch (PaymentFailedException e) {
            System.out.println(e.getMessage());
        } catch (Exception e) {
            System.out.println("Unknown error!");
        } finally {
            System.out.println("Thank you for booking with us!");
        }
    }
}

