import java.util.Scanner;

public class trignometry {
    public static double[] calculateTrigonometricFunctions(double angleDegrees) {
        double radians = Math.toRadians(angleDegrees);
        double sin = Math.sin(radians);
        double cos = Math.cos(radians);
        double tan = Math.tan(radians);
        return new double[]{sin, cos, tan};
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter angle in degrees: ");
        double angle = sc.nextDouble();

        double[] res = calculateTrigonometricFunctions(angle);
        System.out.println("Sin = " + res[0] + ", Cos = " + res[1] + ", Tan = " + res[2]);
        sc.close();
    }
}

