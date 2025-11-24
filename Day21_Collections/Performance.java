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
    public String getCoverageType() { return coverageType; }
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
        Policy p = (Policy) o;
        return Objects.equals(policyNumber, p.policyNumber);
    }

    @Override
    public int hashCode() {
        return Objects.hash(policyNumber);
    }
}

class ExpiryComparator implements Comparator<Policy> {
    public int compare(Policy p1, Policy p2) {
        int result = p1.getExpiryDate().compareTo(p2.getExpiryDate());
        if (result == 0)
            return p1.getPolicyNumber().compareTo(p2.getPolicyNumber());
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
        System.out.println("\n--- All Unique Policies ---");
        hashSetStore.forEach(System.out::println);
    }

    public void getPoliciesExpiringSoon() {
        System.out.println("\n--- Policies Expiring within 30 Days ---");
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
            System.out.println("None expiring soon.");
    }

    public void getPoliciesByCoverage(String type) {
        System.out.println("\n--- Policies with coverage: " + type + " ---");
        boolean found = false;

        for (Policy p : hashSetStore) {
            if (p.getCoverageType().equalsIgnoreCase(type)) {
                System.out.println(p);
                found = true;
            }
        }

        if (!found)
            System.out.println("No policies found for coverage: " + type);
    }

    public void getDuplicatePolicies(List<Policy> list) {
        System.out.println("\n--- Duplicate Policies (By Policy Number) ---");

        Set<String> seen = new HashSet<>();
        Set<String> duplicates = new HashSet<>();

        for (Policy p : list) {
            if (!seen.add(p.getPolicyNumber())) {
                duplicates.add(p.getPolicyNumber());
            }
        }

        if (duplicates.isEmpty())
            System.out.println("No duplicates found.");
        else
            duplicates.forEach(d -> System.out.println("Duplicate: " + d));
    }


    public void comparePerformance() {
        System.out.println("\n================ Performance Comparison ================\n");

        int TEST_SIZE = 100000;  
        List<Policy> sampleList = new ArrayList<>();

        for (int i = 1; i <= TEST_SIZE; i++) {
            sampleList.add(new Policy("ID" + i, "Name" + i,
                    LocalDate.now().plusDays(i % 365), "Health", 5000 + i));
        }

        long start = System.nanoTime();
        Set<Policy> hash = new HashSet<>(sampleList);
        long hashAdd = System.nanoTime() - start;

        start = System.nanoTime();
        hash.contains(sampleList.get(TEST_SIZE / 2));
        long hashSearch = System.nanoTime() - start;

        start = System.nanoTime();
        hash.remove(sampleList.get(TEST_SIZE / 2));
        long hashRemove = System.nanoTime() - start;


        start = System.nanoTime();
        Set<Policy> linked = new LinkedHashSet<>(sampleList);
        long linkedAdd = System.nanoTime() - start;

        start = System.nanoTime();
        linked.contains(sampleList.get(TEST_SIZE / 2));
        long linkedSearch = System.nanoTime() - start;

        start = System.nanoTime();
        linked.remove(sampleList.get(TEST_SIZE / 2));
        long linkedRemove = System.nanoTime() - start;


        start = System.nanoTime();
        Set<Policy> tree = new TreeSet<>(new ExpiryComparator());
        tree.addAll(sampleList);
        long treeAdd = System.nanoTime() - start;

        start = System.nanoTime();
        tree.contains(sampleList.get(TEST_SIZE / 2));
        long treeSearch = System.nanoTime() - start;

        start = System.nanoTime();
        tree.remove(sampleList.get(TEST_SIZE / 2));
        long treeRemove = System.nanoTime() - start;


        
        System.out.println("Operation        HashSet     LinkedHashSet     TreeSet");
        System.out.println("---------------------------------------------------------------");
        System.out.println("Add (ns)       " + hashAdd + "     " + linkedAdd + "     " + treeAdd);
        System.out.println("Search (ns)    " + hashSearch + "     " + linkedSearch + "     " + treeSearch);
        System.out.println("Remove (ns)    " + hashRemove + "     " + linkedRemove + "     " + treeRemove);

        System.out.println("\n---------------------------------------------------------------");
        System.out.println("FASTEST SUMMARY:");
        System.out.println("• HashSet = Fastest for Adding, Searching & Removing");
        System.out.println("• LinkedHashSet = Slightly slower, but preserves insertion order");
        System.out.println("• TreeSet = Slowest (sorted structure), but provides ordering");
        System.out.println("---------------------------------------------------------------");
    }
}

public class Performance {
    public static void main(String[] args) {

        PolicyManager manager = new PolicyManager();

        Policy p1 = new Policy("P101", "Ayushi",
                LocalDate.now().plusDays(10), "Health", 15000);

        Policy p2 = new Policy("P102", "Rohan",
                LocalDate.now().plusDays(40), "Auto", 9000);

        Policy p3 = new Policy("P103", "Simran",
                LocalDate.now().plusDays(20), "Home", 25000);

        Policy p4 = new Policy("P101", "Duplicate", 
                LocalDate.now().plusDays(100), "Health", 15000);

        Policy p5 = new Policy("P104", "Mohit",
                LocalDate.now().plusDays(5), "Auto", 11000);

        manager.addPolicy(p1);
        manager.addPolicy(p2);
        manager.addPolicy(p3);
        manager.addPolicy(p5);

        List<Policy> list = Arrays.asList(p1, p2, p3, p4, p5);

        manager.getAllUniquePolicies();
        manager.getPoliciesExpiringSoon();
        manager.getPoliciesByCoverage("Auto");
        manager.getDuplicatePolicies(list);

       
        manager.comparePerformance();
    }
}

