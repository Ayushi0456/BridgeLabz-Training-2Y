interface Loanable {
    void applyForLoan(double amount);
    boolean calculateLoanEligibility();
}

abstract class BankAccount {
    private String accountNumber;
    private String holderName;
    private double balance;

    public BankAccount(String accountNumber, String holderName, double balance) {
        this.accountNumber = accountNumber;
        this.holderName = holderName;
        this.balance = balance;
    }

    public void deposit(double amount) {
        if (amount > 0) {
            balance += amount;
            System.out.println("Deposited: " + amount + ", New Balance: " + balance);
        } else {
            System.out.println("Invalid deposit amount.");
        }
    }

    public void withdraw(double amount) {
        if (amount > 0 && amount <= balance) {
            balance -= amount;
            System.out.println("Withdrawn: " + amount + ", New Balance: " + balance);
        } else {
            System.out.println("Invalid withdraw amount or insufficient balance.");
        }
    }

    public abstract double calculateInterest();

    public String getAccountNumber() {
        return accountNumber;
    }

    public void setAccountNumber(String accountNumber) {
        this.accountNumber = accountNumber;
    }

    public String getHolderName() {
        return holderName;
    }

    public void setHolderName(String holderName) {
        this.holderName = holderName;
    }

    public double getBalance() {
        return balance;
    }

    protected void setBalance(double balance) { 
        this.balance = balance;
    }

    public void displayDetails() {
        System.out.println("Account Number: " + accountNumber);
        System.out.println("Holder Name: " + holderName);
        System.out.println("Balance: " + balance);
        System.out.println("Interest: " + calculateInterest());
    }
}

class SavingsAccount extends BankAccount implements Loanable {
    private double interestRate; // annual interest rate
    private double loanAmountApplied;

    public SavingsAccount(String accountNumber, String holderName, double balance, double interestRate) {
        super(accountNumber, holderName, balance);
        this.interestRate = interestRate;
    }

    @Override
    public double calculateInterest() {
        return getBalance() * interestRate / 100;
    }

    @Override
    public void applyForLoan(double amount) {
        this.loanAmountApplied = amount;
        System.out.println("SavingsAccount loan applied: " + amount);
    }

    @Override
    public boolean calculateLoanEligibility() {
        return getBalance() > 5000;
    }
}

class CurrentAccount extends BankAccount implements Loanable {
    private double overdraftLimit;
    private double loanAmountApplied;

    public CurrentAccount(String accountNumber, String holderName, double balance, double overdraftLimit) {
        super(accountNumber, holderName, balance);
        this.overdraftLimit = overdraftLimit;
    }

    @Override
    public double calculateInterest() {
        return getBalance() * 0.5 / 100;
    }

    @Override
    public void applyForLoan(double amount) {
        this.loanAmountApplied = amount;
        System.out.println("CurrentAccount loan applied: " + amount);
    }

    @Override
    public boolean calculateLoanEligibility() {
        return getBalance() + overdraftLimit > 10000;
    }
}

public class BankingSystem {
    public static void main(String[] args) {
        BankAccount[] accounts = new BankAccount[3];

        accounts[0] = new SavingsAccount("SA1001", "Alice", 10000, 4); // 4% interest
        accounts[1] = new CurrentAccount("CA2001", "Bob", 8000, 5000);
        accounts[2] = new SavingsAccount("SA1002", "Charlie", 4000, 3.5);

        for (BankAccount acc : accounts) {
            acc.displayDetails();
            acc.deposit(1000);
            acc.withdraw(500);

            if (acc instanceof Loanable) {
                Loanable loanAcc = (Loanable) acc;
                loanAcc.applyForLoan(2000);
                System.out.println("Loan Eligibility: " + loanAcc.calculateLoanEligibility());
            }

            System.out.println("---------------------------");
        }
    }
}
