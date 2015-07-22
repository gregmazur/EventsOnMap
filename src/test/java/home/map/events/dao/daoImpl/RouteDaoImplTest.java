package home.map.events.dao.daoImpl;

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
    static UserDetail user = new UserDetail("login","password","city");
    static UserDetail userTagged = new UserDetail("login2","password","city");
        static RouteDAO routeDAO = new RouteDaoImpl();
    static Event event = new Event(user,new Point(23,23));
    static Event event2 = new Event(user,new Point(232,232));
    static Route route = new Route(user);

    @BeforeClass
    public static void start() throws WritingDataException {
        UserDAO userDAO = new UserDaoImpl();
        userDAO.addUser(user);
        userDAO.addUser(userTagged);
        userTagged.setName("Taggger");
        route.addPoint(new Point(56, 546));
        route.addPoint(new Point(54536,546));
        route.addPoint(new Point(111156,544356));
        route.addEvent(event);
        route.addEvent(event2);
        routeDAO.addRoute(route);

    }


//    @Test
//    public void testUpdateRoute() throws Exception, WritingDataException {
//        route.setName("updatedName");
//        routeDAO.updateRoute(route);
//    }
//
//    @Test
//    public void testRemoveRoute() throws Exception, WritingDataException {
//        Route newRoute = new Route(user);
//        routeDAO.removeRoute(newRoute);
//    }
//
//    @Test
//    public void testGetAllRoutes() throws Exception, WritingDataException {
//        Route newRoute = new Route(user);
//        newRoute.setName("Second");
//        routeDAO.addRoute(newRoute);
//        System.out.println(routeDAO.getAllRoutes());
//    }

    @Test
    public void testGetRoutesWithTaggedUser() throws Exception {

    }

    @Test
    public void testGetRoutesNearPoint() throws Exception {

    }

    @Test
    public void testGetRoouteContainsName() throws Exception {

    }
}