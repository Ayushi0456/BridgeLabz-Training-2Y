import java.util.Scanner;

public class power {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        
        System.out.print("Enter a positive integer (base number): ");
        int number = sc.nextInt();

        System.out.print("Enter a positive integer (power): ");
        int power = sc.nextInt();

        
        if (number < 0 || power < 0) {
            System.out.println("Please enter positive integers only.");
            
        }

        
        int result = 1;

        
        for (int i = 1; i <= power; i++) {
            result = result * number; 
        }

    
        System.out.println(number + " raised to the power " + power + " is: " + result);

        sc.close();
    }
}

