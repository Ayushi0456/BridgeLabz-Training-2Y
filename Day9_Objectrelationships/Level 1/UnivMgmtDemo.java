import java.util.*;

class Student {
    private String name;
    private List<Course> courses = new ArrayList<>();
    public Student(String name){ this.name = name; }
    public void enrollCourse(Course c){
        if(!courses.contains(c)){
            courses.add(c);
            c.addStudent(this);
            System.out.println(name + " enrolled in " + c.getTitle());
        }
    }
    public String getName(){ return name; }
}

class Professor {
    private String name;
    public Professor(String name){ this.name = name; }
    public String getName(){ return name; }
}

class Course {
    private String title;
    private Professor professor;
    private List<Student> students = new ArrayList<>();
    public Course(String title){ this.title = title; }
    public String getTitle(){ return title; }
    public void assignProfessor(Professor p){
        this.professor = p;
        System.out.println("Professor " + p.getName() + " assigned to " + title);
    }
    public void addStudent(Student s){ students.add(s); }
    public void listStudents(){
        System.out.println("Course: " + title + " taught by " + (professor==null? "TBD" : professor.getName()));
        for(Student s : students) System.out.println("- " + s.getName());
    }
}

public class UnivMgmtDemo {
    public static void main(String[] args){
        Student s1 = new Student("Rohit");
        Professor prof = new Professor("Dr. Kaur");
        Course ds = new Course("Data Structures");

        ds.assignProfessor(prof);
        s1.enrollCourse(ds);
        ds.listStudents();
    }
}

