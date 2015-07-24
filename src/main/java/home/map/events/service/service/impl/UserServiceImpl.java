package home.map.events.service.service.impl;

import home.map.events.dao.CommentDAO;
import home.map.events.dao.EventDAO;
import home.map.events.dao.RouteDAO;
import home.map.events.dao.UserDAO;
import home.map.events.dao.daoImpl.*;
import home.map.events.entity.*;
import home.map.events.service.UserService;

import java.util.Collection;

/**
 * Created by greg on 16.07.15.
 */
public class UserServiceImpl implements UserService {
    private UserDAO userDAO = new UserDaoImpl();
    private RouteDAO routeDAO = new RouteDaoImpl();
    private EventDAO eventDAO = new EventDaoImpl();
    private CommentDAO commentDAO = new CommentDaoImpl();


    public Collection<Event> getEvents() {
        return eventDAO.getAllEvents();
    }

    public Collection<Route> getRoutes() {
        return routeDAO.getAllRoutes();
    }

    public Collection<Event> getEventsCreatedByUser(UserDetail user) {
        return eventDAO.getEventsCreatedByUser(user);
    }

    public Collection<Route> getRoutesCreatedByUser(UserDetail user) {
        return routeDAO.getRoutesCreatedByUser(user);
    }

    public Collection<Event> getEventsNearEvent(Event event) {
        //TODO
        return null;
    }

    public Collection<Event> getEventsNearPoint(Point point) {
        //TODO
        return null;
    }

    public Collection<Route> getRouteNearPoint(Point point) {
        //TODO
        return null;
    }

    public Collection<UserDetail> getUsersTaggedInEvent(Event event) {
        return event.getUsersTagged();
    }

    public Collection<UserDetail> getUsersTaggedInRoute(Route route) {
        return route.getUsersTagged();
    }
//in condition that the route already has been saved
    public boolean addEventToRoute(Event event, Route route) {
        try {
            route.addEvent(event);
            routeDAO.updateRoute(route);
            return true;
        } catch (WritingDataException e) {
            e.printStackTrace();
        }
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

    public boolean editUser(UserDetail userDetail) {
        return false;
    }
}
