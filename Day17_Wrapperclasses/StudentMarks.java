import java.util.ArrayList;

public class StudentMarks {

    public static void main(String[] args) {
        Object[] inputs = {
            "85", 
            95, 
            "75",
            Integer.valueOf(88), 
            null, 
            "abc", 
            65,
            "90"
        };

        ArrayList<Integer> validMarks = new ArrayList<>();
        for (Object input : inputs) {

            if (input == null) {
                continue; 
            }

            try {
                Integer mark = null;

                if (input instanceof String) {
                    mark = Integer.valueOf((String) input);
                } 
                else if (input instanceof Integer) {
                    mark = (Integer) input;
                } 
                else if (input instanceof Number) {
                    
                    mark = ((Number) input).intValue();
                }
                if (mark != null) {
                    validMarks.add(mark);
                }

            } catch (Exception e) {
                
            }
        }

        System.out.println("Valid Marks: " + validMarks);

       
        double avg = 0.0;
        if (!validMarks.isEmpty()) {
            int sum = 0;
            for (int m : validMarks) {
                sum += m; 
            }
            avg = (double) sum / validMarks.size();
        }

        System.out.println(avg);
    }
}

