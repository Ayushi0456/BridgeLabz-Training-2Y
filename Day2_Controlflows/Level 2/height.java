import java.util.Scanner;

public class height{
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        
        String[] friends = {"Amar", "Akbar", "Anthony"};
        int[] ages = new int[3];
        double[] heights = new double[3];

        
        for (int i = 0; i < 3; i++) {
            System.out.print("Enter age of " + friends[i] + " (in years): ");
            ages[i] = scanner.nextInt();
        }

        
        for (int i = 0; i < 3; i++) {
            System.out.print("Enter height of " + friends[i] + " (in cm): ");
            heights[i] = scanner.nextDouble();
        }

        
        int minAgeIndex = 0;
        for (int i = 1; i < 3; i++) {
            if (ages[i] < ages[minAgeIndex]) {
                minAgeIndex = i;
            }
        }

        int maxHeightIndex = 0;
        for (int i = 1; i < 3; i++) {
            if (heights[i] > heights[maxHeightIndex]) {
                maxHeightIndex = i;
            }
        }

        
        System.out.println("\nThe youngest friend is: " + friends[minAgeIndex] + " with age " + ages[minAgeIndex] + " years.");
        System.out.println("The tallest friend is: " + friends[maxHeightIndex] + " with height " + heights[maxHeightIndex] + " cm.");

        scanner.close();
    }
}

