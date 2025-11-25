import student.Student;
import faculty.Faculty;

public class MainApp {
    public static void main(String[] args) {
        Student s = new Student();
        Faculty f = new Faculty();

        s.displayStudentDetails();
        f.displayFacultyDetails();
    }
}
