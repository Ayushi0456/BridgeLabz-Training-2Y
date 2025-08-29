import java.util.Scanner;

public class BMIcalculations{
    
    public static String[] calculateBMI(double weight, double heightCm) {
        double heightM = heightCm / 100.0;  
        double bmi = weight / (heightM * heightM);
        String status;

        if (bmi < 18.5)
            status = "Underweight";
        else if (bmi < 25.0)
            status = "Normal";
        else if (bmi < 40.0)
            status = "Overweight";
        else
            status = "Obese";

        return new String[]{String.format("%.2f", bmi), status};
    }

    
    public static String[][] computeResults(double[][] data) {
        String[][] result = new String[data.length][4]; 
        for (int i = 0; i < data.length; i++) {
            result[i][0] = String.valueOf(data[i][0]); 
            result[i][1] = String.valueOf(data[i][1]); 
            String[] bmiData = calculateBMI(data[i][0], data[i][1]);
            result[i][2] = bmiData[0]; 
            result[i][3] = bmiData[1]; 
        }
        return result;
    }


    public static void displayResults(String[][] result) {
        System.out.printf("%-10s %-10s %-10s %-15s\n", "Weight", "Height", "BMI", "Status");
        for (int i = 0; i < result.length; i++) {
            System.out.printf("%-10s %-10s %-10s %-15s\n", 
                              result[i][0], result[i][1], result[i][2], result[i][3]);
        }
    }

    
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        double[][] data = new double[10][2];

        
        for (int i = 0; i < 10; i++) {
            System.out.println("Enter weight (kg) for person " + (i+1) + ": ");
            data[i][0] = sc.nextDouble();
            System.out.println("Enter height (cm) for person " + (i+1) + ": ");
            data[i][1] = sc.nextDouble();
        }

        String[][] result = computeResults(data);
        displayResults(result);

        sc.close();
    }
}

