package home.map.events.core.service.exceptions;

/**
 * Created by Chris on 6/28/14.
 */
public class RouteNotFoundException extends RuntimeException {
    public RouteNotFoundException(String message, Throwable cause) {
        super(message, cause);
    }

    public RouteNotFoundException(String message) {
        super(message);
    }

    public RouteNotFoundException() {
    }
}
