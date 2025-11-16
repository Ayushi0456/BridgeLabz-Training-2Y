import java.util.*;

public class Attendance {

    public static void main(String[] args) {

        
        List<String> students = Arrays.asList(
            "Alice", "Bob", "Charlie", "Daisy", "Ethan"
        );

        Map<String, Integer> attendance = new HashMap<>();
        for (String s : students) {
            attendance.put(s, 0);
        }
        Random random = new Random();
        System.out.println("Simulating attendance for 15 days...\n");

        for (int day = 1; day <= 15; day++) {
            System.out.println("Day " + day + " attendance:");
            List<String> presentToday = new ArrayList<>();

            for (String s : students) {
                if (random.nextBoolean()) {  
                    presentToday.add(s);
                }
            }

            System.out.println("Present: " + presentToday + "\n");

            for (String student : presentToday) {
                attendance.put(student, attendance.get(student) + 1);
            }
        }

        System.out.println("Monthly Attendance Summary:");
        for (Map.Entry<String, Integer> entry : attendance.entrySet()) {
            System.out.println(entry.getKey() + " = " + entry.getValue() + " days present");
        }

        int threshold = 10;

        System.out.println("\nStudents with fewer than " + threshold + " days attendance:");
        for (Map.Entry<String, Integer> entry : attendance.entrySet()) {
            if (entry.getValue() < threshold) {
                System.out.println(entry.getKey() + " (" + entry.getValue() + " days)");
            }
        }
    }
}

