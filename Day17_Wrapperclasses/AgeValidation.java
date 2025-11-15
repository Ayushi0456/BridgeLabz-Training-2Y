import java.util.Scanner;

public class AgeValidation {

    public static boolean isValidAge(String ageInput) {
        try {
            int age = Integer.parseInt(ageInput); 
            if (age >= 18) {
                return true;
            } else {
                return false;
            }

        } catch (NumberFormatException e) {
            return false;
        }
    }

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        System.out.print("Enter your age: ");
        String userInput = sc.nextLine();

        if (isValidAge(userInput)) {
            System.out.println("Valid age! Signup allowed.");
        } else {
            System.out.println("Invalid age! Signup denied.");
        }

        sc.close();
    }
}

