public class factorial {
    public static void main(String[] args) {
        int num = 5;
        long factorial = calculateFactorial(num);
        System.out.println("The factorial of " + num + " is: " + factorial);
    }

    public static long calculateFactorial(int n) {
        if (n < 0) {
            return -1; 
        }
        long result = 1;
        for (int i = 1; i <= n; i++) {
            result *= i;
        }
        return result;
    }
}
