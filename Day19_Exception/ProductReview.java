class InvalidRatingException extends Exception {
    public InvalidRatingException(String msg) {
        super(msg);
    }
}

class EmptyReviewException extends Exception {
    public EmptyReviewException(String msg) {
        super(msg);
    }
}

public class ProductReview {
    public static void main(String[] args) {

        try {
            submitReview(5, "Great product!");
            submitReview(7, "Bad");
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }

    public static void submitReview(int rating, String comment)
            throws InvalidRatingException, EmptyReviewException {

        if (rating < 1 || rating > 5)
            throw new InvalidRatingException("Rating must be between 1 and 5!");

        if (comment == null || comment.trim().isEmpty())
            throw new EmptyReviewException("Review cannot be empty!");

        System.out.println("Review submitted successfully!");
    }
}

