import java.util.*;

public class StudentGradeTracker {
    public static void main(String[] args) {
        Map<String, Double> grades = new TreeMap<>();
        grades.put("Alice", 85.0);
        grades.put("Bob", 92.5);
        grades.put("Charlie", 78.0);
        grades.put("Daisy", 88.5);

        System.out.println("Initial Student Grades:");
        printGrades(grades);
        System.out.println("\nUpdating grade for Bob...");
        grades.put("Bob", 95.0);  
        printGrades(grades);
        System.out.println("\nRemoving student: Charlie...");
        grades.remove("Charlie");
        printGrades(grades);
        System.out.println("\nFinal Sorted Student List:");
        printGrades(grades);
    }
    public static void printGrades(Map<String, Double> map) {
        for (Map.Entry<String, Double> entry : map.entrySet()) {
            System.out.println(entry.getKey() + " = " + entry.getValue());
        }
    }
}

