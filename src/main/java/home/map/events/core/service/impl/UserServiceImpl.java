package home.map.events.core.service.impl;

import home.map.events.core.entity.Comment;
import home.map.events.core.entity.Event;
import home.map.events.core.entity.Route;
import home.map.events.core.entity.UserDetail;
import home.map.events.core.service.UserService;
import home.map.events.core.service.exceptions.RouteExistsException;
import home.map.events.core.service.exceptions.UserDoesNotExistException;
import home.map.events.core.service.exceptions.UserExistsException;
import home.map.events.dao.CommentDAO;
import home.map.events.dao.EventDAO;
import home.map.events.dao.RouteDAO;
import home.map.events.dao.UserDAO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Collection;

/**
 * Created by greg on 26.08.15.
 */
@Service @Transactional public class UserServiceImpl implements UserService {
    @Autowired private UserDAO userDAO;
    @Autowired private RouteDAO routeDAO;
    @Autowired private EventDAO eventDAO;
    @Autowired private CommentDAO commentDAO;

    @Override public UserDetail getByID(Long id) {
        return userDAO.findOne(id);
    }

    @Override public Route addRoute(Route route, Long userId) {
        Route routeFromDB = routeDAO.findByName(route.getName());
        if (routeFromDB != null) {
            throw new RouteExistsException();
        }
        UserDetail userDetail = userDAO.findOne(userId);
        if (userDetail == null) {
            throw new UserDoesNotExistException();
        }
        route.setCreatedBy(userDetail);
        Route createdRoute = routeDAO.saveAndFlush(route);
        userDetail.increaseQuantityOfRoutesPosted();
        userDAO.saveAndFlush(userDetail);
        return createdRoute;
    }

    @Override public UserDetail updateUser(UserDetail user) {
        UserDetail fromDB = userDAO.findOne(user.getId());
        if (fromDB == null) {
            throw new UserDoesNotExistException();
        }
        return userDAO.saveAndFlush(user);
    }

    @Override public UserDetail addUser(UserDetail userDetail) {
        UserDetail userDetail1 = userDAO.findByLogin(userDetail.getName());
        if (userDetail1 != null) {
            throw new UserExistsException();
        }
        return userDAO.saveAndFlush(userDetail);
    }

    @Override public void deleteUser(UserDetail userDetail) {
        //TODO
    }

    @Override public Collection<Route> getRoutesCreatedByUser(Long userId) {
        return routeDAO.findByCreatedBy(userId);
    }

    @Override public Collection<Event> getEventsCreatedByUser(Long userId) {
        return eventDAO.findByCreatedBy(userId);
    }

    @Override public Collection<Comment> getCommentsLeftByUser(Long userId) {
        return commentDAO.findByCreatedBy(userId);
    }
}
