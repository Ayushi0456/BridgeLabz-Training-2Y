import java.util.Scanner;

public class LexicographicalCompare {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.print("Enter String 1: ");
        String str1 = scanner.nextLine();

        System.out.print("Enter String 2: ");
        String str2 = scanner.nextLine();

        int minLength = Math.min(str1.length(), str2.length());
        boolean areEqual = true;

        for (int i = 0; i < minLength; i++) {
            char ch1 = str1.charAt(i);
            char ch2 = str2.charAt(i);

            if (ch1 != ch2) {
                areEqual = false;
                if (ch1 < ch2) {
                    System.out.println(str1 + " comes before " + str2 + " in lexicographical order.");
                } else {
                    System.out.println(str2 + " comes before " + str1 + " in lexicographical order.");
                }
                break;
            }
        }

        if (areEqual) {
            if (str1.length() == str2.length()) {
                System.out.println("Both strings are equal.");
            } else if (str1.length() < str2.length()) {
                System.out.println(str1 + " comes before " + str2 + " in lexicographical order.");
            } else {
                System.out.println(str2 + " comes before " + str1 + " in lexicographical order.");
            }
        }

        scanner.close();
    }
}

