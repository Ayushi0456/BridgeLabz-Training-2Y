import java.util.Scanner;

public class frequency {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

    
        System.out.print("Enter a number: ");
        long number = sc.nextLong();

    
        long temp = number;
        int count = 0;
        while (temp != 0) {
            count++;
            temp /= 10;
        }


        int[] digits = new int[count];
        temp = number;
        for (int i = 0; i < count; i++) {
            digits[i] = (int)(temp % 10);
            temp /= 10;
        }

        
        int[] frequency = new int[10];

        
        for (int i = 0; i < count; i++) {
            frequency[digits[i]]++;
        }


        System.out.println("\nDigit\tFrequency");
        System.out.println("----------------");
        for (int i = 0; i < 10; i++) {
            if (frequency[i] > 0) {
                System.out.println(i + "\t" + frequency[i]);
                sc.close();
            }
        }
    }
}

