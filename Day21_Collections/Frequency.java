import java.util.*;

public class Frequency {

    public static Map<String, Integer> countFrequency(List<String> list) {
        Map<String, Integer> frequencyMap = new HashMap<>();

        for (String item : list) {
            if (frequencyMap.containsKey(item)) {
                frequencyMap.put(item, frequencyMap.get(item) + 1);
            } else {
                frequencyMap.put(item, 1);
            }
        }

        return frequencyMap;
    }

    public static void main(String[] args) {

        List<String> items = Arrays.asList("apple", "banana", "apple", "orange");

        System.out.println("Input List: " + items);

        Map<String, Integer> result = countFrequency(items);

        System.out.println("Frequency Map: " + result);
    }
}

