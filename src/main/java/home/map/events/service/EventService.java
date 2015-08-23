package home.map.events.service;

import home.map.events.entity.Event;
import home.map.events.entity.Point;
import home.map.events.entity.Route;
import home.map.events.entity.UserDetail;

import java.util.Collection;

/**
 * Created by greg on 23.08.15.
 */
public interface EventService {
    Collection<Event> getAllEvents();

    Collection<Event> getEventsCreatedByUser(UserDetail user);

    Collection<Event> getEventsNearEvent(Event event);

    Collection<Event> getEventsNearPoint(Point point);

    boolean addEventToRoute(Event event, Route route);

    boolean removeEvent(UserDetail userDetail);

    boolean editEvent(Event event, UserDetail user);

}
