import java.util.Scanner;

public class sum {

    
    public static int countDigits(int number) {
        int count = 0;
        int n = number;
        if (n == 0) return 1; 
        while (n != 0) {
            n /= 10;
            count++;
        }
        return count;
    }

    
    public static int[] storeDigits(int number) {
        int count = countDigits(number);
        int[] digits = new int[count];
        int n = number;
        for (int i = count - 1; i >= 0; i--) {
            digits[i] = n % 10;
            n /= 10;
        }
        return digits;
    }

    public static int sumOfDigits(int[] digits) {
        int sum = 0;
        for (int d : digits) {
            sum += d;
        }
        return sum;
    }

   
    public static int sumOfSquares(int[] digits) {
        int sum = 0;
        for (int d : digits) {
            sum += Math.pow(d, 2); 
        }
        return sum;
    }

    
    public static boolean isHarshadNumber(int number, int[] digits) {
        int sum = sumOfDigits(digits);
        return sum != 0 && number % sum == 0;
    }

    
    public static int[][] digitFrequency(int[] digits) {
        int[][] freq = new int[10][2];
        for (int i = 0; i < 10; i++) {
            freq[i][0] = i;
            freq[i][1] = 0; 
        }
        for (int d : digits) {
            freq[d][1]++;
        }
        return freq;
    }


    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter a number: ");
        int number = sc.nextInt();

        
        int[] digits = storeDigits(number);

    
        System.out.println("Number of digits: " + countDigits(number));

        
        System.out.println("Sum of digits: " + sumOfDigits(digits));

        
        System.out.println("Sum of squares of digits: " + sumOfSquares(digits));

    
        if (isHarshadNumber(number, digits)) {
            System.out.println(number + " is a Harshad number.");
        } else {
            System.out.println(number + " is NOT a Harshad number.");
        }

        
        int[][] freq = digitFrequency(digits);
        System.out.println("Digit frequency:");
        System.out.println("Digit | Frequency");
        for (int i = 0; i < freq.length; i++) {
            System.out.println("   " + freq[i][0] + "   |    " + freq[i][1]);
        }

        sc.close();
    }
}

