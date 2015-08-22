package home.map.events.mvc;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * Created by greg on 21.08.15.
 */


@Controller
public class ControllerClass {
    @RequestMapping("/welcome")
    public String login()
    {
        return "login";
    }
}
