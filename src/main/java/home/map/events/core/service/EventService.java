package home.map.events.core.service;

import home.map.events.core.entity.Comment;
import home.map.events.core.entity.Event;
import home.map.events.core.entity.Point;
import home.map.events.core.entity.UserDetail;
import org.springframework.stereotype.Service;

import java.util.Collection;

/**
 * Created by greg on 23.08.15.
 */
@Service public interface EventService {

    Event getById(Long id);

    Collection<Event> getAllEvents();

    Collection<Event> getEventsCreatedByUser(UserDetail user);

    Collection<Event> getEventsNearEvent(Long eventId);

    Collection<Event> getEventsNearPoint(Point point);

    Event removeEvent(Long id);

    Event updateEvent(Event event, Long id);

    Comment addCommentToEvent(Event event, Comment comment);

}
