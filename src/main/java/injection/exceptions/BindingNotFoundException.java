package injection.exceptions;

public class BindingNotFoundException extends RuntimeException {
    public BindingNotFoundException() {
        super("BindingNotFound");
    }
}
