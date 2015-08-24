package home.map.events.core.service.exceptions;

/**
 * Created by Chris on 6/30/14.
 */
public class UserExistsException extends RuntimeException {
    public UserExistsException(String message, Throwable cause) {
        super(message, cause);
    }

    public UserExistsException(String message) {
        super(message);
    }

    public UserExistsException() {
        super();
    }
}
