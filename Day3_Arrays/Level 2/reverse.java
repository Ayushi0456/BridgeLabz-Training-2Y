import java.util.Scanner;

public class reverse {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.print("Enter a number: ");
        long number = sc.nextLong();


        long tempNumber = number;
        int count = 0;
        while (tempNumber != 0) {
            count++;
            tempNumber /= 10;
        }


        int[] digits = new int[count];
        tempNumber = number;
        for (int i = 0; i < count; i++) {
            digits[i] = (int)(tempNumber % 10);
            tempNumber /= 10;
        }

        
        int[] reversedDigits = new int[count];
        for (int i = 0; i < count; i++) {
            reversedDigits[i] = digits[count - 1 - i];
        }

        
        System.out.print("Reversed number: ");
        for (int i = 0; i < count; i++) {
            System.out.print(reversedDigits[i]);
        }
        System.out.println();
        sc.close();
    }
}

