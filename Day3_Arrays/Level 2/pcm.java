import java.util.Scanner;

public class pcm{
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        
        System.out.print("Enter the number of students: ");
        int n = sc.nextInt();


        int[][] marks = new int[n][3]; 
        double[] percentage = new double[n];
        String[] grades = new String[n];

        
        for (int i = 0; i < n; i++) {
            System.out.println("\nStudent " + (i + 1) + ":");

            for (int j = 0; j < 3; j++) {
                String subject = (j == 0) ? "Physics" : (j == 1) ? "Chemistry" : "Maths";
                int mark;
                do {
                    System.out.print("Enter marks for " + subject + ": ");
                    mark = sc.nextInt();
                    if (mark < 0) {
                        System.out.println("Invalid input! Marks must be positive.");
                    }
                } while (mark < 0);

                marks[i][j] = mark;
            }

            
            int total = marks[i][0] + marks[i][1] + marks[i][2];
            percentage[i] = (total / 300.0) * 100;

        
            if (percentage[i] >= 90) {
                grades[i] = "A+";
            } else if (percentage[i] >= 80) {
                grades[i] = "A";
            } else if (percentage[i] >= 70) {
                grades[i] = "B";
            } else if (percentage[i] >= 60) {
                grades[i] = "C";
            } else if (percentage[i] >= 50) {
                grades[i] = "D";
            } else {
                grades[i] = "F";
            }
        }

        
        System.out.println("\nPhysics\tChemistry\tMaths\tPercentage\tGrade");
        sc.close();
    }
}


