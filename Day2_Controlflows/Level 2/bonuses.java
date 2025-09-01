import java.util.Scanner;

public class bonuses {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        
        System.out.print("Enter your salary: ");
        double salary = sc.nextDouble();

        System.out.print("Enter your years of service: ");
        int yearsOfService = sc.nextInt();

        
        double bonus = 0;

        if (yearsOfService > 5) {
            bonus = salary * 0.05; 
            System.out.println("You are eligible for a bonus.");
        } else {
            System.out.println("You are not eligible for a bonus.");
        }

        
        if (bonus > 0) {
            System.out.println("Your bonus amount is: " + bonus);
        }

        sc.close();
    }
}

