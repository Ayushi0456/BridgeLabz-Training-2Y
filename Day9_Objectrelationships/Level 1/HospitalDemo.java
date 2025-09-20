import java.util.*;

class Patient {
    private String name;
    public Patient(String name){ this.name = name; }
    public String getName(){ return name; }
}

class Doctor {
    private String name;
    private List<Patient> patients = new ArrayList<>();
    public Doctor(String name){ this.name = name; }
    public void addPatient(Patient p){ patients.add(p); }
    public void consult(Patient p, String notes){
      
        System.out.println("Dr. " + name + " consulting " + p.getName() + ": " + notes);
    }
    public void listPatients(){
        System.out.println("Dr. " + name + " patients:");
        for(Patient p : patients) System.out.println("- " + p.getName());
    }
}

class Hospital {
    private String name;
    private List<Doctor> doctors = new ArrayList<>();
    public Hospital(String name){ this.name = name; }
    public void addDoctor(Doctor d){ doctors.add(d); }
}

public class HospitalDemo {
    public static void main(String[] args){
        Doctor drSmith = new Doctor("Smith");
        Patient p1 = new Patient("Ravi");
        Patient p2 = new Patient("Meera");

        drSmith.addPatient(p1);
        drSmith.addPatient(p2);
        drSmith.consult(p1, "Check blood pressure.");
        drSmith.consult(p2, "Review test results.");

        drSmith.listPatients();
    }
}

