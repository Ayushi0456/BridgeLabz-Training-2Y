import java.util.*;

public class Invertmap {

    public static void main(String[] args) {

        Map<String, Integer> originalMap = new HashMap<>();
        originalMap.put("a", 1);
        originalMap.put("b", 2);
        originalMap.put("c", 1);
        Map<Integer, List<String>> invertedMap = new HashMap<>();

        for (Map.Entry<String, Integer> entry : originalMap.entrySet()) {
            String key = entry.getKey();
            Integer value = entry.getValue();
            if (!invertedMap.containsKey(value)) {
                invertedMap.put(value, new ArrayList<>());
            }
            invertedMap.get(value).add(key);
        }
        System.out.println("Inverted Map:");
        for (Integer value : invertedMap.keySet()) {
            System.out.println(value + " = " + invertedMap.get(value));
        }
    }
}

