import java.util.Scanner;

public class quotientandremainder {
    public static int[] findRemainderAndQuotient(int num, int divisor) {
        int quotient = num / divisor;
        int remainder = num % divisor;
        return new int[]{quotient, remainder};
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter number and divisor: ");
        int num = sc.nextInt(), div = sc.nextInt();

        int[] res = findRemainderAndQuotient(num, div);
        System.out.println("Quotient = " + res[0] + ", Remainder = " + res[1]);
        sc.close();
    }
}

