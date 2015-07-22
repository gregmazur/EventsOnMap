package home.map.events.dao;

import home.map.events.dao.daoImpl.WritingDataException;
import home.map.events.entity.Event;
import home.map.events.entity.Point;
import home.map.events.entity.Route;
import home.map.events.entity.UserDetail;

import java.util.Collection;

/**
 * Created by greg on 21.07.15.
 */
public interface RouteDAO {
    void addRoute(Route route) throws WritingDataException;

    void updateRoute(Route route) throws WritingDataException;

    void removeRoute(Route route) throws WritingDataException;

    Collection<Route> getAllRoutes();

    Collection<Route> getRoutesWithTaggedUser(UserDetail user);

    Collection<Route> getRoutesNearPoint(Point point);

    Collection<Route> getRoouteContainsName(String name);

    Collection<Event> getEventsOfRoute(Route route);
}
