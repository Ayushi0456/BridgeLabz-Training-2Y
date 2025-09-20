import java.util.*;

class Subject {
    private String name;
    private int marks;

    public Subject(String name, int marks) {
        this.name = name;
        this.marks = marks;
    }

    public String getName() {
        return name;
    }

    public int getMarks() {
        return marks;
    }
}

class Student {
    private int id;
    private String name;
    private List<Subject> subjects;

    public Student(int id, String name) {
        this.id = id;
        this.name = name;
        this.subjects = new ArrayList<>();
    }

    public void addSubject(Subject subject) {
        subjects.add(subject);
    }

    public List<Subject> getSubjects() {
        return subjects;
    }

    public String getName() {
        return name;
    }
}

class GradeCalculator {
    public String calculateGrade(Student student) {
        List<Subject> subjects = student.getSubjects();
        if (subjects.isEmpty()) {
            return "No subjects available";
        }

        int total = 0;
        for (Subject s : subjects) {
            total += s.getMarks();
        }
        double average = (double) total / subjects.size();

        if (average >= 90) return "A";
        else if (average >= 75) return "B";
        else if (average >= 50) return "C";
        else return "F";
    }
}

public class SchoolResultApp {
    public static void main(String[] args) {
       
        Student student = new Student(1, "Rahul");

        
        student.addSubject(new Subject("Maths", 90));
        student.addSubject(new Subject("Science", 85));

       
        GradeCalculator calculator = new GradeCalculator();
        String grade = calculator.calculateGrade(student);

      
        System.out.println("Student: " + student.getName());
        for (Subject s : student.getSubjects()) {
            System.out.println("Subject: " + s.getName() + ", Marks: " + s.getMarks());
        }
        System.out.println("Final Grade: " + grade);
    }
}
