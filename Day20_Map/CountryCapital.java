import java.util.*;

public class CountryCapital {
    public static void main(String[] args) {
        Map<String, String> map = new HashMap<>();

        map.put("India", "New Delhi");
        map.put("USA", "Washington D.C.");
        map.put("Japan", "Tokyo");
        map.put("France", "Paris");
        map.put("Germany", "Berlin");
        map.put("China", "Beijing");
        map.put("Canada", "Ottawa");
        map.put("Australia", "Canberra");

        Scanner sc = new Scanner(System.in);

        System.out.print("Enter a country name to find its capital: ");
        String country = sc.nextLine().trim();

        if (map.containsKey(country)) {
            System.out.println("Capital of " + country + " is: " + map.get(country));
        } else {
            System.out.println("Unknown country!");
        }

        System.out.println("\nAll Countries & Capitals (Sorted Alphabetically):");

        TreeMap<String, String> sorted = new TreeMap<>(map);

        for (Map.Entry<String, String> entry : sorted.entrySet()) {
            System.out.println(entry.getKey() + " --> " + entry.getValue());
        }

        sc.close();
    }
}

