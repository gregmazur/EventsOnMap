package home.map.events.rest.mvc;

import home.map.events.entity.UserDetail;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 * Created by greg on 21.08.15.
 */


@Controller
public class ControllerClass {
    @RequestMapping(method= RequestMethod.POST,value = "/welcome")
    @ResponseBody
    public UserDetail welcome(@RequestBody UserDetail user)
    {
        return user;
    }
}
