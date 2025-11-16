import java.util.*;

public class Course {

    public static void main(String[] args) {

        Map<String, Integer> courseMap = new HashMap<>();

        courseMap.put("CS101", 45);
        courseMap.put("MATH102", 3);
        courseMap.put("ENG201", 55);
        courseMap.put("PHY110", 10);
        courseMap.put("CHEM220", 2);

        addStudent(courseMap, "CS101");
        addStudent(courseMap, "MATH102");
        dropStudent(courseMap, "CHEM220");
        dropStudent(courseMap, "MATH102");
        addStudent(courseMap, "PHY110");

        System.out.println("\nUpdated Course Registrations:");
        for (String course : courseMap.keySet()) {
            System.out.println(course + " → " + courseMap.get(course) + " students");
        }

        System.out.println("\nCourses Near Full (>= 50 Students):");
        for (String course : courseMap.keySet()) {
            if (courseMap.get(course) >= 50) {
                System.out.println(course + " → " + courseMap.get(course));
            }
        }

        System.out.println("\nUndersubscribed Courses (< 5 Students):");
        for (String course : courseMap.keySet()) {
            if (courseMap.get(course) < 5) {
                System.out.println(course + " → " + courseMap.get(course));
            }
        }
    }

    public static void addStudent(Map<String, Integer> map, String course) {
        if (map.containsKey(course)) {
            map.put(course, map.get(course) + 1);
            System.out.println("Added 1 student to " + course);
        } else {
            System.out.println("Course not found: " + course);
        }
    }

    public static void dropStudent(Map<String, Integer> map, String course) {
        if (map.containsKey(course)) {
            int count = map.get(course);
            if (count > 0) {
                map.put(course, count - 1);
                System.out.println("Dropped 1 student from " + course);
            } else {
                System.out.println("Cannot drop! " + course + " has zero students.");
            }
        } else {
            System.out.println("Course not found: " + course);
        }
    }
}
 
    

