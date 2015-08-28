package home.map.events.core.service;

import home.map.events.core.entity.Comment;
import home.map.events.core.entity.Event;
import home.map.events.core.entity.Point;
import home.map.events.core.entity.Route;
import home.map.events.core.service.util.RouteList;

/**
 * Created by greg on 23.08.15.
 */
public interface RouteService {
    Route getById(Long id);

    RouteList getAllRoutes();

    RouteList getAllRoutesOfUser(Long userId);

    RouteList getRouteNearPoint(Point point);

    Event addEventToRoute(Long routeId, Event event, Long userId);

    Route removeRoute(long id);

    Comment addCommentToRoute(Long routeId, String comment, Long userId);
}
