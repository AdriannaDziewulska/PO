public class InvalidRatingException extends Exception {
    public InvalidRatingException(int score) {
        super("Nieprawidłowa ocena: " + score + ". Dozwolony zakres: 0-5.");
        }
        }