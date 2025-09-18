class Student {
    static String universityName = "GLA University";
    static int totalStudents = 0;

    final int rollNumber;
    String name;
    String grade;

    Student(int rollNumber, String name, String grade) {
        this.rollNumber = rollNumber;
        this.name = name;
        this.grade = grade;
        totalStudents++;
    }

    static void displayTotalStudents() {
        System.out.println("Total Students: " + totalStudents);
    }

    void displayStudentDetails() {
        if (this instanceof Student) {
            System.out.println("Roll No: " + rollNumber + ", Name: " + name +
                               ", Grade: " + grade + ", University: " + universityName);
        }
    }

    public static void main(String[] args) {
        Student s1 = new Student(1, "Ayushi", "A");
        Student s2 = new Student(2, "Rohit", "B");
        s1.displayStudentDetails();
        s2.displayStudentDetails();
        Student.displayTotalStudents();
    }
}

