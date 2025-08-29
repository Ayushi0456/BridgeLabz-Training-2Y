public class intprimeno {
    public static void main(String[] args) {
        int num1 = 17;
        int num2 = 12;
        System.out.println(num1 + " is a prime number: " + isPrime(num1));
        System.out.println(num2 + " is a prime number: " + isPrime(num2));
    }

    public static boolean isPrime(int num) {
        if (num <= 1) {
            return false;
        }
        for (int i = 2; i <= Math.sqrt(num); i++) {
            if (num % i == 0) {
                return false;
            }
        }
        return true;
    }
}
