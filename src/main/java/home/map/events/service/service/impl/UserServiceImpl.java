package home.map.events.service.service.impl;

import home.map.events.entity.Event;
import home.map.events.entity.Route;
import home.map.events.entity.UserDetail;
import home.map.events.service.UserService;

import java.util.Collection;

/**
 * Created by greg on 16.07.15.
 */
public class UserServiceImpl implements UserService {



    public Collection<Event> getEvents() {
        return null;
    }

    public Collection<Route> getRoutes() {
        return null;
    }

    public Collection<Event> getEventsCreatedByUser(UserDetail user) {
        return null;
    }

    public Collection<Route> getRoutesCreatedByUser(UserDetail user) {
        return null;
    }

    public boolean addEventToRoute(Event event, Route route) {
        return false;
    }

    public boolean removeEvent() {
        return false;
    }

    public boolean addRoute(Route route) {
        return false;
    }

    public boolean removeRoute(Route route) {
        return false;
    }

    public boolean addEventToRoute(Route route, Event event) {
        return false;
    }

    public boolean addCommentToRoute(Route route, String text) {
        return false;
    }

    public boolean addCommentToEvent(Event event, String text) {
        return false;
    }

}
