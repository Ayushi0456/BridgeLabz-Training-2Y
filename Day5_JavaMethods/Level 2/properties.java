import java.util.*;

public class properties {
    public static boolean isPositive(int n) { return n > 0; }
    public static boolean isEven(int n) { return n % 2 == 0; }

    public static int compare(int a, int b) {
        if (a > b) return 1;
        else if (a < b) return -1;
        else return 0;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int[] arr = new int[5];

        for (int i = 0; i < 5; i++) {
            System.out.print("Enter number " + (i+1) + ": ");
            arr[i] = sc.nextInt();
        }

        for (int n : arr) {
            if (isPositive(n)) {
                System.out.print(n + " is Positive ");
                System.out.println(isEven(n) ? "Even" : "Odd");
            } else if (n < 0) {
                System.out.println(n + " is Negative");
            } else {
                System.out.println("0 is neither positive nor negative");
            }
        }

        int result = compare(arr[0], arr[4]);
        if (result == 0) System.out.println("First and last are equal");
        else if (result > 0) System.out.println("First > Last");
        else System.out.println("First < Last");
        sc.close();
    }
}

