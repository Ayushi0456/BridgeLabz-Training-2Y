import java.util.*;

class Employee {
    String name;
    String department;

    Employee(String name, String department) {
        this.name = name;
        this.department = department;
    }
}

public class Employeegroup {
    public static void main(String[] args) {
        List<Employee> employees = new ArrayList<>();
        employees.add(new Employee("Elias", "HR"));
        employees.add(new Employee("Bob", "IT"));
        employees.add(new Employee("Keral", "HR"));

        Map<String, List<Employee>> grouped = new HashMap<>();

        for (Employee emp : employees) {

            grouped.putIfAbsent(emp.department, new ArrayList<>());

            grouped.get(emp.department).add(emp);
        }
        System.out.println("Employees grouped by department:");
        for (String dept : grouped.keySet()) {
            System.out.print(dept + " = ");

            for (Employee e : grouped.get(dept)) {
                System.out.print(e.name + " ");
            }
            System.out.println();
        }
    }
}

