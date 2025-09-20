import java.util.Scanner;

public class RemoveCharacter {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.print("Enter the string: ");
        String input = scanner.nextLine();

        System.out.print("Enter the character to remove: ");
        char chToRemove = scanner.next().charAt(0);

        String result = "";

        for (int i = 0; i < input.length(); i++) {
            if (input.charAt(i) != chToRemove) {
                result += input.charAt(i);
            }
        }

        System.out.println("Modified string: " + result);

        scanner.close();
    }
}

