package home.map.events.rest.resources.asm;

import home.map.events.entity.UserDetail;
import home.map.events.rest.mvc.ServiceController;
import home.map.events.rest.resources.UserResource;
import org.springframework.hateoas.mvc.ResourceAssemblerSupport;

/**
 * Created by greg on 23.08.15.
 */
public class UserResourceAsm extends ResourceAssemblerSupport<UserDetail,UserResource> {
    public UserResourceAsm() {
        super(ServiceController.class, UserResource.class);
    }

    @Override public UserResource toResource(UserDetail userDetail) {
        UserResource resource = new UserResource();
        resource.setCity(userDetail.getCity());
        return null;
    }
}
