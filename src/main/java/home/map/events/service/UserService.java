package home.map.events.service;

import home.map.events.entity.*;

import java.util.Collection;

/**
 * Created by greg on 16.07.15.
 */
public interface UserService {


    Collection<Route> getAllRoutes();



    Collection<Route> getRoutesCreatedByUser(UserDetail user);



    Collection<Route> getRouteNearPoint(Point point);

    Collection<UserDetail> getUsersTaggedInEvent(Event event);

    Collection<UserDetail> getUsersTaggedInRoute(Route route);

    boolean addEventToRoute(Event event,Route route);





    boolean addRoute(Route route);

    boolean editRoute(Route route, UserDetail user);

    boolean removeRoute(Route route, UserDetail user);

    Comment addCommentToRoute(Route route, String text);

    boolean editComment(Comment comment, UserDetail user);
    /*
    User
     */
    UserDetail editUser(UserDetail userDetail);

    UserDetail createUser(UserDetail userDetail);

    UserDetail login (String login, String password);

    void deleteUser(UserDetail userDetail);

}
