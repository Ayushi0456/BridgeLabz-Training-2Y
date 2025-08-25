import java.util.Scanner;

public class fizzbuzzwhile {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.print("Enter a positive integer: ");

    
        if (scanner.hasNextInt()) {
            int number = scanner.nextInt();

        
            if (number > 0) {
                System.out.println("FizzBuzz in binary up to " + number + ":");

                
                for (int i = 1; i <= number; i++) {
                    if (i % 3 == 0 && i % 5 == 0) {
                        System.out.println("FizzBuzz");
                    } else if (i % 3 == 0) {
                        System.out.println("Fizz");
                    } else if (i % 5 == 0) {
                        System.out.println("Buzz");
                    } else {
                        // Print number in binary
                        System.out.println(Integer.toBinaryString(i));
                    }
                }
            } else {
                System.out.println("Error: Please enter a positive integer.");
            }
        } else {
            System.out.println("Error: Invalid input. Please enter an integer.");
        }

        scanner.close();
    }
}

    

