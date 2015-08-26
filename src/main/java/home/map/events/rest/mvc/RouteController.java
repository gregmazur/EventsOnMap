package home.map.events.rest.mvc;

import home.map.events.core.entity.Event;
import home.map.events.core.entity.Route;
import home.map.events.core.service.RouteService;
import home.map.events.core.service.exceptions.RouteDoesNotExistException;
import home.map.events.core.service.exceptions.RouteExistsException;
import home.map.events.core.service.exceptions.RouteNotFoundException;
import home.map.events.rest.exceptions.BadRequestException;
import home.map.events.rest.exceptions.ConflictException;
import home.map.events.rest.exceptions.NotFoundException;
import home.map.events.rest.resources.EventResource;
import home.map.events.rest.resources.RouteResource;
import home.map.events.rest.resources.asm.EventResourceAsm;
import home.map.events.rest.resources.asm.RouteResourceAsm;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import java.net.URI;

/**
 * Created by greg on 23.08.15.
 */
@RequestMapping (value = "/route") @Controller public class RouteController {
    private RouteService service;

    public RouteController(RouteService service) {
        this.service = service;
    }

    @RequestMapping (value = "/{routeId}",
        method = RequestMethod.GET)
    public ResponseEntity<RouteResource> getRoute(@PathVariable Long routeId) {
        Route route = service.getById(routeId);
        if (route != null) {
            RouteResource res = new RouteResourceAsm().toResource(route);
            return new ResponseEntity<RouteResource>(res, HttpStatus.OK);
        } else {
            return new ResponseEntity<RouteResource>(HttpStatus.NOT_FOUND);
        }
    }


    @RequestMapping (value = "/{routeId}",
        method = RequestMethod.DELETE)
    public ResponseEntity<RouteResource> deleteRoute(@PathVariable Long routeId) {
        if (service.removeRoute(routeId) != null) {
            return new ResponseEntity<RouteResource>(HttpStatus.OK);
        } else {
            return new ResponseEntity<RouteResource>(HttpStatus.NOT_FOUND);
        }
    }

    @RequestMapping (method = RequestMethod.POST, headers = "Accept=application/json")
    public ResponseEntity<RouteResource> createRoute(@RequestBody RouteResource sentRoute) {
        Route createdRoute;
        try {
            createdRoute = service.createRoute(sentRoute.toRoute());
            RouteResource createdResource = new RouteResourceAsm().toResource(createdRoute);
            HttpHeaders headers = new HttpHeaders();
            headers.setLocation(URI.create(createdResource.getLink("self").getHref()));
            return new ResponseEntity<RouteResource>(createdResource, headers, HttpStatus.CREATED);
        } catch (RouteNotFoundException e) {
            throw new NotFoundException(e);
        }
    }

    @RequestMapping (value = "/{routeId}/event",
        method = RequestMethod.POST, headers = "Accept=application/json")
    public ResponseEntity<EventResource> createEvent(@PathVariable Long routeId,
        @RequestBody EventResource res) {
        Event createdEvent;
        try {
            createdEvent = service.addEventToRoute(routeId, res.toEvent());
            EventResource createdResource = new EventResourceAsm().toResource(createdEvent);
            HttpHeaders headers = new HttpHeaders();
            headers.setLocation(URI.create(createdResource.getLink("self").getHref()));
            return new ResponseEntity<EventResource>(createdResource, headers, HttpStatus.CREATED);
        } catch (RouteDoesNotExistException exception) {
            throw new BadRequestException(exception);
        } catch (RouteExistsException exception) {
            throw new ConflictException(exception);
        }
    }



}
