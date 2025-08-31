import java.util.*;

public class yardstofeet {
    public static double yardsToFeet(double yards) { return yards * 3; }
    public static double feetToYards(double feet) { return feet * 0.333333; }
    public static double metersToInches(double meters) { return meters * 39.3701; }
    public static double inchesToMeters(double inches) { return inches * 0.0254; }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter yards: ");
        double y = sc.nextDouble();
        System.out.println(y + " yards = " + yardsToFeet(y) + " feet");
        sc.close();
    }
}

