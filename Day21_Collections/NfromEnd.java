import java.util.*;

public class NfromEnd {

    public static <T> T getNthFromEnd(LinkedList<T> list, int n) {
        
        Iterator<T> slow = list.iterator();
        Iterator<T> fast = list.iterator();

        for (int i = 0; i < n; i++) {
            if (fast.hasNext()) {
                fast.next();
            } else {
                return null; 
            }
        }

        while (fast.hasNext()) {
            fast.next();
            slow.next();
        }

        return slow.next();
    }

    public static void main(String[] args) {

        LinkedList<String> list = new LinkedList<>(Arrays.asList("A", "B", "C", "D", "E"));

        int n = 2;
        String result = getNthFromEnd(list, n);

        System.out.println("List: " + list);
        System.out.println(n + "th element from the end: " + result);
    }
}

