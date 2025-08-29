public class fibonacciseries {
    public static void main(String[] args) {
        int numTerms = 10;
        printFibonacci(numTerms);
    }

    public static void printFibonacci(int n) {
        int a = 0, b = 1;
        System.out.print("Fibonacci Series up to " + n + " terms: ");
        for (int i = 0; i < n; i++) {
            System.out.print(a + " ");
            int sum = a + b;
            a = b;
            b = sum;
        }
        System.out.println();
    }
}
