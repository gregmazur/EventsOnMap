package home.map.events.dao.daoImpl;

import home.map.events.dao.EventDAO;
import home.map.events.entity.Event;
import home.map.events.entity.UserDetail;

import java.util.Collection;

/**
 * Created by greg on 22.07.15.
 */
public class EventDaoImpl extends DAOUtils<Event> implements EventDAO {

    public void addEvent(Event event) throws WritingDataException {
        add(event);
    }

    public void updateEvent(Event event) throws WritingDataException {
        update(event);
    }

    public void removeEvent(Event event) throws WritingDataException {
        delete(event);
    }

    public Collection<Event> getAllEvents() {
        return getEm().createQuery("SELECT e FROM " + Event.class.getName() + " e").getResultList();
    }

    public Collection<Event> getEventsCreatedByUser(UserDetail user) {
        return null;
    }
}
