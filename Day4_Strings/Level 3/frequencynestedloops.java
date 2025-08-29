import java.util.Scanner;

public class frequencynestedloops{

    public static String[] findFrequency(String text) {
        char[] chars = text.toCharArray();
        int n = chars.length;
        int[] freq = new int[n];

        
        for (int i = 0; i < n; i++) {
            freq[i] = 1;
        }


        for (int i = 0; i < n; i++) {
            if (chars[i] == '0') continue; 
            for (int j = i + 1; j < n; j++) {
                if (chars[i] == chars[j]) {
                    freq[i]++;
                    chars[j] = '0'; 
                }
            }
        }

    
        int uniqueCount = 0;
        for (int i = 0; i < n; i++) {
            if (chars[i] != '0') {
                uniqueCount++;
            }
        }

        
        String[] result = new String[uniqueCount];
        int index = 0;

        for (int i = 0; i < n; i++) {
            if (chars[i] != '0') {
                result[index++] = chars[i] + " -> " + freq[i];
            }
        }
        return result;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.print("Enter a string: ");
        String text = sc.nextLine();

        String[] result = findFrequency(text);

        System.out.println("Character Frequencies:");
        for (String s : result) {
            System.out.println(s);
        }

        sc.close();
    }
}

