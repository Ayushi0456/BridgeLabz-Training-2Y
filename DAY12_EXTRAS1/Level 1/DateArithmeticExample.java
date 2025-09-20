import java.time.LocalDate;
import java.util.Scanner;

public class DateArithmeticExample {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        // Input date
        System.out.print("Enter date (yyyy-MM-dd): ");
        String input = sc.nextLine();

        // Parse input date
        LocalDate date = LocalDate.parse(input);

        // Add 7 days, 1 month, and 2 years
        LocalDate modifiedDate = date.plusDays(7)
                                     .plusMonths(1)
                                     .plusYears(2);

        System.out.println("After adding 7 days, 1 month, and 2 years: " + modifiedDate);

        // Subtract 3 weeks
        LocalDate finalDate = modifiedDate.minusWeeks(3);
        System.out.println("After subtracting 3 weeks: " + finalDate);

        sc.close();
    }
}

