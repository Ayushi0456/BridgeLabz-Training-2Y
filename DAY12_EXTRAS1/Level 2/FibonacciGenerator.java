import java.util.Scanner;

public class FibonacciGenerator {

    public static void generateFibonacci(int n) {
        if (n <= 0) {
            System.out.println("Number of terms must be positive.");
            return;
        }

        int first = 0, second = 1;

        System.out.print("Fibonacci sequence: ");
        for (int i = 1; i <= n; i++) {
            System.out.print(first + " ");
            int next = first + second;
            first = second;
            second = next;
        }
        System.out.println();
    }

    public static int getInput(Scanner sc) {
        System.out.print("Enter the number of Fibonacci terms to generate: ");
        return sc.nextInt();
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int n = getInput(sc);
        generateFibonacci(n);

        sc.close();
    }
}

