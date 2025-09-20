import java.util.Scanner;

public class MostFrequentCharacter {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.print("Enter a string: ");
        String input = scanner.nextLine();

        input = input.toLowerCase();

        int[] freq = new int[256]; 

        for (int i = 0; i < input.length(); i++) {
            char ch = input.charAt(i);
            freq[ch]++;
        }

        int max = -1;
        char mostFrequent = ' ';

        for (int i = 0; i < input.length(); i++) {
            if (freq[input.charAt(i)] > max) {
                max = freq[input.charAt(i)];
                mostFrequent = input.charAt(i);
            }
        }

        System.out.println("Most frequent character is: " + mostFrequent);

        scanner.close();
    }
}

