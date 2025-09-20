
class Person {
    protected String name;
    protected int age;

    public Person(String name, int age) {
        this.name = name;
        this.age = age;
    }

    public void displayInfo() {
        System.out.println("Name: " + name);
        System.out.println("Age: " + age);
    }
}


class Teacher extends Person {
    private String subject;

    public Teacher(String name, int age, String subject) {
        super(name, age);
        this.subject = subject;
    }

    public void displayRule() {
        System.out.println("Role: Teacher");
        displayInfo();
        System.out.println("Subject: " + subject);
        System.out.println("Rule: Teach assigned subject and guide students.");
    }
}

class Student extends Person {
    private String grade;

    public Student(String name, int age, String grade) {
        super(name, age);
        this.grade = grade;
    }

    public void displayRule() {
        System.out.println("Role: Student");
        displayInfo();
        System.out.println("Grade: " + grade);
        System.out.println("Rule: Attend classes and complete assignments.");
    }
}

class Staff extends Person {
    private String department;

    public Staff(String name, int age, String department) {
        super(name, age);
        this.department = department;
    }

    public void displayRule() {
        System.out.println("Role: Staff");
        displayInfo();
        System.out.println("Department: " + department);
        System.out.println("Rule: Support school operations and administration.");
    }
}

public class SchoolRuleApp {
    public static void main(String[] args) {
        Teacher teacher = new Teacher("Mr. Smith", 40, "Mathematics");
        Student student = new Student("Alice", 16, "10th Grade");
        Staff staff = new Staff("John", 35, "Maintenance");

        teacher.displayRule();
        System.out.println("---------------------");
        student.displayRule();
        System.out.println("---------------------");
        staff.displayRule();
    }
}

