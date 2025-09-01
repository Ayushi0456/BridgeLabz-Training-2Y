import java.util.Scanner;

public class using{
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter starting number: ");
        int count = sc.nextInt();

        for (int i = count; i >= 1; i--) {
            System.out.println(i);
        }
        System.out.println("Lift Off!");

        sc.close();
    }
}

