import java.util.ArrayList;
import java.util.Collections;

public class EmployeeAge {
    public static void main(String[] args) {
        
        int[] ages = {25, 32, 28, 45, 22, 39, 30};

        ArrayList<Integer> ageList = new ArrayList<>();

        for (int age : ages) {
            ageList.add(Integer.valueOf(age));  
        }

        int youngest = Collections.min(ageList);
        int oldest = Collections.max(ageList);

      
        System.out.println("Employee Ages (ArrayList): " + ageList);
        System.out.println("Youngest Employee Age: " + youngest);
        System.out.println("Oldest Employee Age: " + oldest);
    }
}

