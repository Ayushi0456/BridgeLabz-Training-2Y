import java.util.Scanner;

public class small{
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter three numbers: ");
        int a = sc.nextInt(), b = sc.nextInt(), c = sc.nextInt();

        if (a < b && a < c)
            System.out.println("First number is the smallest.");
        else
            System.out.println("First number is not the smallest.");

        sc.close();
    }
}

    

