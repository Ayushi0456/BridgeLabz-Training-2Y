import java.util.*;

class Faculty {
    private String name;
    public Faculty(String name){ this.name = name; }
    public String getName(){ return name; }
}

class Department {
    private String name;
    private List<Faculty> faculties = new ArrayList<>();
    public Department(String name){ this.name = name; }
    public void addFaculty(Faculty f){ faculties.add(f); }
    public void listFaculties(){
        System.out.println("Dept " + name + " faculties:");
        for(Faculty f : faculties) System.out.println("- " + f.getName());
    }
}

class University {
    private String name;
    private List<Department> departments = new ArrayList<>();
    public University(String name){ this.name = name; }
    public void addDepartment(Department d){ departments.add(d); }
    public void removeAllDepartments(){ departments.clear(); System.out.println("All departments removed."); }
    public void listDepartments(){
        System.out.println("University: " + name);
        for(Department d : departments) d.listFaculties();
    }
}

public class AggregationDemo {
    public static void main(String[] args){
        Faculty alice = new Faculty("Alice");
        Faculty bob = new Faculty("Bob");

        Department cs = new Department("Computer Science");
        cs.addFaculty(alice);
        cs.addFaculty(bob);

        University uni = new University("GLA University");
        uni.addDepartment(cs);

        uni.listDepartments();

        
        uni.removeAllDepartments();
   
        System.out.println("Faculty still exist: " + alice.getName() + ", " + bob.getName());
    }
}

