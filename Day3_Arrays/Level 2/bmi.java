import java.util.Scanner;

public class bmi {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        
        System.out.print("Enter the number of persons: ");
        int n = sc.nextInt();


        double[] height = new double[n];
        double[] weight = new double[n];
        double[] bmi = new double[n];
        String[] status = new String[n];


        for (int i = 0; i < n; i++) {
            System.out.println("\nPerson " + (i + 1) + ":");
            System.out.print("Enter weight (kg): ");
            weight[i] = sc.nextDouble();

            System.out.print("Enter height (m): ");
            height[i] = sc.nextDouble();

            
            bmi[i] = weight[i] / (height[i] * height[i]);

        
            if (bmi[i] < 18.5) {
                status[i] = "Underweight";
            } else if (bmi[i] < 25) {
                status[i] = "Normal";
            } else if (bmi[i] < 30) {
                status[i] = "Overweight";
            } else {
                status[i] = "Obese";
            }
        }

        
        System.out.println("\nHeight(m)\tWeight(kg)\tBMI\t\tStatus");
        System.out.println("-------------------------------------------------");
        for (int i = 0; i < n; i++) {
            System.out.printf("%.2f\t\t%.2f\t\t%.2f\t%s\n", height[i], weight[i], bmi[i], status[i]);
            sc.close();
        }
    }
}

