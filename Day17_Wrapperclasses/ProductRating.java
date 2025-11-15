import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Objects;

public class ProductRating {

    public static void main(String[] args) {

        int[] primitiveRatings = {5, 4, 3, 5, 2};
        ArrayList<Integer> objectRatings = new ArrayList<>(
                Arrays.asList(4, null, 5, 3, null, 4)
        );
        ArrayList<Integer> finalRatings = new ArrayList<>();
        for (int r : primitiveRatings) {
            finalRatings.add(r);  
        }
        finalRatings.addAll(objectRatings);

        System.out.println("Combined Ratings (with nulls): " + finalRatings);
        List<Integer> validRatings = finalRatings.stream()
                .filter(Objects::nonNull)
                .toList();

        System.out.println("Valid Ratings (null removed): " + validRatings);
        double average = 0.0;

        if (!validRatings.isEmpty()) {
            int sum = 0;
            for (int rating : validRatings) {
                sum += rating;
            }
            average = (double) sum / validRatings.size();
        }System.out.println(average);

      
    }
}

