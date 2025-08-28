import java.util.Scanner;

public class copy2dto1darray{
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.print("Enter rows: ");
        int rows = sc.nextInt();
        System.out.print("Enter columns: ");
        int cols = sc.nextInt();

        int[][] matrix = new int[rows][cols];
        int[] arr = new int[rows * cols];
        int index = 0;

        System.out.println("Enter elements of 2D array:");
        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < cols; j++) {
                matrix[i][j] = sc.nextInt();
                arr[index++] = matrix[i][j];
            }
        }

        System.out.println("1D Array elements:");
        for (int x : arr) System.out.print(x + " ");
        sc.close();
    }
}

