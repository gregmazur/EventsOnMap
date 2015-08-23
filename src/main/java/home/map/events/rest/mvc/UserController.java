package home.map.events.rest.mvc;

import home.map.events.service.UserService;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * Created by greg on 23.08.15.
 */
@Controller @RequestMapping ("/login") public class UserController {
    private UserService service;

    public UserController(UserService service) {
        this.service = service;
    }
}
