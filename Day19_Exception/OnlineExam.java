import java.io.IOException;

class InvalidStudentException extends Exception {
    public InvalidStudentException(String msg) {
        super(msg);
    }
}

public class OnlineExam {

    static void validateStudent() throws InvalidStudentException {
        throw new InvalidStudentException("Invalid student ID!");
    }

    static void submitExam() throws InvalidStudentException, IOException {
        validateStudent();
        throw new IOException("File error while submitting!");
    }

    public static void main(String[] args) {
        try {
            submitExam();
        } catch (InvalidStudentException e) {
            System.out.println("Student Error: " + e.getMessage());
        } catch (IOException e) {
            System.out.println("IO Error: " + e.getMessage());
        } finally {
            System.out.println("Exam submission process completed.");
        }
    }
}

