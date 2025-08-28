import java.util.Scanner;

public class bmiarray {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

    
        System.out.print("Enter the number of persons: ");
        int n = sc.nextInt();

        
        double[][] personData = new double[n][3]; 
        String[] status = new String[n]; 

        
        for (int i = 0; i < n; i++) {
            System.out.println("\nPerson " + (i + 1) + ":");

        
            double weight;
            do {
                System.out.print("Enter weight (kg, positive value): ");
                weight = sc.nextDouble();
                if (weight <= 0) {
                    System.out.println("Invalid input! Weight must be positive.");
                }
            } while (weight <= 0);
            personData[i][0] = weight;

            
            double height;
            do {
                System.out.print("Enter height (m, positive value): ");
                height = sc.nextDouble();
                if (height <= 0) {
                    System.out.println("Invalid input! Height must be positive.");
                }
            } while (height <= 0);
            personData[i][1] = height;

            
            double bmi = weight / (height * height);
            personData[i][2] = bmi;

        
            if (bmi < 18.5) {
                status[i] = "Underweight";
            } else if (bmi < 25) {
                status[i] = "Normal";
            } else if (bmi < 30) {
                status[i] = "Overweight";
            } else {
                status[i] = "Obese";
            }
        }

        
        System.out.println("\nHeight(m)\tWeight(kg)\tBMI\t\tStatus");
        System.out.println("-----------------------------------------------------");
        for (int i = 0; i < n; i++) {
            System.out.printf("%.2f\t\t%.2f\t\t%.2f\t%s\n", personData[i][1], personData[i][0], personData[i][2], status[i]);
        }
        sc.close();
    }
}

