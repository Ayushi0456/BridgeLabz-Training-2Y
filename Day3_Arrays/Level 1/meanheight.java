import java.util.Scanner;

public class meanheight {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter number of players: ");
        int n = sc.nextInt();

        double[] height = new double[n];
        double sum = 0;
        for (int i = 0; i < n; i++) {
            System.out.print("Enter height of player " + (i + 1) + ": ");
            height[i] = sc.nextDouble();
            sum += height[i];
        }

        double mean = sum / n;
        System.out.println("Mean height = " + mean);
    }
}

