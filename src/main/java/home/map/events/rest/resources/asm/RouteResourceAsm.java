package home.map.events.rest.resources.asm;

import home.map.events.entity.Route;
import home.map.events.rest.mvc.RouteController;
import home.map.events.rest.resources.RouteResource;
import org.springframework.hateoas.Link;
import org.springframework.hateoas.mvc.ResourceAssemblerSupport;

import static org.springframework.hateoas.mvc.ControllerLinkBuilder.linkTo;
import static org.springframework.hateoas.mvc.ControllerLinkBuilder.methodOn;

/**
 * Created by greg on 23.08.15.
 */
public class RouteResourceAsm extends ResourceAssemblerSupport<Route, RouteResource> {


    public RouteResourceAsm() {
        super(RouteController.class, RouteResource.class);
    }

    @Override public RouteResource toResource(Route route) {
        RouteResource resource = new RouteResource();
        resource.setName(route.getName());
        resource.setRouteEvents(route.getRouteEvents());
        resource.setRoutePoints(route.getRoutePoints());
        resource.setComments(route.getComments());
        resource.setCreatedAt(route.getCreatedAt());
        resource.setCreatedBy(route.getCreatedBy());
        Link link = linkTo(methodOn(RouteController.class).getRoute(route.getId())).withSelfRel();
        resource.add(link);
        return null;
    }
}
