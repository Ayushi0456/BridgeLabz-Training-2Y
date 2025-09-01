import java.util.Scanner;

public class studentnames {

    public static void displayStudents(String[] students) {
        System.out.println("Registered Students:");
        for (String student : students) {
            System.out.println(student);
        }
    }

    public static void compareStrings(String s1, String s2) {
        System.out.println("\nComparing \"" + s1 + "\" and \"" + s2 + "\"");
        System.out.println("Using == : " + (s1 == s2));
        System.out.println("Using equals(): " + s1.equals(s2));
    }

    public static void searchStudent(String[] students, String name) {
        boolean found = false;
        for (String student : students) {
            if (student.equalsIgnoreCase(name)) {
                System.out.println("Student Registered");
                found = true;
                break;
            }
        }
        if (!found) {
            System.out.println("Student Not Found");
        }
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.print("Enter number of students to register: ");
        int n = sc.nextInt();
        sc.nextLine(); 

        String[] students = new String[n];
        for (int i = 0; i < n; i++) {
            System.out.print("Enter student name " + (i + 1) + ": ");
            students[i] = sc.nextLine();
        }

     
        displayStudents(students);

        
        String s1 = "Java";       
        String s2 = "Java";       
        String s3 = new String("Java");
        compareStrings(s1, s2);   
        compareStrings(s1, s3);   

        
        String original = "Hello";
        String modified = original.concat(" World"); 
        System.out.println("\nOriginal String: " + original);
        System.out.println("After concatenation: " + modified);

       
        System.out.print("\nEnter a student name to search: ");
        String searchName = sc.nextLine();
        searchStudent(students, searchName);

       
        System.out.println("\n--- StringBuffer Example (Thread-Safe) ---");
        StringBuffer sbuffer = new StringBuffer("Student");
        sbuffer.append(" Registration");
        sbuffer.insert(0, "Java ");
        sbuffer.delete(5, 8);
        System.out.println("Modified using StringBuffer: " + sbuffer);

        System.out.println("\n--- StringBuilder Example (Faster, Not Thread-Safe) ---");
        StringBuilder sbuilder = new StringBuilder("System");
        sbuilder.append(" Demo");
        sbuilder.insert(0, "Java ");
        sbuilder.delete(5, 7);
        System.out.println("Modified using StringBuilder: " + sbuilder);

        System.out.println("\nNote: StringBuffer is thread-safe (synchronized), while StringBuilder is faster but not synchronized.");

        sc.close();
    }
}

