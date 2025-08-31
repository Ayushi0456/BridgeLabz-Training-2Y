import java.util.*;

public class unitconverter {
    public static double kmToMiles(double km) { return km * 0.621371; }
    public static double milesToKm(double miles) { return miles * 1.60934; }
    public static double metersToFeet(double meters) { return meters * 3.28084; }
    public static double feetToMeters(double feet) { return feet * 0.3048; }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter kilometers: ");
        double km = sc.nextDouble();
        System.out.println(km + " km = " + kmToMiles(km) + " miles");
        sc.close();
    }
}

