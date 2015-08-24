package home.map.events.rest.mvc;

import home.map.events.core.entity.Route;
import home.map.events.core.service.RouteService;
import home.map.events.rest.resources.RouteResource;
import home.map.events.rest.resources.asm.RouteResourceAsm;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

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



}
