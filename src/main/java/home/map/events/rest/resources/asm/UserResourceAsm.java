package home.map.events.rest.resources.asm;

import home.map.events.core.entity.UserDetail;
import home.map.events.rest.mvc.UserController;
import home.map.events.rest.resources.UserResource;
import org.springframework.hateoas.Link;
import org.springframework.hateoas.mvc.ResourceAssemblerSupport;

import static org.springframework.hateoas.mvc.ControllerLinkBuilder.linkTo;

/**
 * Created by greg on 23.08.15.
 */
public class UserResourceAsm extends ResourceAssemblerSupport<UserDetail, UserResource> {
    public UserResourceAsm() {
        super(UserController.class, UserResource.class);
    }

    @Override public UserResource toResource(UserDetail user) {
        UserResource resource = new UserResource();
        resource.setName(user.getName());
        resource.setCity(user.getCity());
        resource.setLogin(user.getLogin());
        resource.setPassword(user.getPassword());
        resource.setQuantityOfCommentsLeft(user.getQuantityOfCommentsLeft());
        resource.setQuantityOfEventsPosted(user.getQuantityOfEventsPosted());
        resource.setQuantityOfRoutesPosted(user.getQuantityOfRoutesPosted());
        resource.setCreatedAt(user.getCreatedAt());
        resource.setUpdatedAt(user.getUpdatedAt());
        Link link = linkTo(UserController.class).slash(user.getId()).withSelfRel();
        resource.add(link);
        return resource;
    }
}
