import java.time.LocalDate;
import java.util.*;

class Policy {
    private String policyNumber;
    private String holderName;
    private LocalDate expiryDate;
    private String coverageType;
    private double premiumAmount;

    public Policy(String policyNumber, String holderName, LocalDate expiryDate,
                  String coverageType, double premiumAmount) {
        this.policyNumber = policyNumber;
        this.holderName = holderName;
        this.expiryDate = expiryDate;
        this.coverageType = coverageType;
        this.premiumAmount = premiumAmount;
    }

    public String getPolicyNumber() { return policyNumber; }
    public String getHolderName() { return holderName; }
    public LocalDate getExpiryDate() { return expiryDate; }

    @Override
    public String toString() {
        return "Policy{" +
                "No='" + policyNumber + '\'' +
                ", Name='" + holderName + '\'' +
                ", Expiry=" + expiryDate +
                ", Coverage='" + coverageType + '\'' +
                ", Premium=" + premiumAmount +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        Policy policy = (Policy) o;
        return Objects.equals(policyNumber, policy.policyNumber);
    }

    @Override
    public int hashCode() {
        return Objects.hash(policyNumber);
    }
}

class ExpiryComparator implements Comparator<Policy> {
    @Override
    public int compare(Policy p1, Policy p2) {
        int result = p1.getExpiryDate().compareTo(p2.getExpiryDate());
        if (result == 0) {
            return p1.getPolicyNumber().compareTo(p2.getPolicyNumber());
        }
        return result;
    }
}

class PolicyManager {

    Set<Policy> hashSetStore = new HashSet<>();

    Set<Policy> linkedHashSetStore = new LinkedHashSet<>();

    Set<Policy> treeSetStore = new TreeSet<>(new ExpiryComparator());

    public void addPolicy(Policy p) {
        hashSetStore.add(p);
        linkedHashSetStore.add(p);
        treeSetStore.add(p);
    }

    public void showHashSet() {
        System.out.println("\n--- HashSet (Fast Lookup, No Order) ---");
        hashSetStore.forEach(System.out::println);
    }

    public void showLinkedHashSet() {
        System.out.println("\n--- LinkedHashSet (Insertion Order) ---");
        linkedHashSetStore.forEach(System.out::println);
    }

    public void showTreeSet() {
        System.out.println("\n--- TreeSet (Sorted by Expiry Date) ---");
        treeSetStore.forEach(System.out::println);
    }
}

public class InsuranceSystem {
    public static void main(String[] args) {

        PolicyManager manager = new PolicyManager();

        Policy p1 = new Policy("P101", "Ayushi",
                LocalDate.of(2025, 6, 10), "Health", 15000);

        Policy p2 = new Policy("P102", "Rohan",
                LocalDate.of(2024, 12, 5), "Auto", 9000);

        Policy p3 = new Policy("P103", "Simran",
                LocalDate.of(2026, 3, 18), "Home", 25000);

        Policy p4 = new Policy("P104", "Mohit",
                LocalDate.of(2025, 1, 20), "Health", 11000);

       
        manager.addPolicy(p1);
        manager.addPolicy(p2);
        manager.addPolicy(p3);
        manager.addPolicy(p4);

       
        manager.showHashSet();
        manager.showLinkedHashSet();
        manager.showTreeSet();
    }
}

