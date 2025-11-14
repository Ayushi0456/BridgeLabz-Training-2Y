interface Payment {
    void pay(double amount);
}

class UPI implements Payment {
    public void pay(double amount) { System.out.println("Paid via UPI: " + amount); }
}

class Wallet implements Payment {
    public void pay(double amount) { System.out.println("Paid via Wallet: " + amount); }
}

public class PaymentDemo {
    public static void main(String[] args) {
        Payment p = new UPI();
        p.pay(1500);
    }
}
