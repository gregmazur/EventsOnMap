package home.map.events.core.service;

import home.map.events.core.entity.Event;
import home.map.events.core.entity.Route;
import home.map.events.core.entity.UserDetail;
import org.springframework.stereotype.Service;

import java.util.Collection;

/**
 * Created by greg on 16.07.15.
 */
@Service
public interface UserService {

    UserDetail getByID(Long id);

    Collection<UserDetail> getUsersTaggedInEvent(Event event);

    Collection<UserDetail> getUsersTaggedInRoute(Route route);

    UserDetail updateUser(Long userId, UserDetail updatedUserDetail);

    UserDetail createUser(UserDetail userDetail);

    Route createRoute(Long userId, Route route);

    void deleteUser(UserDetail userDetail);

}
