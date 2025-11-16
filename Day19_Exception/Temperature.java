import java.util.Scanner;

class InvalidTemperatureException extends Exception {
    public InvalidTemperatureException(String msg) {
        super(msg);
    }
}

public class Temperature {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        try {
            System.out.print("Enter temperature value: ");
            double temp = sc.nextDouble();

            System.out.print("Enter unit (C/F): ");
            char unit = sc.next().toUpperCase().charAt(0);

            double result = convertTemperature(temp, unit);
            System.out.println("Converted Temperature: " + result);

        } catch (InvalidTemperatureException e) {
            System.out.println(e.getMessage());
        }
        sc.close();
    }

    public static double convertTemperature(double temp, char unit)
            throws InvalidTemperatureException {

        if (unit == 'C' && temp < -273.15)
            throw new InvalidTemperatureException("Error: Temperature below absolute zero is not possible!");

        if (unit == 'F' && temp < -459.67)
            throw new InvalidTemperatureException("Error: Temperature below absolute zero is not possible!");

        if (unit == 'C')
            return (temp * 9 / 5) + 32;

        else if (unit == 'F')
            return (temp - 32) * 5 / 9;

        else
            throw new InvalidTemperatureException("Invalid unit entered!");
    
                 
}
}

