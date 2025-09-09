class Student {
    public int rollNumber;       
    protected String name;      
    private double CGPA;        

    Student(int rollNumber, String name, double CGPA) {
        this.rollNumber = rollNumber;
        this.name = name;
        this.CGPA = CGPA;
    }

    public double getCGPA() {    
        return CGPA;
    }

    public void setCGPA(double CGPA) {
        this.CGPA = CGPA;
    }
}

class PostgraduateStudent extends Student {
    String thesisTopic;

    PostgraduateStudent(int rollNumber, String name, double CGPA, String thesisTopic) {
        super(rollNumber, name, CGPA);
        this.thesisTopic = thesisTopic;
    }

    void displayDetails() {
        System.out.println("Roll Number: " + rollNumber); 
        System.out.println("Name: " + name);             
        System.out.println("CGPA: " + getCGPA());         
        System.out.println("Thesis Topic: " + thesisTopic);
    }

    public static void main(String[] args) {
        PostgraduateStudent pg = new PostgraduateStudent(101, "Ayushi", 9.1, "AI in Healthcare");
        pg.displayDetails();
        pg.setCGPA(9.5);   
        System.out.println("Updated CGPA: " + pg.getCGPA());
    }
}

