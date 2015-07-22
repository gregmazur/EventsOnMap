package home.map.events.dao.daoImpl;

import home.map.events.dao.RouteDAO;
import home.map.events.entity.Event;
import home.map.events.entity.Point;
import home.map.events.entity.Route;
import home.map.events.entity.UserDetail;

import java.util.Collection;

/**
 * Created by greg on 21.07.15.
 */
public class RouteDaoImpl extends DAOUtils<Route> implements RouteDAO {
    public synchronized void addRoute(Route route) throws WritingDataException {
        add(route);
    }

    public synchronized void updateRoute(Route route) throws WritingDataException {
        update(route);
    }

    public synchronized void removeRoute(Route route) throws WritingDataException {
        delete(route);
    }

    public Collection<Route> getAllRoutes() {
        return getEm().createQuery("SELECT r FROM " + Route.class.getName() + " r").getResultList();
    }

    public Collection<Route> getRoutesCreatedByUser(UserDetail user) {
        return null;
    }


     public Collection<Route> getRoutesWithTaggedUser(UserDetail user) {
        return getEm().createQuery("SELECT r FROM " + Route.class.getName() + " r WHERE :" + UserDetail.class.getName() +
                "MEMBER OF r.").getResultList();
    }

    public Collection<Route> getRoutesNearPoint(Point point) {
        return null;
        //TODO
    }

    public Collection<Route> getRouteContainsName(String name) {
         return getEm().createQuery("SELECT r FROM " + Route.class.getName() + " r where r.name like name").getResultList();
    }

    public Collection<Event> getAllEventsForRoute(Route route) {
        return getEm().createQuery("SELECT e FROM " + Event.class.getName() + " e WHERE :" + UserDetail.class.getName() +
                "MEMBER OF r.").getResultList();
    }


}
