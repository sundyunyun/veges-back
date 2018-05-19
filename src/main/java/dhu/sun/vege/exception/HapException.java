package dhu.sun.vege.exception;

/**
 * Created by Think on 2017/11/15.
 */
public class HapException extends RuntimeException {
    private final transient Object[] parameters;

    public HapException(String message) {
        this(message, (Object[])null);
    }

    public HapException(String message, Object... parameters) {
        super(message);
        this.parameters = parameters;
    }

    public Object[] getParameters() {
        return this.parameters;
    }
}
