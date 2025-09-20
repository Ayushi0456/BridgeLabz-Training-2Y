import java.util.Random;
import java.util.Scanner;

public class NumberGuessingGame {

    // Function to generate a random guess within range
    public static int generateGuess(int low, int high) {
        Random rand = new Random();
        return rand.nextInt(high - low + 1) + low;
    }

    // Function to get feedback from the user
    public static String getFeedback(Scanner sc, int guess) {
        System.out.println("Is your number " + guess + "?");
        System.out.print("Enter 'low' if my guess is too low, 'high' if too high, or 'correct' if I guessed it: ");
        return sc.nextLine().trim().toLowerCase();
    }

    // Function to update bounds based on feedback
    public static int[] updateRange(int low, int high, int guess, String feedback) {
        if (feedback.equals("low")) {
            low = guess + 1;
        } else if (feedback.equals("high")) {
            high = guess - 1;
        }
        return new int[]{low, high};
    }

    // Main function to run the game
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int low = 1, high = 100;
        boolean correct = false;

        System.out.println("Think of a number between 1 and 100, and I will try to guess it!");

        while (!correct && low <= high) {
            int guess = generateGuess(low, high);
            String feedback = getFeedback(sc, guess);

            if (feedback.equals("correct")) {
                System.out.println("Yay! I guessed your number correctly: " + guess);
                correct = true;
            } else if (feedback.equals("low") || feedback.equals("high")) {
                int[] updatedRange = updateRange(low, high, guess, feedback);
                low = updatedRange[0];
                high = updatedRange[1];
            } else {
                System.out.println("Invalid input. Please enter 'low', 'high', or 'correct'.");
            }
        }

        if (!correct) {
            System.out.println("Something went wrong! Maybe your hints were inconsistent?");
        }

        sc.close();
    }
}
