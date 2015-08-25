package home.map.events.core.service;

import home.map.events.core.entity.Comment;
import home.map.events.core.entity.Event;
import home.map.events.core.entity.Point;
import home.map.events.core.entity.Route;
import org.springframework.stereotype.Service;

import java.util.Collection;

/**
 * Created by greg on 23.08.15.
 */
@Service public interface RouteService {
    Route getById(Long id);

    Route createRoute(Route route);

    Route update(long id, Route newRoute);

    Collection<Route> getAllRoutes();

    Collection<Route> getRoutesCreatedByUser(Long userId);

    Collection<Route> getRouteNearPoint(Point point);

    Event addEventToRoute(Long routeId, Event event);

    Route removeRoute(long id);

    Comment addCommentToRoute(Long routeId, Comment comment);
}
