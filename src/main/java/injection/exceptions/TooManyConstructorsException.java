package injection.exceptions;

public class TooManyConstructorsException extends RuntimeException {
    public TooManyConstructorsException() {
        super("TooManyConstructors");
    }
}
