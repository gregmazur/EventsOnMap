package home.map.events.core.service;

import home.map.events.core.entity.Comment;
import home.map.events.core.entity.Event;
import home.map.events.core.service.util.EventList;

import java.util.Collection;

/**
 * Created by greg on 23.08.15.
 */

public interface EventService {

    Event getById(Long id);

    EventList getAllEvents();

    EventList getAllEventsOfUser(Long userId);

    EventList getAllEventsOfRoute(Long routeId);

    Collection<Event> getEventsNearEvent(Long eventId);

    Event removeEvent(Long id);

    Comment addCommentToEvent(Long eventId, String comment, Long userId);

}
