package n3ex1.exceptions;

public class OccupiedSeatException extends RuntimeException {
    public OccupiedSeatException(String message) {
        super(message);
    }
}
