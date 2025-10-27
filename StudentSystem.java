import java.util.Scanner;

class InvalidMarksException extends Exception {
    public InvalidMarksException(String msg) {
        super(msg);
    }
}

class InvalidAgeException extends Exception {
    public InvalidAgeException(String msg) {
        super(msg);
    }
}

public class StudentResult {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        try {
            System.out.print("Enter student name: ");
            String name = sc.nextLine();

            System.out.print("Enter age: ");
            int age = sc.nextInt();

            int[] marks = new int[3];
            System.out.println("Enter marks of 3 subjects:");
            for (int i = 0; i < 3; i++) {
                marks[i] = sc.nextInt();
            }

            if (name == null || name.trim().equals("")) {
                throw new NullPointerException("Name is missing!");
            }

            if (age < 18) {
                throw new InvalidAgeException("Age must be 18 or above!");
            }

            for (int m : marks) {
                if (m < 0 || m > 100) {
                    throw new InvalidMarksException("Marks must be between 0 and 100!");
                }
            }

            int sum = 0;
            for (int m : marks) {
                sum += m;
            }

            double avg = sum / 3.0;
            System.out.println("Average Marks: " + avg);

            System.out.println("Trying to access invalid index...");
            System.out.println(marks[3]); 
        } 
        catch (NullPointerException e) {
            System.out.println("Error: " + e.getMessage());
        } 
        catch (InvalidMarksException e) {
            System.out.println("Error: " + e.getMessage());
        } 
        catch (InvalidAgeException e) {
            System.out.println("Error: " + e.getMessage());
        } 
        catch (ArithmeticException e) {
            System.out.println("Error: Division by zero!");
        } 
        catch (ArrayIndexOutOfBoundsException e) {
            System.out.println("Error: Invalid array index!");
        } 
        finally {
            System.out.println("Result processing completed.");
            sc.close();
        }
    }
}

