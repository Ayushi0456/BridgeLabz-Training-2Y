import java.util.*;

public class BMI {
    public static double calculateBMI(double weightKg, double heightCm) {
        double heightM = heightCm / 100.0;
        return weightKg / (heightM * heightM);
    }

    public static String bmiStatus(double bmi) {
        if (bmi <= 18.4) return "Underweight";
        else if (bmi <= 24.9) return "Normal";
        else if (bmi <= 39.9) return "Overweight";
        else return "Obese";
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        double[][] data = new double[10][3]; 

        for (int i = 0; i < 10; i++) {
            System.out.print("Enter weight (kg) of member " + (i+1) + ": ");
            data[i][0] = sc.nextDouble();
            System.out.print("Enter height (cm) of member " + (i+1) + ": ");
            data[i][1] = sc.nextDouble();
            data[i][2] = calculateBMI(data[i][0], data[i][1]);
        }

        System.out.println("\nMember\tWeight\tHeight\tBMI\tStatus");
        for (int i = 0; i < 10; i++) {
            System.out.println((i+1) + "\t" + data[i][0] + "\t" + data[i][1] + "\t" +
                               String.format("%.2f", data[i][2]) + "\t" +
                               bmiStatus(data[i][2]));
                               sc.close();
                               
        }
    }
}

