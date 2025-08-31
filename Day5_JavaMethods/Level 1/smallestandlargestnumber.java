import java.util.Scanner;

public class smallestandlargestnumber{
    public static int[] findSmallestAndLargest(int a, int b, int c) {
        int smallest = Math.min(a, Math.min(b, c));
        int largest = Math.max(a, Math.max(b, c));
        return new int[]{smallest, largest};
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter 3 numbers: ");
        int x = sc.nextInt(), y = sc.nextInt(), z = sc.nextInt();

        int[] res = findSmallestAndLargest(x, y, z);
        System.out.println("Smallest = " + res[0] + ", Largest = " + res[1]);
        sc.close();
    }
}

