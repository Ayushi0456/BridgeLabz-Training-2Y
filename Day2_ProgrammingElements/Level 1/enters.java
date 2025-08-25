import java.util.Scanner;

public class enters {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int sum = 0, val;

        while (true) {
            System.out.print("Enter number (0 to stop): ");
            val = sc.nextInt();
            if (val == 0) break;
            sum += val;
        }

        System.out.println("Total sum = " + sum);
        sc.close();
    }
}

