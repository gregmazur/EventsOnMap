package home.map.events.service.service.impl;

import home.map.events.dao.CommentDAO;
import home.map.events.dao.EventDAO;
import home.map.events.dao.RouteDAO;
import home.map.events.dao.UserDAO;
import home.map.events.entity.*;
import home.map.events.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.Collection;

/**
 * Created by greg on 16.07.15.
 */
@Transactional
@Service
public class UserServiceImpl implements UserService {
    @Autowired
    private UserDAO userDAO;
    @Autowired
    private EventDAO eventDAO;
    @Autowired
    private RouteDAO routeDAO;
    @Autowired
    private CommentDAO commentDAO;


    public Collection<Event> getAllEvents() {
        return eventDAO.findAll();
    }

    public Collection<Route> getAllRoutes() {
        return routeDAO.findAll();
    }

    public Collection<Event> getEventsCreatedByUser(UserDetail user) {
        return eventDAO.getEventsCreatedByUser(user);
    }

    public Collection<Route> getRoutesCreatedByUser(UserDetail user) {
        return routeDAO.getRoutesCreatedByUser(user);
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
@RequestMapping
    public UserDetail login(String login, String password) {
        return userDAO.getUser(login, password);
    }


    public void deleteUser(UserDetail userDetail) {
        userDAO.delete(userDetail);
    }
}
