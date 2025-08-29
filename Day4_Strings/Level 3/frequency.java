import java.util.Scanner;

public class frequency {

    
    public static String[][] findFrequency(String text) {
        int[] freq = new int[256]; 
        int n = text.length();

    
        for (int i = 0; i < n; i++) {
            freq[text.charAt(i)]++;
        }

        
        int uniqueCount = 0;
        for (int i = 0; i < 256; i++) {
            if (freq[i] > 0) uniqueCount++;
        }

    
        String[][] result = new String[uniqueCount][2];
        int index = 0;

        for (int i = 0; i < n; i++) {
            char c = text.charAt(i);
            if (freq[c] > 0) {
                result[index][0] = String.valueOf(c);
                result[index][1] = String.valueOf(freq[c]);
                freq[c] = 0; 
                index++;
            }
        }
        return result;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.print("Enter a string: ");
        String text = sc.nextLine();

        String[][] freqArray = findFrequency(text);

        System.out.println("Character   Frequency");
        for (int i = 0; i < freqArray.length; i++) {
            System.out.println("    " + freqArray[i][0] + "   --------->   " + freqArray[i][1]);
        }

        sc.close();
    }
}

