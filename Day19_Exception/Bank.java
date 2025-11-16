class AccountNotFoundException extends Exception {
    public AccountNotFoundException(String msg) {
        super(msg);
    }
}

class InsufficientFundsException extends Exception {
    public InsufficientFundsException(String msg) {
        super(msg);
    }
}

public class Bank {

    static void verifyAccount() throws AccountNotFoundException {
        throw new AccountNotFoundException("Account not found!");
    }

    static void processTransaction() throws InsufficientFundsException {
        throw new InsufficientFundsException("Not enough balance!");
    }

    static void executeTransaction() throws Exception {
        verifyAccount();
        processTransaction();
    }

    public static void main(String[] args) {
        try {
            executeTransaction();
        } catch (AccountNotFoundException e) {
            System.out.println(e.getMessage());
        } catch (InsufficientFundsException e) {
            System.out.println(e.getMessage());
        } catch (Exception e) {
            System.out.println("Something went wrong!");
        } finally {
            System.out.println("Transaction complete.");
        }
    }
}

