import java.util.*;

class Student implements Comparable<Student> {
    String name;
    int marks;
    Student(String n,int m){name=n;marks=m;}
    public int compareTo(Student o){return o.marks - this.marks;}
}

public class Admission {
    List<Student> applicants = new ArrayList<>();
    Set<Student> shortlisted = new HashSet<>();
    Queue<Student> interview = new LinkedList<>();
    TreeSet<Student> merit = new TreeSet<>();

    void accept(Student s){ applicants.add(s); }
    void shortlist() { for(Student s:applicants) if(s.marks>=60) shortlisted.add(s); }
    void queueInterviews() { interview.addAll(shortlisted); }
    void finalizeList() { while(!interview.isEmpty()) merit.add(interview.poll()); }

    public static void main(String[] args){
        Admission a = new Admission ();
        a.accept(new Student("A",70));
        a.accept(new Student("B",55));
        a.shortlist();
        a.queueInterviews();
        a.finalizeList();
    }
}

