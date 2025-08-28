import java.util.Scanner;

public class pcm2darray {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        
        System.out.print("Enter the number of students: ");
        int n = sc.nextInt();

        
        int[][] marks = new int[n][3]; 
        double[][] studentData = new double[n][2]; 
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
            double percent = (total / 300.0) * 100;
            studentData[i][0] = percent;

        
            if (percent >= 90) {
                grades[i] = "A+";
            } else if (percent >= 80) {
                grades[i] = "A";
            } else if (percent >= 70) {
                grades[i] = "B";
            } else if (percent >= 60) {
                grades[i] = "C";
            } else if (percent >= 50) {
                grades[i] = "D";
            } else {
                grades[i] = "F";
            }
        }

        // Display results
        System.out.println("\nPhysics\tChemistry\tMaths\tPercentage\tGrade");
        System.out.println("-----------------------------------------------------------");
        for (int i = 0; i < n; i++) {
            System.out.printf("%d\t%d\t\t%d\t%.2f\t\t%s\n", 
                              marks[i][0], marks[i][1], marks[i][2], studentData[i][0], grades[i]);
                              sc.close();
        }
    }
}

