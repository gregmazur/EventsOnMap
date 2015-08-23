package home.map.events.service;

import home.map.events.entity.Event;
import home.map.events.entity.Route;
import home.map.events.entity.UserDetail;
import org.springframework.stereotype.Service;

import java.util.Collection;

/**
 * Created by greg on 16.07.15.
 */
@Service
public interface UserService {

    Collection<UserDetail> getUsersTaggedInEvent(Event event);

    Collection<UserDetail> getUsersTaggedInRoute(Route route);

    UserDetail editUser(UserDetail userDetail);

    UserDetail createUser(UserDetail userDetail);

    UserDetail login (String login, String password);

    void deleteUser(UserDetail userDetail);

}
