import java.util.*;
import java.util.Stack;

class Question {
    String text;

    public Question(String text) {
        this.text = text;
    }

    public String toString() {
        return text;
    }
}

class Student {
    String id;

    public Student(String id) {
        this.id = id;
    }

    public String toString() {
        return id;
    }
}

public class ExaminationSystem {
    public static void main(String[] args) {

        Set<String> studentIDs = new HashSet<>();
        studentIDs.add("S101");
        studentIDs.add("S102");
        studentIDs.add("S101"); 

        
        List<Question> questions = new ArrayList<>();
        questions.add(new Question("What is Java?"));
        questions.add(new Question("Explain OOP."));
        questions.add(new Question("Define Interface."));
        Collections.shuffle(questions);

      
        Queue<Student> examQueue = new LinkedList<>();
        examQueue.add(new Student("S101"));
        examQueue.add(new Student("S102"));

        
        Stack<Question> navStack = new Stack<>();

        System.out.println("Serving students...");
        while (!examQueue.isEmpty()) {
            Student s = examQueue.poll();
            System.out.println("Student taking test: " + s);

            for (Question q : questions) {
                System.out.println("Current Question: " + q);
                navStack.push(q);
            }

            System.out.println("Using BACK button:");
            while (!navStack.isEmpty()) {
                System.out.println("Back to: " + navStack.pop());
            }
        }
    }
}

