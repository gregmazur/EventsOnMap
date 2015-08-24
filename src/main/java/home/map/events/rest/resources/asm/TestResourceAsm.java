package home.map.events.rest.resources.asm;

import home.map.events.core.entity.Test;
import home.map.events.rest.mvc.TestController;
import home.map.events.rest.resources.TestResource;
import org.springframework.hateoas.Link;
import org.springframework.hateoas.mvc.ResourceAssemblerSupport;

import static org.springframework.hateoas.mvc.ControllerLinkBuilder.linkTo;
import static org.springframework.hateoas.mvc.ControllerLinkBuilder.methodOn;

/**
 * Created by greg on 24.08.15.
 */
public class TestResourceAsm extends ResourceAssemblerSupport<Test, TestResource> {
    public TestResourceAsm() {
        super(TestController.class, TestResource.class);
    }

    @Override public TestResource toResource(Test test) {
        TestResource resource = new TestResource();
        resource.setName(test.getName());

        Link link = linkTo(methodOn(TestController.class).getRoute(test.getId())).withSelfRel();
        resource.add(link);
        return resource;
    }
}
