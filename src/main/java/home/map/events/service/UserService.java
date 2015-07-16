package home.map.events.service;

import home.map.events.entity.Event;
import home.map.events.entity.Route;
import home.map.events.entity.UserDetail;
import home.map.events.service.Validation.LoginValidation;

import java.util.Collection;

/**
 * Created by greg on 16.07.15.
 */
public interface UserService {
    LoginValidation getLoginValidation();
    Collection<Event> showEvents();
    Collection<Route> showRoutes();
    Collection<Event> showEventsForUser(UserDetail user);
    Collection<Route> showRoutesForUser(UserDetail user);
    boolean addRoute(Route route);
    boolean addCommentToRoute(Route route, String text);
    boolean addCommentToEvent(Event event, String text);

}
