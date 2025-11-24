import java.util.*;
import java.util.Stack;


class Account {
    String accNo;

    public Account(String accNo) { this.accNo = accNo; }

    @Override
    public boolean equals(Object o) {
        if (!(o instanceof Account)) return false;
        return accNo.equals(((Account)o).accNo);
    }

    @Override
    public int hashCode() {
        return accNo.hashCode();
    }
}

class Transaction {
    String accNo;
    double amount;

    public Transaction(String accNo, double amount) {
        this.accNo = accNo;
        this.amount = amount;
    }

    public String toString() {
        return accNo + " : " + amount;
    }
}

public class BankSystem {
    public static void main(String[] args) {

        List<Transaction> allTransactions = new ArrayList<>();

        Queue<Transaction> pending = new LinkedList<>();
        pending.add(new Transaction("A101", 1000));
        pending.add(new Transaction("A102", 500));
        pending.add(new Transaction("A999", 200)); // invalid account

        Set<Account> validAccounts = new HashSet<>();
        validAccounts.add(new Account("A101"));
        validAccounts.add(new Account("A102"));

        Stack<Transaction> undoStack = new Stack<>();

        System.out.println("Processing transactions...");
        while (!pending.isEmpty()) {
            Transaction t = pending.poll();

            if (validAccounts.contains(new Account(t.accNo))) {
                System.out.println("Executed: " + t);
                allTransactions.add(t);
                undoStack.push(t);
            } else {
                System.out.println("Invalid Account: " + t.accNo);
            }
        }

        System.out.println("\nUNDO last transaction:");
        Transaction last = undoStack.pop();
        System.out.println("Rolling back: " + last);
    }
}

