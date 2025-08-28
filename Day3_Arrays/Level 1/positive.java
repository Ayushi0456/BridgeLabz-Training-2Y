import java.util.Scanner;

public class positive {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int[] arr = new int[5];

        for (int i = 0; i < arr.length; i++) {
            System.out.print("Enter number " + (i + 1) + ": ");
            arr[i] = sc.nextInt();

            if (arr[i] > 0)
                System.out.println(arr[i] + " is Positive");
            else if (arr[i] < 0)
                System.out.println(arr[i] + " is Negative");
            else
                System.out.println(arr[i] + " is Zero");

            if (arr[i] % 2 == 0)
                System.out.println(arr[i] + " is Even");
            else
                System.out.println(arr[i] + " is Odd");
        }

        if (arr[0] > arr[arr.length - 1])
            System.out.println("First element is greater than last element");
        else if (arr[0] < arr[arr.length - 1])
            System.out.println("Last element is greater than first element");
        else
            System.out.println("Both elements are equal");
    }
}

