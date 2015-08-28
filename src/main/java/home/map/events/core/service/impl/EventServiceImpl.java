package home.map.events.core.service.impl;

import home.map.events.core.entity.Comment;
import home.map.events.core.entity.Event;
import home.map.events.core.entity.Route;
import home.map.events.core.entity.UserDetail;
import home.map.events.core.service.EventService;
import home.map.events.core.service.exceptions.RouteDoesNotExistException;
import home.map.events.core.service.exceptions.UserDoesNotExistException;
import home.map.events.core.service.util.EventList;
import home.map.events.dao.CommentDAO;
import home.map.events.dao.EventDAO;
import home.map.events.dao.RouteDAO;
import home.map.events.dao.UserDAO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Collection;

/**
 * Created by greg on 28.08.15.
 */
@Service @Transactional public class EventServiceImpl implements EventService {
    @Autowired private EventDAO eventDAO;
    @Autowired private UserDAO userDAO;
    @Autowired private RouteDAO routeDAO;
    @Autowired private CommentDAO commentDAO;

    @Override public Event getById(Long id) {
        return eventDAO.findOne(id);
    }

    @Override public EventList getAllEvents() {
        return new EventList(eventDAO.findAll());
    }

    @Override public EventList getAllEventsOfUser(Long userId) {
        UserDetail fromDB = userDAO.findOne(userId);
        if (fromDB == null) {
            throw new UserDoesNotExistException();
        }
        return new EventList(eventDAO.findByCreatedBy(userId));
    }

    @Override public EventList getAllEventsOfRoute(Long routeId) {
        Route fromDB = routeDAO.findOne(routeId);
        if (fromDB == null) {
            throw new RouteDoesNotExistException();
        }
        return new EventList(eventDAO.findByRoute(fromDB));
    }


    @Override public Collection<Event> getEventsNearEvent(Long eventId) {
        return null;
    }

    @Override public Event removeEvent(Long id) {
        //TODO
        return null;
    }

    @Override public Comment addCommentToEvent(Long eventId, String text, Long userId) {
        UserDetail userDetail = userDAO.findOne(userId);
        if (userDetail == null) {
            throw new UserDoesNotExistException();
        }
        Event event = eventDAO.findOne(eventId);
        if (event == null) {
            throw new RouteDoesNotExistException();
        }
        Comment comment = new Comment(text);
        comment.setOwnerEvent(event);
        comment.setCreatedBy(userDetail);
        Comment createdComment = commentDAO.saveAndFlush(comment);
        userDetail.increaseQuantityOfCommentsLeft();
        userDAO.saveAndFlush(userDetail);
        return createdComment;
    }
}
