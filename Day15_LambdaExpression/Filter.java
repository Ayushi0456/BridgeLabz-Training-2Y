import java.util.*;
import java.util.function.Predicate;

public class Filter {
    public static void main(String[] args) {

        List<String> alerts = Arrays.asList(
            "Normal: Room Cleaned",
            "High: ICU Emergency",
            "Medium: Medicine Required",
            "High: Operation Alert"
        );

        Predicate<String> highPriority = msg -> msg.contains("High");

        System.out.println("High Priority Alerts:");
        alerts.stream()
                .filter(highPriority)
                .forEach(System.out::println);
    }
}

