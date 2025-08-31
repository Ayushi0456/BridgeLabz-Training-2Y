import java.util.*;

public class naturalnumbersum {
    public static int sumFormula(int n) {
        return n * (n + 1) / 2;
    }

    public static int sumRecursion(int n) {
        if (n == 0) return 0;
        return n + sumRecursion(n - 1);
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter n: ");
        int n = sc.nextInt();

        System.out.println("Sum using formula = " + sumFormula(n));
        System.out.println("Sum using recursion = " + sumRecursion(n));
        sc.close();
    }
}
