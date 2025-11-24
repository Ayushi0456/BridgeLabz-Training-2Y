import java.util.*;

public class BinaryNumber {

    public static List<String> generateBinary(int n) {
        List<String> result = new ArrayList<>();
        Queue<String> q = new LinkedList<>();

        q.add("1"); 

        while(n-- > 0) {
            String current = q.remove(); 
            result.add(current);

            
            q.add(current + "0");
            q.add(current + "1");
        }

        return result;
    }

    public static void main(String[] args) {
        int N = 5;
        System.out.println(generateBinary(N));
    }
}

