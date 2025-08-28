import java.util.Scanner;

public class factors {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter upper limit: ");
        int limit = sc.nextInt();

        int[] even = new int[limit];
        int[] odd = new int[limit];
        int e = 0, o = 0;

        for (int i = 1; i <= limit; i++) {
            if (i % 2 == 0) even[e++] = i;
            else odd[o++] = i;
        }

        System.out.print("Even numbers: ");
        for (int i = 0; i < e; i++) System.out.print(even[i] + " ");
        System.out.println();

        System.out.print("Odd numbers: ");
        for (int i = 0; i < o; i++) System.out.print(odd[i] + " ");
        sc.close();
    

    }
}

