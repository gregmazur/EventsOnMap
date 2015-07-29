package home.map.events.service;

import home.map.events.entity.*;

import java.util.Collection;

/**
 * Created by greg on 16.07.15.
 */
public interface UserService {

    Collection<Event> getAllEvents();

    Collection<Route> getAllRoutes();

    Collection<Event> getEventsCreatedByUser(UserDetail user);

    Collection<Route> getRoutesCreatedByUser(UserDetail user);

    Collection<Event> getEventsNearEvent(Event event);

    Collection<Event> getEventsNearPoint(Point point);

    Collection<Route> getRouteNearPoint(Point point);

    Collection<UserDetail> getUsersTaggedInEvent(Event event);

    Collection<UserDetail> getUsersTaggedInRoute(Route route);

    boolean addEventToRoute(Event event,Route route);

    Comment addCommentToEvent(Event event, String text);

    boolean removeEvent();

    boolean editEvent(Event event, UserDetail user);

    boolean addRoute(Route route);

    boolean editRoute(Route route, UserDetail user);

    boolean removeRoute(Route route, UserDetail user);

    Comment addCommentToRoute(Route route, String text);

    boolean editComment(Comment comment, UserDetail user);
    /*
    User
     */
    UserDetail editUser(UserDetail userDetail);

    UserDetail createUser(UserDetail userDetail);

    UserDetail login (String login, String password);

    void deleteUser(UserDetail userDetail);

}
