package home.map.events.dao;

import home.map.events.entity.Comment;
import home.map.events.entity.Event;
import home.map.events.entity.Route;
import home.map.events.entity.UserDetail;

import java.util.Collection;

/**
 * Created by greg on 20.07.15.
 */
public interface EventDAO {
    void addEvent(Event event,Route route);
    void removeEvent(Event event);
    void updateEvent(Event event);
    Event getEventByUserTagged(UserDetail user);
    Event getEventByUserCreated(UserDetail user);
    void addCommentToEvent (Comment comment, Event event);
    Collection<Comment> getCommentsOfEvent(Event  event);
    Collection<Event> getAllEvents();
}
