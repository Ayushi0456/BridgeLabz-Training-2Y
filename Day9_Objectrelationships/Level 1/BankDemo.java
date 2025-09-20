import java.util.*;

class Account {
    private String accNo;
    private double balance;
    public Account(String accNo, double balance){ this.accNo = accNo; this.balance = balance; }
    public void deposit(double amt){ balance += amt; }
    public void withdraw(double amt){ balance -= amt; }
    public String toString(){ return accNo + " : " + balance; }
}

class BankCustomer {
    private String name;
    private List<Account> accounts = new ArrayList<>();
    public BankCustomer(String name){ this.name = name; }
    public void addAccount(Account a){ accounts.add(a); }
    public void listAccounts(){ System.out.println(name + " accounts: " + accounts); }
}

public class BankDemo {
    public static void main(String[] args){
        Account a1 = new Account("ACC1001", 5000);
        Account a2 = new Account("ACC1002", 12000);

        BankCustomer c = new BankCustomer("Sita");
        c.addAccount(a1);
        c.addAccount(a2);
        c.listAccounts();

    
        System.out.println("Standalone account: " + a1);
    }
}
