import java.util.*;

public class Employee {

    public static void main(String[] args) {

        Map<String, Double> salaryMap = new HashMap<>();

       
        salaryMap.put("Amit", 45000.0);
        salaryMap.put("Priya", 52000.0);
        salaryMap.put("Rohan", 38000.0);
        salaryMap.put("Kiran", 61000.0);
        salaryMap.put("Anjali", 47000.0);
        salaryMap.put("Vikram", 55000.0);

      
        giveRaise(salaryMap, "Amit", 10);     
        giveRaise(salaryMap, "Kiran", 5);    
        giveRaise(salaryMap, "Rohan", 12);    
        giveRaise(salaryMap, "Unknown", 10);  

        System.out.println("\nUpdated Employee Salaries:");
        for (String emp : salaryMap.keySet()) {
            System.out.println(emp + " → Rs. " + salaryMap.get(emp));
        }

        double average = computeAverage(salaryMap);
        System.out.println("\nAverage Salary: Rs. " + average);

        String highestEmployee = getHighestPaidEmployee(salaryMap);
        System.out.println("Highest Paid Employee: " + highestEmployee + 
                           " → Rs. " + salaryMap.get(highestEmployee));
    }

    public static void giveRaise(Map<String, Double> map, String employee, double percent) {
        if (map.containsKey(employee)) {
            double current = map.get(employee);
            double newSalary = current + (current * percent / 100);
            map.put(employee, newSalary);
            System.out.println("Raise given to " + employee + ": " + percent + "%");
        } else {
            System.out.println("Employee not found: " + employee);
        }
    }

    public static double computeAverage(Map<String, Double> map) {
        double total = 0;
        for (double salary : map.values()) {
            total += salary;
        }
        return total / map.size();
    }

    public static String getHighestPaidEmployee(Map<String, Double> map) {
        String highestEmp = "";
        double highestSalary = Double.MIN_VALUE;

        for (String emp : map.keySet()) {
            if (map.get(emp) > highestSalary) {
                highestSalary = map.get(emp);
                highestEmp = emp;
            }
        }
        return highestEmp;
    }
}

