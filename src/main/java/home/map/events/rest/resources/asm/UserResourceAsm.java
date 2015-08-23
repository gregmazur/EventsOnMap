package home.map.events.rest.resources.asm;

import home.map.events.entity.UserDetail;
import home.map.events.rest.mvc.UserController;
import home.map.events.rest.resources.UserResource;
import org.springframework.hateoas.mvc.ResourceAssemblerSupport;

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
        resource.setQuantityOfCommentsLeft(user.getQuantityOfCommentsLeft());
        resource.setQuantityOfEventsPosted(user.getQuantityOfEventsPosted());
        resource.setQuantityOfRoutesPosted(user.getQuantityOfRoutesPosted());
        return resource;
    }
}
