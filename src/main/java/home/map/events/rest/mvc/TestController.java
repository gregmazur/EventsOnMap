package home.map.events.rest.mvc;

import home.map.events.core.entity.Route;
import home.map.events.core.entity.Test;
import home.map.events.core.service.TestService;
import home.map.events.core.service.exceptions.RouteExistsException;
import home.map.events.core.service.exceptions.UserDoesNotExistException;
import home.map.events.rest.exceptions.BadRequestException;
import home.map.events.rest.exceptions.ConflictException;
import home.map.events.rest.resources.RouteResource;
import home.map.events.rest.resources.TestResource;
import home.map.events.rest.resources.asm.RouteResourceAsm;
import home.map.events.rest.resources.asm.TestResourceAsm;
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
 * Created by greg on 24.08.15.
 */
@Controller public class TestController {
    private TestService service;

    public TestController(TestService service) {
        this.service = service;
    }

    @RequestMapping (value = "/test/{testId}",
        method = RequestMethod.GET)
    public ResponseEntity<TestResource> getRoute(@PathVariable Long testId) {
        Test test = service.find(testId);
        if (test != null) {
            TestResource res = new TestResourceAsm().toResource(test);
            return new ResponseEntity<TestResource>(res, HttpStatus.OK);
        } else {
            return new ResponseEntity<TestResource>(HttpStatus.NOT_FOUND);
        }
    }

    @RequestMapping (value = "profile/{userId}/routes",
        method = RequestMethod.POST)
    public ResponseEntity<RouteResource> createRoute(@PathVariable Long userId,
        @RequestBody RouteResource res) {
        try {
            Route route = service.createRoute(userId, res.toRoute());
            RouteResource createdRouteRes = new RouteResourceAsm().toResource(route);
            HttpHeaders headers = new HttpHeaders();
            headers.setLocation(URI.create(createdRouteRes.getLink("self").getHref()));
            return new ResponseEntity<RouteResource>(createdRouteRes, headers, HttpStatus.CREATED);
        } catch (UserDoesNotExistException exception) {
            throw new BadRequestException(exception);
        } catch (RouteExistsException exception) {
            throw new ConflictException(exception);
        }
    }
}

