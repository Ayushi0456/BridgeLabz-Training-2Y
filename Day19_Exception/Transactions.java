import java.util.Random;

class NegativeAmountException extends Exception {
    public NegativeAmountException(String message) {
        super(message);
    }
}
class InsufficientFundsException extends Exception {
    public InsufficientFundsException(String message) {
        super(message);
    }
}
class NetworkFailureException extends Exception {
    public NetworkFailureException(String message) {
        super(message);
    }
}

class Transaction {

    private int balance = 5000; 

    public void processTransaction(int amount)
            throws NegativeAmountException, InsufficientFundsException, NetworkFailureException {

        Random rand = new Random();
        int result = rand.nextInt(4); 

        if (result == 0) {
            throw new NegativeAmountException("Transaction Failed: Negative transaction amount is not allowed.");
        }
        else if (result == 1) {
            throw new InsufficientFundsException("Transaction Failed: Insufficient account balance.");
        }
        else if (result == 2) {
            throw new NetworkFailureException("Transaction Failed: Network connection lost.");
        }
        else {
            if (amount > balance) {
                throw new InsufficientFundsException("Transaction Failed: Insufficient funds for the amount.");
            }
            balance -= amount;
            System.out.println("Transaction Successful! Remaining Balance: " + balance);
        }
    }
}

public class Transactions {
    public static void main(String[] args) {

        Transaction transaction = new Transaction();
        int amount = 1000; 

        try {
            transaction.processTransaction(amount);
        } 
        catch (NegativeAmountException e) {
            System.out.println("Error: " + e.getMessage());
        }
        catch (InsufficientFundsException e) {
            System.out.println("Error: " + e.getMessage());
        }
        catch (NetworkFailureException e) {
            System.out.println("Error: " + e.getMessage());
        }

        System.out.println("Transaction Process Completed.");
    }
}

