package home.map.events.rest.mvc;

import home.map.events.service.UserService;
import org.springframework.stereotype.Controller;

/**
 * Created by greg on 23.08.15.
 */
@Controller
public class ServiceController {
    private UserService service;
    public ServiceController(UserService service) {
        this.service = service;
    }
}
