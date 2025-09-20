import java.util.ArrayList;
import java.util.List;

// MedicalRecord Interface
interface MedicalRecord {
    void addRecord(String record);
    void viewRecords();
}

// Abstract Patient class
abstract class Patient {
    private String patientID;
    private String name;
    private int age;

    // Encapsulated sensitive data
    private String diagnosis;
    private List<String> medicalHistory;

    // Constructor
    public Patient(String patientID, String name, int age, String diagnosis) {
        this.patientID = patientID;
        this.name = name;
        this.age = age;
        this.diagnosis = diagnosis;
        this.medicalHistory = new ArrayList<>();
    }

    // Abstract method for billing
    public abstract double calculateBill();

    // Concrete method
    public void getPatientDetails() {
        System.out.println("Patient ID: " + patientID);
        System.out.println("Name: " + name);
        System.out.println("Age: " + age);
        System.out.println("Diagnosis: " + diagnosis);
    }

    // Encapsulation (restricted access)
    protected void addToMedicalHistory(String record) {
        medicalHistory.add(record);
    }

    protected List<String> getMedicalHistory() {
        return medicalHistory;
    }
}

// InPatient subclass
class InPatient extends Patient implements MedicalRecord {
    private int daysAdmitted;
    private double dailyRate;
    private List<String> records;

    public InPatient(String patientID, String name, int age, String diagnosis, int daysAdmitted, double dailyRate) {
        super(patientID, name, age, diagnosis);
        this.daysAdmitted = daysAdmitted;
        this.dailyRate = dailyRate;
        this.records = new ArrayList<>();
    }

    @Override
    public double calculateBill() {
        return daysAdmitted * dailyRate;
    }

    @Override
    public void addRecord(String record) {
        records.add(record);
        addToMedicalHistory(record); // updates sensitive history
    }

    @Override
    public void viewRecords() {
        System.out.println("Medical Records for In-Patient:");
        for (String rec : records) {
            System.out.println("- " + rec);
        }
    }
}

// OutPatient subclass
class OutPatient extends Patient implements MedicalRecord {
    private double consultationFee;
    private List<String> records;

    public OutPatient(String patientID, String name, int age, String diagnosis, double consultationFee) {
        super(patientID, name, age, diagnosis);
        this.consultationFee = consultationFee;
        this.records = new ArrayList<>();
    }

    @Override
    public double calculateBill() {
        return consultationFee;
    }

    @Override
    public void addRecord(String record) {
        records.add(record);
        addToMedicalHistory(record);
    }

    @Override
    public void viewRecords() {
        System.out.println("Medical Records for Out-Patient:");
        for (String rec : records) {
            System.out.println("- " + rec);
        }
    }
}

// Main class
public class PatientManagementSystem {
    // Polymorphic method to display billing
    public static void processPatient(Patient patient) {
        patient.getPatientDetails();
        System.out.println("Total Bill: " + patient.calculateBill());
        if (patient instanceof MedicalRecord) {
            ((MedicalRecord) patient).viewRecords();
        }
        System.out.println("---------------------------");
    }

    public static void main(String[] args) {
        Patient p1 = new InPatient("P001", "Ravi Kumar", 45, "Pneumonia", 5, 2000);
        Patient p2 = new OutPatient("P002", "Sita Devi", 30, "Flu", 500);

        // Add medical records
        ((MedicalRecord) p1).addRecord("Admitted for Pneumonia treatment.");
        ((MedicalRecord) p1).addRecord("Given Antibiotics.");
        
        ((MedicalRecord) p2).addRecord("Consulted for seasonal flu.");
        ((MedicalRecord) p2).addRecord("Prescribed paracetamol.");

        // Process patients polymorphically
        processPatient(p1);
        processPatient(p2);
    }
}

