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
    public void addRoute(Route route) throws WritingDataException {
        add(route);
    }

    public void updateRoute(Route route) throws WritingDataException {
        update(route);
    }

    public void removeRoute(Route route) throws WritingDataException {
        delete(route);
    }

    public Collection<Route> getAllRoutes() {
        return getEm().createQuery("SELECT r FROM route r").getResultList();
    }

    public Collection<Route> getRoutesWithTaggedUser(UserDetail user) {
        return getEm().createQuery("SELECT r FROM route r").getResultList();
    }

    public Collection<Route> getRoutesNearPoint(Point point) {
        return null;
    }

    public Collection<Route> getRoouteContainsName(String name) {
         return getEm().createQuery("SELECT r FROM route r where r.name like name").getResultList();
    }

    public Collection<Event> getEventsOfRoute(Route route) {
        return null;
    }
}
