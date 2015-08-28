package home.map.events.core.service;

import home.map.events.core.entity.Comment;
import home.map.events.core.entity.Event;
import home.map.events.core.entity.Route;
import home.map.events.core.entity.UserDetail;

import java.util.Collection;

/**
 * Created by greg on 16.07.15.
 */

public interface UserService {

    UserDetail getByID(Long id);

    UserDetail addUser(UserDetail userDetail);

    void deleteUser(UserDetail userDetail);

    Collection<Route> getRoutesCreatedByUser(Long userId);

    Collection<Event> getEventsCreatedByUser(Long userId);

    Collection<Comment> getCommentsLeftByUser(Long userId);

    Route addRoute(Route route, Long userId);

    UserDetail updateUser(UserDetail user);

}
