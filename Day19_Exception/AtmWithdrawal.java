class InsufficientFundsException extends Exception {
    public InsufficientFundsException(String message) {
        super(message);
    }
}
class ATM {
    private int balance = 10000; 

    public void withdraw(int amount) throws InsufficientFundsException {
        if (amount > balance) {
            throw new InsufficientFundsException("Withdrawal failed! Insufficient balance.");
        } else {
            balance -= amount;
            System.out.println("Withdrawal successful! Remaining Balance: " + balance);
        }
    }
}


public class AtmWithdrawal {
    public static void main(String[] args) {
        ATM atm = new ATM();
        int amount = 15000; 

        try {
            atm.withdraw(amount);
        } catch (InsufficientFundsException e) {
            System.out.println(e.getMessage());
        }

        System.out.println("Transaction Completed.");
    }
}

