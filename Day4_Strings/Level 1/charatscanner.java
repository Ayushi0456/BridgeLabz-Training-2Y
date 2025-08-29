import java.util.Scanner;

public class charatscanner {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String text = "Example";

        System.out.println("The string is: " + text);
        System.out.print("Enter an index to get the character: ");
        
        try {
            int index = scanner.nextInt();
            char character = text.charAt(index);
            System.out.println("Character at index " + index + " is: " + character);
        } catch (StringIndexOutOfBoundsException e) {
            System.out.println("Error: The index you entered is out of bounds for the string. Please enter a number between 0 and " + (text.length() - 1));
        } catch (Exception e) {
            System.out.println("Invalid input. Please enter a valid number.");
        } finally {
            scanner.close();
        }
    }
}
