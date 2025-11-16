import java.io.*;
import java.util.*;

public class wordfrequency {
    public static void main(String[] args) {
        String fileName = "input.txt";
        HashMap<String, Integer> wordCount = new HashMap<>();

        try {
            BufferedReader br = new BufferedReader(new FileReader(fileName));
            String line;

            while ((line = br.readLine()) != null) {
                line = line.toLowerCase().replaceAll("[^a-z0-9 ]", " ");

                String[] words = line.split("\\s+");

                for (String word : words) {
                    if (word.length() == 0) continue;
                    wordCount.put(word, wordCount.getOrDefault(word, 0) + 1);
                }
            }

            br.close();

        } catch (IOException e) {
            System.out.println("Error reading file: " + e.getMessage());
        }
        System.out.println("Word Frequency:");
        for (String word : wordCount.keySet()) {
            System.out.println(word + " = " + wordCount.get(word));
        }
    }
}
