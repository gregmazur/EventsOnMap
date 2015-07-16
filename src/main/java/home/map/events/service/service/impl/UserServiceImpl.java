package home.map.events.service.service.impl;

import home.map.events.entity.Event;
import home.map.events.entity.Route;
import home.map.events.entity.UserDetail;
import home.map.events.service.UserService;
import home.map.events.service.Validation.LoginValidation;

import java.util.Collection;

/**
 * Created by greg on 16.07.15.
 */
public class UserServiceImpl implements UserService {


    public LoginValidation getLoginValidation() {
        return null;
    }

    public Collection<Event> showEvents() {
        return null;
    }

    public Collection<Route> showRoutes() {
        return null;
    }

    public Collection<Event> showEventsForUser(UserDetail user) {
        return null;
    }

    public Collection<Route> showRoutesForUser(UserDetail user) {
        return null;
    }

    public boolean addRoute(Route route) {
        return false;
    }

    public boolean addCommentToRoute(Route route, String text) {
        return false;
    }

    public boolean addCommentToEvent(Event event, String text) {
        return false;
    }

}
