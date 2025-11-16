import java.util.*;

public class Wordcount {
    public static void main(String[] args) {

        String sentence = "Java is fun and Java is powerful.";
        sentence = sentence.toLowerCase().replaceAll("[^a-z0-9 ]", " ");
        String[] words = sentence.split("\\s+");
        Map<String, Integer> wordCount = new HashMap<>();
        for (String word : words) {
            if (word.length() == 0) continue;  
            wordCount.put(word, wordCount.getOrDefault(word, 0) + 1);
        }

        
        System.out.println("Word Frequencies:");
        for (Map.Entry<String, Integer> entry : wordCount.entrySet()) {
            System.out.println(entry.getKey() + " = " + entry.getValue());
        }
    }
}
