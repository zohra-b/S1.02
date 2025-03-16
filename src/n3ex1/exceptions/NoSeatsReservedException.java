package n3ex1.exceptions;

public class NoSeatsReservedException extends RuntimeException {
    public NoSeatsReservedException(String message) {
        super(message);
    }
}
