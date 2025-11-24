import java.time.LocalDate;
import java.time.temporal.ChronoUnit;
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
    public String getCoverageType() { return coverageType; }

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

    
    public void getAllUniquePolicies() {
        System.out.println("\n--- All Unique Policies (From HashSet) ---");
        hashSetStore.forEach(System.out::println);
    }

    public void getPoliciesExpiringSoon() {
        System.out.println("\n--- Policies Expiring Within 30 Days ---");
        LocalDate today = LocalDate.now();

        boolean found = false;

        for (Policy p : treeSetStore) {
            long days = ChronoUnit.DAYS.between(today, p.getExpiryDate());
            if (days >= 0 && days <= 30) {
                System.out.println(p);
                found = true;
            }
        }

        if (!found)
            System.out.println("No policies expiring within 30 days.");
    }

    public void getPoliciesByCoverage(String type) {
        System.out.println("\n--- Policies with Coverage: " + type + " ---");

        boolean found = false;
        for (Policy p : hashSetStore) {
            if (p.getCoverageType().equalsIgnoreCase(type)) {
                System.out.println(p);
                found = true;
            }
        }

        if (!found)
            System.out.println("No policies found with coverage: " + type);
    }

    public void getDuplicatePolicies(List<Policy> allPolicies) {
        System.out.println("\n--- Duplicate Policies (By Policy Number) ---");

        Set<String> seen = new HashSet<>();
        Set<String> duplicates = new HashSet<>();

        for (Policy p : allPolicies) {
            if (!seen.add(p.getPolicyNumber())) {
                duplicates.add(p.getPolicyNumber());
            }
        }

        if (duplicates.isEmpty()) {
            System.out.println("No duplicates found.");
            return;
        }

        for (String dup : duplicates) {
            System.out.println("Duplicate Policy Number: " + dup);
        }
    }

    public void showTreeSet() {
        System.out.println("\n--- TreeSet (Sorted by Expiry Date) ---");
        treeSetStore.forEach(System.out::println);
    }
}

public class Policies {
    public static void main(String[] args) {

        PolicyManager manager = new PolicyManager();

        // Sample policies
        Policy p1 = new Policy("P101", "Ayushi",
                LocalDate.now().plusDays(10), "Health", 15000);

        Policy p2 = new Policy("P102", "Rohan",
                LocalDate.now().plusDays(40), "Auto", 9000);

        Policy p3 = new Policy("P103", "Simran",
                LocalDate.now().plusDays(20), "Home", 25000);

        Policy p4 = new Policy("P101", "DuplicateAyushi",
                LocalDate.now().plusDays(50), "Health", 15000); // duplicate number

        Policy p5 = new Policy("P104", "Mohit",
                LocalDate.now().plusDays(5), "Auto", 11000);

       
        manager.addPolicy(p1);
        manager.addPolicy(p2);
        manager.addPolicy(p3);
        manager.addPolicy(p5);

        List<Policy> listForDuplicates = Arrays.asList(p1, p2, p3, p4, p5);

        manager.getAllUniquePolicies();
        manager.getPoliciesExpiringSoon();
        manager.getPoliciesByCoverage("Auto");
        manager.getDuplicatePolicies(listForDuplicates);

        manager.showTreeSet();
    }
}

