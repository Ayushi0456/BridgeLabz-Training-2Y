import java.util.Scanner;

public class countdown {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter starting number: ");
        int count = sc.nextInt();

        while (count >= 1) {
            System.out.println(count);
            count--;
        }
        System.out.println("Lift Off!");

        sc.close();
    }
}

