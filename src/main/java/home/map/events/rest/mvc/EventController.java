package home.map.events.rest.mvc;

import home.map.events.core.entity.Event;
import home.map.events.core.service.EventService;
import home.map.events.rest.resources.EventResource;
import home.map.events.rest.resources.asm.EventResourceAsm;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

/**
 * Created by greg on 25.08.15.
 */
@RequestMapping @Controller public class EventController {

    private EventService service;

    public EventController(EventService service) {
        this.service = service;
    }

    @RequestMapping (value = "/event/{eventId}",
        method = RequestMethod.GET)
    public ResponseEntity<EventResource> getRoute(@PathVariable Long eventId) {
        Event event = service.getById(eventId);
        if (event != null) {
            EventResource res = new EventResourceAsm().toResource(event);
            return new ResponseEntity<EventResource>(res, HttpStatus.OK);
        } else {
            return new ResponseEntity<EventResource>(HttpStatus.NOT_FOUND);
        }
    }
}
