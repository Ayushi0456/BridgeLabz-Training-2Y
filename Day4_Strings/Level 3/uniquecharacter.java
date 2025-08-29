import java.util.Scanner;

public class uniquecharacter {

    
    public static int getLength(String text) {
        int count = 0;
        try {
            while (true) {
                text.charAt(count);
                count++;
            }
        } catch (Exception e) {
            
        }
        return count;
    }


    public static char[] findUniqueCharacters(String text) {
        int n = getLength(text);
        char[] result = new char[n];
        int resultIndex = 0;

        for (int i = 0; i < n; i++) {
            char current = text.charAt(i);
            boolean isUnique = true;

            
            for (int j = 0; j < i; j++) {
                if (current == text.charAt(j)) {
                    isUnique = false;
                    break;
                }
            }

            if (isUnique) {
                result[resultIndex++] = current;
            }
        }


        char[] uniqueChars = new char[resultIndex];
        for (int i = 0; i < resultIndex; i++) {
            uniqueChars[i] = result[i];
        }

        return uniqueChars;
    }

    
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.println("Enter a string: ");
        String text = sc.nextLine();

        char[] unique = findUniqueCharacters(text);

        System.out.print("Unique characters: ");
        for (char c : unique) {
            System.out.print(c + " ");
        }

        sc.close();
    }
}

