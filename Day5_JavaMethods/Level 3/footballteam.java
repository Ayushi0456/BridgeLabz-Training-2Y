import java.util.Random;

public class footballteam{

    
    public static int calculateSum(int[] arr) {
        int sum = 0;
        for (int num : arr) {
            sum += num;
        }
        return sum;
    }


    public static double calculateMean(int[] arr) {
        int sum = calculateSum(arr);
        return (double) sum / arr.length;
    }

    
    public static int findShortest(int[] arr) {
        int min = arr[0];
        for (int num : arr) {
            if (num < min) {
                min = num;
            }
        }
        return min;
    }

    
    public static int findTallest(int[] arr) {
        int max = arr[0];
        for (int num : arr) {
            if (num > max) {
                max = num;
            }
        }
        return max;
    }

    public static void main(String[] args) {
        Random random = new Random();

    
        int[] height = new int[11];

        
        System.out.println("Heights of players (in cm): ");
        for (int i = 0; i < height.length; i++) {
            height[i] = random.nextInt(101) + 150;  
            System.out.print(height[i] + " ");
        }
        System.out.println("\n");

        
        int shortest = findShortest(height);
        int tallest = findTallest(height);
        double mean = calculateMean(height);

        System.out.println("Shortest Height : " + shortest + " cm");
        System.out.println("Tallest Height  : " + tallest + " cm");
        System.out.printf("Mean Height     : %.2f cm\n", mean);
    }
}

