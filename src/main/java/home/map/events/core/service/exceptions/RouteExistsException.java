package home.map.events.core.service.exceptions;

/**
 * Created by Chris on 6/30/14.
 */
public class RouteExistsException extends RuntimeException {
    public RouteExistsException() {
    }

    public RouteExistsException(String message) {
        super(message);
    }

    public RouteExistsException(String message, Throwable cause) {
        super(message, cause);
    }

    public RouteExistsException(Throwable cause) {
        super(cause);
    }
}
