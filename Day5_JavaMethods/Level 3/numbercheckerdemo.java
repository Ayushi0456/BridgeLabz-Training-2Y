import java.util.Scanner;

class numberchecker {


    public static int countDigits(int num) {
        if (num == 0) return 1;
        int n = Math.abs(num);
        int count = 0;
        while (n > 0) {
            count++;
            n /= 10;
        }
        return count;
    }


    public static int[] getDigitsArray(int num) {
        int n = Math.abs(num);
        int len = countDigits(n);
        int[] digits = new int[len];
        for (int i = len - 1; i >= 0; i--) {
            digits[i] = n % 10;
            n /= 10;
        }
        return digits;
    }

    
    public static boolean isDUCNumber(int[] digits) {
        for (int d : digits) {
            if (d != 0) return true;
        }
        return false;
    }

    
    private static long intPow(int base, int exp) {
        long result = 1;
        for (int i = 0; i < exp; i++) result *= base;
        return result;
    }


    public static boolean isArmstrong(int num) {
        int[] digits = getDigitsArray(num);
        int n = digits.length;
        long sum = 0L;
        for (int d : digits) sum += intPow(d, n);
        return sum == Math.abs((long) num);
    }

    
    public static int[] largestAndSecondLargest(int[] digits) {
        int largest = Integer.MIN_VALUE;
        int secondLargest = Integer.MIN_VALUE;

        for (int d : digits) {
            if (d > largest) {
                secondLargest = largest;
                largest = d;
            } else if (d > secondLargest && d != largest) {
                secondLargest = d;
            }
        }
        if (secondLargest == Integer.MIN_VALUE) secondLargest = -1;
        return new int[]{largest, secondLargest};
    }


    public static int[] smallestAndSecondSmallest(int[] digits) {
        int smallest = Integer.MAX_VALUE;
        int secondSmallest = Integer.MAX_VALUE;

        for (int d : digits) {
            if (d < smallest) {
                secondSmallest = smallest;
                smallest = d;
            } else if (d < secondSmallest && d != smallest) {
                secondSmallest = d;
            }
        }
        
        if (secondSmallest == Integer.MAX_VALUE) secondSmallest = -1;
        return new int[]{smallest, secondSmallest};
    }
}

public class numbercheckerdemo {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter an integer: ");

        
        int num = sc.hasNextInt() ? sc.nextInt() : 0;

        int[] digits = numberchecker.getDigitsArray(num);

        System.out.println("Digit count: " + numberchecker.countDigits(num));

        System.out.print("Digits array: ");
        for (int d : digits) System.out.print(d + " ");
        System.out.println();

        System.out.println("Is DUC number? " + numberchecker.isDUCNumber(digits));
        System.out.println("Is Armstrong number? " + numberchecker.isArmstrong(num));

        int[] lg = numberchecker.largestAndSecondLargest(digits);
        System.out.println("Largest digit: " + lg[0]);
        System.out.println("Second largest digit: " + (lg[1] == -1 ? "N/A" : lg[1]));

        int[] sm = numberchecker.smallestAndSecondSmallest(digits);
        System.out.println("Smallest digit: " + sm[0]);
        System.out.println("Second smallest digit: " + (sm[1] == -1 ? "N/A" : sm[1]));

        sc.close();
    }
}
