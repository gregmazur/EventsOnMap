package home.map.events.core.service.impl;

import home.map.events.core.entity.*;
import home.map.events.core.service.RouteService;
import home.map.events.core.service.exceptions.RouteDoesNotExistException;
import home.map.events.core.service.exceptions.RouteExistsException;
import home.map.events.core.service.exceptions.UserDoesNotExistException;
import home.map.events.core.service.util.RouteList;
import home.map.events.dao.CommentDAO;
import home.map.events.dao.EventDAO;
import home.map.events.dao.RouteDAO;
import home.map.events.dao.UserDAO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

/**
 * Created by greg on 28.08.15.
 */
@Service @Transactional public class RouteServiceImpl implements RouteService {
    @Autowired private RouteDAO routeDAO;
    @Autowired private EventDAO eventDAO;
    @Autowired private UserDAO userDAO;
    @Autowired private CommentDAO commentDAO;

    @Override public Route getById(Long id) {
        return routeDAO.findOne(id);
    }

    @Override public RouteList getAllRoutes() {
        return new RouteList(routeDAO.findAll());
    }

    @Override public RouteList getAllRoutesOfUser(Long userId) {
        UserDetail fromDB = userDAO.findOne(userId);
        if (fromDB == null) {
            throw new UserDoesNotExistException();
        }
        return new RouteList(routeDAO.findByCreatedBy(userId));
    }

    @Override public RouteList getRouteNearPoint(Point point) {
        return null;
    }

    @Override public Event addEventToRoute(Long routeId, Event event, Long userId) {
        Event eventFromDB = eventDAO.findByName(event.getName());
        if (eventFromDB != null) {
            throw new RouteExistsException();
        }
        UserDetail userDetail = userDAO.findOne(userId);
        if (userDetail == null) {
            throw new UserDoesNotExistException();
        }
        Route route = routeDAO.findOne(routeId);
        if (route == null) {
            throw new RouteDoesNotExistException();
        }
        event.setRoute(route);
        event.setCreatedBy(userDetail);
        Event createdEvent = eventDAO.saveAndFlush(event);
        userDetail.getQuantityOfEventsPosted();
        userDAO.saveAndFlush(userDetail);
        return createdEvent;
    }

    @Override public Route removeRoute(long id) {
        return null;
    }

    @Override public Comment addCommentToRoute(Long routeId, String text, Long userId) {
        UserDetail userDetail = userDAO.findOne(userId);
        if (userDetail == null) {
            throw new UserDoesNotExistException();
        }
        Route route = routeDAO.findOne(routeId);
        if (route == null) {
            throw new RouteDoesNotExistException();
        }
        Comment comment = new Comment(text);
        comment.setOwnerRoute(route);
        comment.setCreatedBy(userDetail);
        Comment createdComment = commentDAO.saveAndFlush(comment);
        userDetail.increaseQuantityOfCommentsLeft();
        userDAO.saveAndFlush(userDetail);
        return createdComment;
    }
}
