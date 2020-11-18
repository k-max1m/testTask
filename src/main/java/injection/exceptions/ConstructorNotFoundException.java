package injection.exceptions;

public class ConstructorNotFoundException extends RuntimeException {
    public ConstructorNotFoundException() {
        super("ConstructorNotFound");
    }
}
