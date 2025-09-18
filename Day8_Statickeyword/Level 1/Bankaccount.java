class BankAccount {
    static String bankName = "State Bank of India";
    static int totalAccounts = 0;

    final int accountNumber;
    String accountHolderName;

   
    BankAccount(int accountNumber, String accountHolderName) {
        this.accountNumber = accountNumber;
        this.accountHolderName = accountHolderName;
        totalAccounts++;
    }

    static void getTotalAccounts() {
        System.out.println("Total Accounts: " + totalAccounts);
    }

    void displayAccountDetails() {
        if (this instanceof BankAccount) {
            System.out.println("Bank: " + bankName + ", Account No: " + accountNumber +
                               ", Holder: " + accountHolderName);
        }
    }

    public static void main(String[] args) {
        BankAccount a1 = new BankAccount(101, "Ayushi");
        BankAccount a2 = new BankAccount(102, "Rohit");
        a1.displayAccountDetails();
        a2.displayAccountDetails();
        BankAccount.getTotalAccounts();
    }
}

