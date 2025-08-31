import java.util.*;

public class rootsofquadraticeq{
    public static double[] findRoots(double a, double b, double c) {
        double delta = b*b - 4*a*c;
        if (delta < 0) return new double[0]; // no real roots
        else if (delta == 0) return new double[]{ -b / (2*a) };
        else {
            double root1 = (-b + Math.sqrt(delta)) / (2*a);
            double root2 = (-b - Math.sqrt(delta)) / (2*a);
            return new double[]{root1, root2};
        }
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter coefficients a, b, c: ");
        double a = sc.nextDouble(), b = sc.nextDouble(), c = sc.nextDouble();

        double[] roots = findRoots(a, b, c);
        if (roots.length == 0) System.out.println("No real roots");
        else {
            for (int i = 0; i < roots.length; i++)
                System.out.println("Root " + (i+1) + " = " + roots[i]);
                sc.close();
        }
    }
}

