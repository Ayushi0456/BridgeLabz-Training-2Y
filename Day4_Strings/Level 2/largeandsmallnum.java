public class largeandsmallnum {
    public static void main(String[] args) {
        int[] numbers = {45, 8, 92, 10, 5, 67};
        int max = findMax(numbers);
        int min = findMin(numbers);
        System.out.println("The largest number in the array is: " + max);
        System.out.println("The smallest number in the array is: " + min);
    }

    public static int findMax(int[] arr) {
        int max = arr[0];
        for (int i = 1; i < arr.length; i++) {
            if (arr[i] > max) {
                max = arr[i];
            }
        }
        return max;
    }

    public static int findMin(int[] arr) {
        int min = arr[0];
        for (int i = 1; i < arr.length; i++) {
            if (arr[i] < min) {
                min = arr[i];
            }
        }
        return min;
    }
}
