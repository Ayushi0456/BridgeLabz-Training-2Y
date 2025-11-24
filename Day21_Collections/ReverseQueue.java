import java.util.*;

public class ReverseQueue {
    
    
    public static void reverseQueue(Queue<Integer> q) {
       
        if (q.isEmpty()) {
            return;
        }

       
        int element = q.remove();

        
        reverseQueue(q);

      
        q.add(element);
    }

    public static void main(String[] args) {
        Queue<Integer> q = new LinkedList<>();
        q.add(10);
        q.add(20);
        q.add(30);

        System.out.println("Original Queue: " + q);

        reverseQueue(q);

        System.out.println("Reversed Queue: " + q);
    }
}

    

