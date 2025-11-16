import java.util.*;

public class Department {

    public static void main(String[] args) {

        HashMap<Integer, String> empMap = new HashMap<>();

        empMap.put(101, "HR");
        empMap.put(102, "Finance");
        empMap.put(103, "IT");
        empMap.put(104, "Marketing");
        empMap.put(105, "IT");
        empMap.put(106, "HR");
        empMap.put(107, "Finance");

        changeDepartment(empMap, 105, "Marketing");  
        changeDepartment(empMap, 102, "IT");        
        changeDepartment(empMap, 999, "Sales");      

        System.out.println("\nEmployees Working in IT Department:");
        findEmployeesByDepartment(empMap, "IT");

        System.out.println("\nEmployees Working in HR Department:");
        findEmployeesByDepartment(empMap, "HR");

        System.out.println("\nTotal Employees per Department:");
        printDepartmentCounts(empMap);
    }

    public static void changeDepartment(HashMap<Integer, String> map,
                                        int empId, String newDept) {
        if (map.containsKey(empId)) {
            map.put(empId, newDept);
            System.out.println("Employee " + empId + " moved to " + newDept);
        } else {
            System.out.println("Employee not found: " + empId);
        }
    }

    public static void findEmployeesByDepartment(HashMap<Integer, String> map,
                                                 String department) {
        boolean found = false;
        for (Map.Entry<Integer, String> entry : map.entrySet()) {
            if (entry.getValue().equalsIgnoreCase(department)) {
                System.out.println("Employee ID: " + entry.getKey());
                found = true;
            }
        }
        if (!found) {
            System.out.println("No employees found in " + department);
        }
    }

    public static void printDepartmentCounts(HashMap<Integer, String> map) {

        HashMap<String, Integer> deptCount = new HashMap<>();

        for (String dept : map.values()) {
            deptCount.put(dept, deptCount.getOrDefault(dept, 0) + 1);
        }

        for (String dept : deptCount.keySet()) {
            System.out.println(dept + " → " + deptCount.get(dept) + " employees");
        }
    }
}

