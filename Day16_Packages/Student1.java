// ----------- Student.java -----------
package college.student;

public class Student {
    public void displayStudent(String name, int roll) {
        System.out.println("Student Name: " + name);
        System.out.println("Roll Number: " + roll);
    }
}

// ----------- Faculty.java -----------
package college.faculty;

public class Faculty {
    public void displayFaculty(String name, String subject) {
        System.out.println("Faculty Name: " + name);
        System.out.println("Subject: " + subject);
    }
}

// ----------- Main.java -----------
import college.student.Student;
import college.faculty.Faculty;

public class Main {
    public static void main(String[] args) {

        Student s = new Student();
        s.displayStudent("Ayushi", 45);

        Faculty f = new Faculty();
        f.displayFaculty("Rahul Sir", "Java Programming");
    }
}
