import java.util.*;

public class EqualSets {
    public static void main(String[] args) {

        
        Set<Integer> set1 = new HashSet<>();
        Collections.addAll(set1, 1, 2, 3);

        Set<Integer> set2 = new HashSet<>();
        Collections.addAll(set2, 3, 2, 1);

        
        boolean areEqual = set1.equals(set2);
        System.out.println("Are the two sets equal? " + areEqual);
    }
}

