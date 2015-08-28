package home.map.events.core.service.util;

import home.map.events.core.entity.Event;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by greg on 28.08.15.
 */
public class EventList {
    List<Event> events = new ArrayList<>();

    public List<Event> getEvents() {
        return events;
    }

    public void setEvents(List<Event> events) {
        this.events = events;
    }

    public EventList(List<Event> events) {

        this.events = events;
    }
}
