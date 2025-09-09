class BankAccount {
    public int accountNumber;        
    protected String accountHolder;  
    private double balance;          
    BankAccount(int accountNumber, String accountHolder, double balance) {
        this.accountNumber = accountNumber;
        this.accountHolder = accountHolder;
        this.balance = balance;
    }

    public double getBalance() {    
        return balance;
    }

    public void setBalance(double balance) {
        this.balance = balance;
    }
}

class SavingsAccount extends BankAccount {
    double interestRate;

    SavingsAccount(int accountNumber, String accountHolder, double balance, double interestRate) {
        super(accountNumber, accountHolder, balance);
        this.interestRate = interestRate;
    }

    void displayDetails() {
        System.out.println("Account Number: " + accountNumber); 
        System.out.println("Account Holder: " + accountHolder); 
        System.out.println("Balance: " + getBalance());        
        System.out.println("Interest Rate: " + interestRate + "%");
    }

    public static void main(String[] args) {
        SavingsAccount acc = new SavingsAccount(12345, "Ayushi", 10000, 4.5);
        acc.displayDetails();
        acc.setBalance(12000);
        System.out.println("Updated Balance: " + acc.getBalance());
    }
}

