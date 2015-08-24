package home.map.events.dao;

import home.map.events.core.entity.Route;
import home.map.events.core.entity.UserDetail;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.annotation.Rollback;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.transaction.annotation.Transactional;

import java.util.Collection;

/**
 * Created by greg on 07.08.15.
 */
@RunWith (SpringJUnit4ClassRunner.class)
@ContextConfiguration (locations = "classpath:META-INF/ApplicationContext.xml") @Transactional
public class RouteDAOTest {
    @Autowired private RouteDAO dao;
    @Autowired private UserDAO userDAO;
    private Route route;
    private UserDetail user = new UserDetail("login", "pass", "city");

    @Before @Rollback (false) public void setup() {
        route = new Route(user);
        route.setName("route");
        user = userDAO.saveAndFlush(user);
        route = dao.saveAndFlush(route);
    }

    @Test
    public void testGetRoutesCreatedByUser() throws Exception {

    }

    @Test
    public void testGetRoutesNearPoint() throws Exception {

    }

    @Test
    public void testGetRouteContainsName() throws Exception {
        Collection<Route> list = dao.getRouteContainsName("route");
        System.out.println("CONTAINS NAME" + list);
    }
}
