import java.util.Scanner;

public class large {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter three numbers: ");
        int a = sc.nextInt(), b = sc.nextInt(), c = sc.nextInt();

        System.out.println("Is first the largest? " + (a > b && a > c));
        System.out.println("Is second the largest? " + (b > a && b > c));
        System.out.println("Is third the largest? " + (c > a && c > b));

        sc.close();
    }
}

