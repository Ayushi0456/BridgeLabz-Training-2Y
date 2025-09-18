class Patient {
    static String hospitalName = "City Hospital";
    static int totalPatients = 0;

    final int patientID;
    String name;
    int age;
    String ailment;

    Patient(int patientID, String name, int age, String ailment) {
        this.patientID = patientID;
        this.name = name;
        this.age = age;
        this.ailment = ailment;
        totalPatients++;
    }

    static void getTotalPatients() {
        System.out.println("Total Patients: " + totalPatients);
    }

    void displayPatientDetails() {
        if (this instanceof Patient) {
            System.out.println("PatientID: " + patientID + ", Name: " + name +
                               ", Age: " + age + ", Ailment: " + ailment +
                               ", Hospital: " + hospitalName);
        }
    }

    public static void main(String[] args) {
        Patient p1 = new Patient(1, "Suman", 45, "Fever");
        Patient p2 = new Patient(2, "Ravi", 30, "Cough");
        p1.displayPatientDetails();
        p2.displayPatientDetails();
        Patient.getTotalPatients();
    }
}

