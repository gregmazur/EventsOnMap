package home.map.events.rest.resources.asm;

import home.map.events.core.entity.Route;
import home.map.events.rest.mvc.RouteController;
import home.map.events.rest.resources.RouteResource;
import org.springframework.hateoas.Link;
import org.springframework.hateoas.mvc.ResourceAssemblerSupport;

import static org.springframework.hateoas.mvc.ControllerLinkBuilder.linkTo;

/**
 * Created by greg on 23.08.15.
 *
 * creates and make sure a self-link is always added
 * */
public class RouteResourceAsm extends ResourceAssemblerSupport<Route, RouteResource> {


    public RouteResourceAsm() {
        super(RouteController.class, RouteResource.class);
    }

    @Override public RouteResource toResource(Route route) {
        RouteResource resource = new RouteResource();
        resource.setName(route.getName());
        resource.setRoutePoints(route.getRoutePoints());
        resource.setComments(route.getComments());
        resource.setCreatedAt(route.getCreatedAt());
        resource.setCreatedBy(route.getCreatedBy());
        resource.setUpdatedAt(route.getUpdatedAt());
        resource.setUpdatedBy(route.getUpdatedBy());
        Link link = linkTo(RouteController.class).slash(route.getId()).withSelfRel();
        resource.add(link);
        return resource;
    }
}
