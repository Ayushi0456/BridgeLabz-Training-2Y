import java.util.Scanner;

public class CharacterWrapperUseCase {
    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        System.out.print("Enter a string: ");
        String input = sc.nextLine();

        int totalLetters = 0;
        int totalDigits = 0;
        int totalSpecial = 0;

        for (char ch : input.toCharArray()) {

            if (Character.isLetter(ch)) {
                totalLetters++;
            } 
            else if (Character.isDigit(ch)) {
                totalDigits++;
            } 
            else if (Character.isWhitespace(ch)) {
            } 
            else {
                totalSpecial++;
            }
        }

        System.out.println("Total Letters: " + totalLetters);
        System.out.println("Total Digits: " + totalDigits);
        System.out.println("Total Special Characters: " + totalSpecial);

        sc.close();
    }
}

