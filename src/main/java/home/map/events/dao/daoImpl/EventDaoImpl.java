package home.map.events.dao.daoImpl;

import home.map.events.dao.EventDAO;
import home.map.events.entity.Comment;
import home.map.events.entity.Event;
import home.map.events.entity.Route;
import home.map.events.entity.UserDetail;

import java.util.Collection;

/**
 * Created by greg on 20.07.15.
 */
public class EventDaoImpl extends DAOUtils<Event> implements EventDAO{

    public void addEvent(Event event, Route route) {

    }

    public void removeEvent(Event event) {

    }

    public void updateEvent(Event event) {

    }

    public Event getEventByUserTagged(UserDetail user) {
        return null;
    }

    public Event getEventByUserCreated(UserDetail user) {
        return null;
    }

    public void addCommentToEvent(Comment comment, Event event) {

    }

    public Collection<Comment> getCommentsOfEvent(Event event) {
        return null;
    }

    public Collection<Event> getAllEvents() {
        return null;
    }
}
