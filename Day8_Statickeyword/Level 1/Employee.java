class Employee {
    static String companyName = "TechCorp";
    static int totalEmployees = 0;

    final int id;
    String name, designation;

    Employee(int id, String name, String designation) {
        this.id = id;
        this.name = name;
        this.designation = designation;
        totalEmployees++;
    }

    static void displayTotalEmployees() {
        System.out.println("Total Employees: " + totalEmployees);
    }

    void displayEmployeeDetails() {
        if (this instanceof Employee) {
            System.out.println("ID: " + id + ", Name: " + name +
                               ", Designation: " + designation + ", Company: " + companyName);
        }
    }

    public static void main(String[] args) {
        Employee e1 = new Employee(1, "Ankit", "Developer");
        Employee e2 = new Employee(2, "Sneha", "Tester");
        e1.displayEmployeeDetails();
        e2.displayEmployeeDetails();
        Employee.displayTotalEmployees();
    }
}

