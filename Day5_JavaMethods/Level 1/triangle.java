import java.util.Scanner;

public class triangle{
    public static double calculateRounds(double a, double b, double c, double distance) {
        double perimeter = a + b + c;
        return distance / perimeter;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter 3 sides of triangular park: ");
        double a = sc.nextDouble(), b = sc.nextDouble(), c = sc.nextDouble();

        double rounds = calculateRounds(a, b, c, 5000);
        System.out.println("Number of rounds = " + rounds);
        sc.close();
    }
}

