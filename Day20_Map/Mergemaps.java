import java.util.*;

public class Mergemaps {
    public static void main(String[] args) {

        Map<String, Integer> map1 = new HashMap<>();
        map1.put("a", 1);
        map1.put("b", 2);
        Map<String, Integer> map2 = new HashMap<>();
        map2.put("b", 3);
        map2.put("c", 4);
        Map<String, Integer> mergedMap = new HashMap<>(map1);
        for (Map.Entry<String, Integer> entry : map2.entrySet()) {
            String key = entry.getKey();
            Integer value = entry.getValue();
            mergedMap.put(key, mergedMap.getOrDefault(key, 0) + value);
        }
        System.out.println("Merged Map:");
        for (String key : mergedMap.keySet()) {
            System.out.println(key + " = " + mergedMap.get(key));
        }
    }
}
