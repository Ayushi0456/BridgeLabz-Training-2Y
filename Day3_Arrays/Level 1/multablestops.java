import java.util.Scanner;

public class multablestops{
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        while (true) {
            System.out.print("Enter a number (negative to stop): ");
            int num = sc.nextInt();
            if (num < 0) break;

            for (int i = 1; i <= 10; i++) {
                System.out.println(num + " x " + i + " = " + (num * i));
            }
        }
    }
}

