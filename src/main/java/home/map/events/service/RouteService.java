package home.map.events.service;

import home.map.events.entity.Point;
import home.map.events.entity.Route;
import home.map.events.entity.UserDetail;

import java.util.Collection;

/**
 * Created by greg on 23.08.15.
 */
public interface RouteService {
    Route getRouteById(long id);

    Route update(long id, Route newRoute);

    Collection<Route> getAllRoutes();

    Collection<Route> getRoutesCreatedByUser(UserDetail user);

    Collection<Route> getRouteNearPoint(Point point);

    boolean addRoute(Route route);

    boolean editRoute(Route route, UserDetail user);

    boolean removeRoute(long id);
}
