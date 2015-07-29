package home.map.events.service.service.impl;

import home.map.events.dao.UserDAO;
import home.map.events.entity.*;
import home.map.events.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Collection;

/**
 * Created by greg on 16.07.15.
 */
@Service
public class UserServiceImpl implements UserService {
    @Autowired
    private UserDAO userDAO;


    public Collection<Event> getAllEvents() {
        return null;
    }

    public Collection<Route> getAllRoutes() {
        return null;
    }

    public Collection<Event> getEventsCreatedByUser(UserDetail user) {
        return null;
    }

    public Collection<Route> getRoutesCreatedByUser(UserDetail user) {
        return null;
    }

    public Collection<Event> getEventsNearEvent(Event event) {
        return null;
    }

    public Collection<Event> getEventsNearPoint(Point point) {
        return null;
    }

    public Collection<Route> getRouteNearPoint(Point point) {
        return null;
    }

    public Collection<UserDetail> getUsersTaggedInEvent(Event event) {
        return null;
    }

    public Collection<UserDetail> getUsersTaggedInRoute(Route route) {
        return null;
    }

    public boolean addEventToRoute(Event event, Route route) {
        return false;
    }

    public Comment addCommentToEvent(Event event, String text) {
        return null;
    }

    public boolean removeEvent() {
        return false;
    }

    public boolean editEvent(Event event, UserDetail user) {
        return false;
    }

    public boolean addRoute(Route route) {
        return false;
    }

    public boolean editRoute(Route route, UserDetail user) {
        return false;
    }

    public boolean removeRoute(Route route, UserDetail user) {
        return false;
    }

    public Comment addCommentToRoute(Route route, String text) {
        return null;
    }

    public boolean editComment(Comment comment, UserDetail user) {
        return false;
    }

    public UserDetail editUser(UserDetail userDetail) {
        return userDAO.saveAndFlush(userDetail);
    }

    public UserDetail createUser(UserDetail userDetail) {
        return userDAO.saveAndFlush(userDetail);
    }

    public UserDetail login(String login, String password) {
        return userDAO.getUser(login, password);
    }

    public void deleteUser(UserDetail userDetail) {
        userDAO.delete(userDetail);
    }
}
