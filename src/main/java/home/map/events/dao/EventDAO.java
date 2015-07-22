package home.map.events.dao;

import home.map.events.dao.daoImpl.WritingDataException;
import home.map.events.entity.Event;
import home.map.events.entity.UserDetail;

import java.util.Collection;

/**
 * Created by greg on 22.07.15.
 */
public interface EventDAO {
    void addEvent(Event event) throws WritingDataException;

    void updateEvent(Event event) throws WritingDataException;

    void removeEvent(Event event) throws WritingDataException;

    Collection<Event> getAllEvents();

    Collection<Event> getEventsCreatedByUser(UserDetail user);
}
