import java.util.Scanner;

public class perfectnumber {

    public static int sumOfProperDivisors(int number) {
        int sum = 0;
        for (int i = 1; i <= number / 2; i++) { 
            if (number % i == 0) {
                sum += i;
            }
        }
        return sum;
    }

    public static boolean isPerfectNumber(int number) {
        return number > 0 && sumOfProperDivisors(number) == number;
    }

    public static boolean isAbundantNumber(int number) {
        return number > 0 && sumOfProperDivisors(number) > number;
    }

    public static boolean isDeficientNumber(int number) {
        return number > 0 && sumOfProperDivisors(number) < number;
    }

    public static int factorial(int n) {
        int fact = 1;
        for (int i = 2; i <= n; i++) {
            fact *= i;
        }
        return fact;
    }

    
    public static boolean isStrongNumber(int number) {
        int sum = 0;
        int n = number;
        while (n != 0) {
            int digit = n % 10;
            sum += factorial(digit);
            n /= 10;
        }
        return sum == number;
    }

   
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter a number: ");
        int number = sc.nextInt();

       
        if (isPerfectNumber(number)) {
            System.out.println(number + " is a Perfect number.");
        } else {
            System.out.println(number + " is NOT a Perfect number.");
        }

        
        if (isAbundantNumber(number)) {
            System.out.println(number + " is an Abundant number.");
        } else {
            System.out.println(number + " is NOT an Abundant number.");
        }

        
        if (isDeficientNumber(number)) {
            System.out.println(number + " is a Deficient number.");
        } else {
            System.out.println(number + " is NOT a Deficient number.");
        }

       
        if (isStrongNumber(number)) {
            System.out.println(number + " is a Strong number.");
        } else {
            System.out.println(number + " is NOT a Strong number.");
        }

        sc.close();
    }
}

