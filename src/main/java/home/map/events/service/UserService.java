package home.map.events.service;

import home.map.events.entity.Event;
import home.map.events.entity.Route;
import home.map.events.entity.UserDetail;

import java.util.Collection;

/**
 * Created by greg on 16.07.15.
 */
public interface UserService {

    Collection<Event> getEvents();

    Collection<Route> getRoutes();

    Collection<Event> getEventsCreatedByUser(UserDetail user);

    Collection<Route> getRoutesCreatedByUser(UserDetail user);

    boolean addEventToRoute(Event event,Route route);

    boolean removeEvent();

    boolean addRoute(Route route);

    boolean removeRoute(Route route);

    boolean addEventToRoute(Route route, Event event);

    boolean addCommentToRoute(Route route, String text);

    boolean addCommentToEvent(Event event, String text);

}
