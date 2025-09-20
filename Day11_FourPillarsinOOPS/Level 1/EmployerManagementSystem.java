
interface Department {
    void assignDepartment(String departmentName);
    void assignment(String task);
    String getDepartmentDetails();
}


abstract class Employee {
    private int employeeID;
    private String name;
    private double baseSalary;

    public Employee(int employeeID, String name, double baseSalary) {
        this.employeeID = employeeID;
        this.name = name;
        this.baseSalary = baseSalary;
    }

    public abstract double calculateSalary();

    public void displayDetails() {
        System.out.println("Employee ID: " + employeeID);
        System.out.println("Name: " + name);
        System.out.println("Base Salary: " + baseSalary);
        System.out.println("Total Salary: " + calculateSalary());
    }

    public int getEmployeeID() {
        return employeeID;
    }

    public void setEmployeeID(int employeeID) {
        this.employeeID = employeeID;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public double getBaseSalary() {
        return baseSalary;
    }

    public void setBaseSalary(double baseSalary) {
        this.baseSalary = baseSalary;
    }
}

class FullTimeEmployee extends Employee implements Department {
    private String department;
    private String task;

    public FullTimeEmployee(int employeeID, String name, double baseSalary) {
        super(employeeID, name, baseSalary);
    }

    @Override
    public double calculateSalary() {
        return getBaseSalary();
    }

    @Override
    public void assignDepartment(String departmentName) {
        this.department = departmentName;
    }

    @Override
    public void assignment(String task) {
        this.task = task;
    }

    @Override
    public String getDepartmentDetails() {
        return "Department: " + department + ", Task: " + task;
    }

    @Override
    public void displayDetails() {
        super.displayDetails();
        System.out.println(getDepartmentDetails());
        System.out.println("----------------------------");
    }
}

class PartTimeEmployee extends Employee implements Department {
    private int workHours;
    private double hourlyRate;
    private String department;
    private String task;

    public PartTimeEmployee(int employeeID, String name, double hourlyRate, int workHours) {
        super(employeeID, name, 0); 
        this.hourlyRate = hourlyRate;
        this.workHours = workHours;
    }

    @Override
    public double calculateSalary() {
        return workHours * hourlyRate;
    }

    @Override
    public void assignDepartment(String departmentName) {
        this.department = departmentName;
    }

    @Override
    public void assignment(String task) {
        this.task = task;
    }

    @Override
    public String getDepartmentDetails() {
        return "Department: " + department + ", Task: " + task;
    }

    @Override
    public void displayDetails() {
        super.displayDetails();
        System.out.println(getDepartmentDetails());
        System.out.println("----------------------------");
    }
}

public class EmployerManagementSystem {
    public static void main(String[] args) {
        Employee[] employees = new Employee[3];

        FullTimeEmployee emp1 = new FullTimeEmployee(101, "Alice", 50000);
        emp1.assignDepartment("IT");
        emp1.assignment("Software Development");

        PartTimeEmployee emp2 = new PartTimeEmployee(102, "Bob", 200, 80);
        emp2.assignDepartment("HR");
        emp2.assignment("Recruitment");

        FullTimeEmployee emp3 = new FullTimeEmployee(103, "Charlie", 60000);
        emp3.assignDepartment("Finance");
        emp3.assignment("Accounting");

        employees[0] = emp1;
        employees[1] = emp2;
        employees[2] = emp3;

        for (Employee emp : employees) {
            emp.displayDetails();
        }
    }
}
