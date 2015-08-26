package home.map.events.rest.resources.asm;

import home.map.events.core.entity.Event;
import home.map.events.rest.mvc.EventController;
import home.map.events.rest.resources.EventResource;
import org.springframework.hateoas.Link;
import org.springframework.hateoas.mvc.ResourceAssemblerSupport;

import static org.springframework.hateoas.mvc.ControllerLinkBuilder.linkTo;

/**
 * Created by greg on 25.08.15.
 */
public class EventResourceAsm extends ResourceAssemblerSupport<Event, EventResource> {
    public EventResourceAsm() {
        super(EventController.class, EventResource.class);
    }

    @Override public EventResource toResource(Event event) {
        EventResource resource = new EventResource();
        resource.setName(event.getName());
        resource.setUpdatedAt(event.getUpdatedAt());
        resource.setUpdatedBy(event.getUpdatedBy());
        resource.setComments(event.getComments());
        resource.setCreatedAt(event.getCreatedAt());
        resource.setPoint(event.getPoint());
        Link self = linkTo(EventController.class).slash(event.getId()).withSelfRel();
        resource.add(self);
        //        if(event.get() != null)
        //        {
        //            res.add((linkTo(RouteController.class).slash(blogEntry.getBlog().getId()).withRel("route")));
        //        }
        return resource;
    }
}
