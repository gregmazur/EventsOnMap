package home.map.events.rest.mvc;

import home.map.events.core.entity.UserDetail;
import home.map.events.core.service.UserService;
import home.map.events.core.service.exceptions.UserExistsException;
import home.map.events.rest.exceptions.ConflictException;
import home.map.events.rest.resources.UserResource;
import home.map.events.rest.resources.asm.UserResourceAsm;
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
 * Created by greg on 23.08.15.
 */
@RequestMapping @Controller ("/profile") public class UserController {
    private UserService service;

    public UserController(UserService service) {
        this.service = service;
    }

    @RequestMapping (method = RequestMethod.POST)
    public ResponseEntity<UserResource> createUser(@RequestBody UserResource sentUser) {
        try {
            UserDetail createdUser = service.createUser(sentUser.toUserDetail());
            UserResource res = new UserResourceAsm().toResource(createdUser);
            HttpHeaders headers = new HttpHeaders();
            headers.setLocation(URI.create(res.getLink("self").getHref()));
            return new ResponseEntity<UserResource>(res, headers, HttpStatus.CREATED);
        } catch (UserExistsException exception) {
            throw new ConflictException(exception);
        }
    }

    @RequestMapping (value = "/{userId}",
        method = RequestMethod.GET)
    public ResponseEntity<UserResource> getUserByID(@PathVariable Long userId) {
        UserDetail userDetail = service.getByID(userId);
        if (userDetail != null) {
            UserResource res = new UserResourceAsm().toResource(userDetail);
            return new ResponseEntity<UserResource>(res, HttpStatus.OK);
        } else {
            return new ResponseEntity<UserResource>(HttpStatus.NOT_FOUND);
        }
    }



    //    @RequestMapping (value = "/{userId}/routes",
    //        method = RequestMethod.POST)
    //    public ResponseEntity<RouteResource> createRoute(@PathVariable Long userId,
    //        @RequestBody RouteResource res) {
    //        try {
    //            Route route = service.createRoute(userId, res.toRoute());
    //            RouteResource createdRouteRes = new RouteResourceAsm().toResource(route);
    //            HttpHeaders headers = new HttpHeaders();
    //            headers.setLocation(URI.create(createdRouteRes.getLink("self").getHref()));
    //            return new ResponseEntity<RouteResource>(createdRouteRes, headers, HttpStatus.CREATED);
    //        } catch (UserDoesNotExistException exception) {
    //            throw new BadRequestException(exception);
    //        }
    //    }

}
