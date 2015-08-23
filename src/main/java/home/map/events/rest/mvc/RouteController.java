package home.map.events.rest.mvc;

import home.map.events.entity.Route;
import home.map.events.rest.resources.RouteResource;
import home.map.events.rest.resources.asm.RouteResourceAsm;
import home.map.events.service.RouteService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

/**
 * Created by greg on 23.08.15.
 */
@Controller @RequestMapping ("/routes") public class RouteController {
    private RouteService service;

    public RouteController(RouteService service) {
        this.service = service;
    }

    @RequestMapping (value = "/{routeId}",
        method = RequestMethod.GET)
    public ResponseEntity<RouteResource> getRoute(@PathVariable Long id) {
        Route route = service.getRouteById(id);
        if (route != null) {
            RouteResource res = new RouteResourceAsm().toResource(route);
            return new ResponseEntity<RouteResource>(res, HttpStatus.OK);
        } else {
            return new ResponseEntity<RouteResource>(HttpStatus.NOT_FOUND);
        }
    }


    @RequestMapping (value = "/{routeId}",
        method = RequestMethod.DELETE)
    public ResponseEntity<RouteResource> deleteRoute(@PathVariable Long id) {
        if (service.removeRoute(id)) {
            return new ResponseEntity<RouteResource>(HttpStatus.OK);
        } else {
            return new ResponseEntity<RouteResource>(HttpStatus.NOT_FOUND);
        }
    }



}
