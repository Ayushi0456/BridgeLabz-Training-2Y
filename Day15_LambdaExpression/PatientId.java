import java.util.*;

public class PatientId {

    public static void printID(String id) {
        System.out.println("Patient ID: " + id);
    }

    public static void main(String[] args) {

        List<String> ids = Arrays.asList("P101", "P102", "P103");

        ids.forEach(PatientId::printID);
    }
}

