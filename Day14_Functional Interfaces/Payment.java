interface PaymentProcessor {
    void pay(double amt);

    default void refund(double amt) {
        System.out.println("Refund done: " + amt);
    }
}

class Paytm implements PaymentProcessor {
    public void pay(double amt) { System.out.println("Paid: " + amt); }
}

public class Payment{
    public static void main(String[] args) {
        Paytm p = new Paytm();
        p.pay(900);
        p.refund(200);
    }
}

