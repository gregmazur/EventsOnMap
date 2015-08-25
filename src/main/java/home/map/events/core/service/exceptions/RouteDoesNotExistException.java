package home.map.events.core.service.exceptions;

/**
 * Created by greg on 26.08.15.
 */
public class RouteDoesNotExistException extends RuntimeException {
    public RouteDoesNotExistException(Throwable cause) {
        super(cause);
    }

    public RouteDoesNotExistException(String message, Throwable cause) {
        super(message, cause);
    }

    public RouteDoesNotExistException(String message) {
        super(message);
    }

    public RouteDoesNotExistException() {
    }
}
