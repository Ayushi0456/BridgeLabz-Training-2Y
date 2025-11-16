import java.util.*;

public class Banking {

    public static void main(String[] args) {

        HashMap<String, Double> accounts = new HashMap<>();

        accounts.put("ACC101", 50000.0);
        accounts.put("ACC102", 30000.0);
        accounts.put("ACC103", 75000.0);
        accounts.put("ACC104", 120000.0);
        accounts.put("ACC105", 45000.0);
        accounts.put("ACC106", 90000.0);

        deposit(accounts, "ACC101", 5000);
        withdraw(accounts, "ACC102", 10000);
        withdraw(accounts, "ACC105", 60000); 
        deposit(accounts, "ACC103", 25000);
        withdraw(accounts, "ACC104", 50000);

        System.out.println("\nAll Customers Sorted by Balance (High → Low):");
        printSorted(accounts);

        System.out.println("\nTop 3 Customers with Highest Balance:");
        printTopThree(accounts);
    }

    public static void deposit(HashMap<String, Double> map, String acc, double amount) {
        if (map.containsKey(acc)) {
            map.put(acc, map.get(acc) + amount);
            System.out.println("Deposited Rs. " + amount + " to " + acc);
        } else {
            System.out.println("Account not found: " + acc);
        }
    }

    public static void withdraw(HashMap<String, Double> map, String acc, double amount) {
        if (map.containsKey(acc)) {
            double balance = map.get(acc);
            if (amount <= balance) {
                map.put(acc, balance - amount);
                System.out.println("Withdrawn Rs. " + amount + " from " + acc);
            } else {
                System.out.println("Withdrawal failed! Insufficient balance in " + acc);
            }
        } else {
            System.out.println("Account not found: " + acc);
        }
    }

    public static void printSorted(HashMap<String, Double> map) {
        List<Map.Entry<String, Double>> list = new ArrayList<>(map.entrySet());

        list.sort((a, b) -> Double.compare(b.getValue(), a.getValue()));

        for (Map.Entry<String, Double> entry : list) {
            System.out.println(entry.getKey() + " → Rs. " + entry.getValue());
        }
    }

    public static void printTopThree(HashMap<String, Double> map) {
        List<Map.Entry<String, Double>> list = new ArrayList<>(map.entrySet());

        list.sort((a, b) -> Double.compare(b.getValue(), a.getValue()));

        int count = Math.min(3, list.size());

        for (int i = 0; i < count; i++) {
            Map.Entry<String, Double> entry = list.get(i);
            System.out.println((i + 1) + ". " + entry.getKey() + " → Rs. " + entry.getValue());
        }
    }
}
