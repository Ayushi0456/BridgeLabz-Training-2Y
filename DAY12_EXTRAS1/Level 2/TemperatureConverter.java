import java.util.Scanner;

public class TemperatureConverter {

    public static double celsiusToFahrenheit(double celsius) {
        return (celsius * 9 / 5) + 32;
    }

    public static double fahrenheitToCelsius(double fahrenheit) {
        return (fahrenheit - 32) * 5 / 9;
    }

    public static double getInput(Scanner sc, String prompt) {
        System.out.print(prompt);
        return sc.nextDouble();
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.println("Temperature Converter");
        System.out.println("1. Celsius to Fahrenheit");
        System.out.println("2. Fahrenheit to Celsius");
        System.out.print("Choose conversion (1 or 2): ");
        int choice = sc.nextInt();

        if (choice == 1) {
            double celsius = getInput(sc, "Enter temperature in Celsius: ");
            double fahrenheit = celsiusToFahrenheit(celsius);
            System.out.printf("%.2f Celsius = %.2f Fahrenheit%n", celsius, fahrenheit);
        } else if (choice == 2) {
            double fahrenheit = getInput(sc, "Enter temperature in Fahrenheit: ");
            double celsius = fahrenheitToCelsius(fahrenheit);
            System.out.printf("%.2f Fahrenheit = %.2f Celsius%n", fahrenheit, celsius);
        } else {
            System.out.println("Invalid choice. Please select 1 or 2.");
        }

        sc.close();
    }
}

