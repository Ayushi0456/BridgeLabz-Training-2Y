import java.time.LocalDateTime;

class LateSubmissionException extends Exception {
    public LateSubmissionException(String msg) {
        super(msg);
    }
}

class InvalidFileFormatException extends Exception {
    public InvalidFileFormatException(String msg) {
        super(msg);
    }
}

public class Exam {

    static LocalDateTime deadline = LocalDateTime.now().minusMinutes(1); 
    public static void submitExam(String fileName, LocalDateTime submissionTime)
            throws LateSubmissionException, InvalidFileFormatException {

        if (!fileName.endsWith(".pdf"))
            throw new InvalidFileFormatException("Submission failed: invalid file format");

        if (submissionTime.isAfter(deadline))
            throw new LateSubmissionException("Submission failed: exam submitted late!");
    }

    public static void main(String[] args) {
        try {
            submitExam("answer.pdf", LocalDateTime.now());
            System.out.println("Exam submitted successfully!");
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }
}

