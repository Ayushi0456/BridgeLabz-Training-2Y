import java.util.*;

public class Result{

    public static void main(String[] args) {

        Map<String, Map<String, Integer>> resultMap = new HashMap<>();

        addMarks(resultMap, "Maths", "Amit", 95);
        addMarks(resultMap, "Maths", "Priya", 88);
        addMarks(resultMap, "Maths", "Rohan", 76);

        addMarks(resultMap, "Science", "Amit", 92);
        addMarks(resultMap, "Science", "Priya", 81);
        addMarks(resultMap, "Science", "Kiran", 67);

        addMarks(resultMap, "English", "Priya", 91);
        addMarks(resultMap, "English", "Amit", 84);
        addMarks(resultMap, "English", "Rohan", 78);

        System.out.println("\nTop Scorer Per Subject:");
        topperPerSubject(resultMap);

        System.out.println("\nAverage Score Per Subject:");
        averagePerSubject(resultMap);

        System.out.println("\nSubjects with At Least One Score Above 90:");
        subjectsAbove90(resultMap);
    }

    public static void addMarks(Map<String, Map<String, Integer>> map,
                                String subject, String student, int marks) {

        map.putIfAbsent(subject, new HashMap<>());
        map.get(subject).put(student, marks);
    }

    public static void topperPerSubject(Map<String, Map<String, Integer>> map) {

        for (String subject : map.keySet()) {
            String topper = "";
            int topMarks = -1;

            for (Map.Entry<String, Integer> entry : map.get(subject).entrySet()) {
                if (entry.getValue() > topMarks) {
                    topMarks = entry.getValue();
                    topper = entry.getKey();
                }
            }

            System.out.println(subject + " → Topper: " + topper + " (" + topMarks + ")");
        }
    }

    public static void averagePerSubject(Map<String, Map<String, Integer>> map) {

        for (String subject : map.keySet()) {
            int sum = 0;
            int count = 0;

            for (int marks : map.get(subject).values()) {
                sum += marks;
                count++;
            }

            double avg = (double) sum / count;
            System.out.println(subject + " → Average Score: " + avg);
        }
    }

    public static void subjectsAbove90(Map<String, Map<String, Integer>> map) {

        for (String subject : map.keySet()) {
            boolean found = false;

            for (int marks : map.get(subject).values()) {
                if (marks > 90) {
                    found = true;
                    break;
                }
            }

            if (found) {
                System.out.println(subject);
            }
        }
    }
}

