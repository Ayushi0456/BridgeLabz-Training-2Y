import java.util.ArrayList;

public class WrapperTest {

    public static void main(String[] args) {
        int[] numbers = {1, 0, 0, 0, 0, 0, 0};

        int iterations = 5_000_00; 
        long startList = System.nanoTime();

        ArrayList<Integer> list = new ArrayList<>();
        for (int i = 0; i < iterations; i++) {
            for (int n : numbers) {
                list.add(n);   
            }
        }

        long sumList = 0;
        for (Integer value : list) {
            sumList += value; 
        }

        long endList = System.nanoTime();
        long startArray = System.nanoTime();

        int[] arr = new int[iterations * numbers.length];
        int index = 0;

        for (int i = 0; i < iterations; i++) {
            for (int n : numbers) {
                arr[index++] = n;
            }
        }

        long sumArray = 0;
        for (int value : arr) {
            sumArray += value; 
        }

        long endArray = System.nanoTime();
        System.out.println("===== Benchmark Results =====");
        System.out.println("Sum using ArrayList<Integer>: " + sumList);
        System.out.println("Sum using int[]            : " + sumArray);

        System.out.println("\nTime Taken (ArrayList<Integer>): " 
            + (endList - startList) / 1_000_000.0 + " ms");

        System.out.println("Time Taken (int[]):           " 
            + (endArray - startArray) / 1_000_000.0 + " ms");
    }
}

