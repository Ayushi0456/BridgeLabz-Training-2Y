class Employee {
    public int employeeID;     
    protected String department; 
    private double salary;       

    Employee(int employeeID, String department, double salary) {
        this.employeeID = employeeID;
        this.department = department;
        this.salary = salary;
    }

    public double getSalary() {   
        return salary;
    }

    public void setSalary(double salary) {
        this.salary = salary;
    }
}

class Manager extends Employee {
    String teamName;

    Manager(int employeeID, String department, double salary, String teamName) {
        super(employeeID, department, salary);
        this.teamName = teamName;
    }

    void displayDetails() {
        System.out.println("Employee ID: " + employeeID);   
        System.out.println("Department: " + department);    
        System.out.println("Salary: " + getSalary());      
        System.out.println("Team Name: " + teamName);
    }

    public static void main(String[] args) {
        Manager m1 = new Manager(2001, "IT", 75000, "Development");
        m1.displayDetails();
        m1.setSalary(80000);
        System.out.println("Updated Salary: " + m1.getSalary());
    }
}

