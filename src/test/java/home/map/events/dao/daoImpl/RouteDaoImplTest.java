package home.map.events.dao.daoImpl;

import home.map.events.dao.EventDAO;
import home.map.events.dao.RouteDAO;
import home.map.events.dao.UserDAO;
import home.map.events.entity.Event;
import home.map.events.entity.Point;
import home.map.events.entity.Route;
import home.map.events.entity.UserDetail;
import org.junit.BeforeClass;
import org.junit.Test;

/**
 * Created by greg on 21.07.15.
 */
public class RouteDaoImplTest {
    static UserDetail user = new UserDetail("login", "password", "city");
    static UserDetail userTagged = new UserDetail("login2", "password", "city");
    static RouteDAO routeDAO = new RouteDaoImpl();
    static Event event = new Event(user, new Point(23, 23));
    static Event event2 = new Event(user, new Point(232, 232));
    static Route route = new Route(user);
    static EventDAO eventDAO;

    @BeforeClass
    public static void start() throws WritingDataException {
        UserDAO userDAO = new UserDaoImpl();
        eventDAO = new EventDaoImpl();
        userDAO.addUser(user);
        userTagged.setName("Taggger");
        userDAO.addUser(userTagged);
        event.setName("event1");
        event2.setName("event2");
        eventDAO.addEvent(event2);
        eventDAO.addEvent(event);
        route.addEvent(event);
        route.addEvent(event2);
        route.addEvent(new Event(user,new Point(345,33545)));
        route.addPoint(new Point(56, 546));
        route.addPoint(new Point(54536, 546));
        route.addPoint(new Point(111156, 544356));
        route.addEvent(event);
        route.addEvent(event2);
        routeDAO.addRoute(route);

    }


    @Test
    public void testUpdateRoute() throws Exception, WritingDataException {
        route.setName("updatedName");
        routeDAO.updateRoute(route);
    }

    @Test
    public void testRemoveRoute() throws Exception, WritingDataException {
        Route newRoute = new Route(user);
        newRoute.setName("Has to be removed");
        routeDAO.addRoute(newRoute);
        routeDAO.removeRoute(newRoute);
    }

    @Test
    public void testGetAllRoutes() throws Exception, WritingDataException {
        Route newRoute = new Route(user);
        newRoute.setName("Second");
        routeDAO.addRoute(newRoute);
        System.out.println("Routes :" + routeDAO.getAllRoutes());
    }

    @Test
    public void testGetAllEvents() throws Exception {
        System.out.println("Events : "+ eventDAO.getAllEvents());
    }

    @Test
    public void testGetRoutesNearPoint() throws Exception {

    }

    @Test
    public void testGetRouteContainsName() throws Exception, WritingDataException {
        Route newRoute = new Route(user);
        newRoute.setName("tag");
        routeDAO.addRoute(newRoute);
        System.out.println("contains TAG = " + routeDAO.getRouteContainsName("Tag"));
    }
}