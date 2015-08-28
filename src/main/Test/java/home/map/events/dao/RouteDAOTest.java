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

import static org.junit.Assert.assertEquals;

/**
 * Created by greg on 07.08.15.
 */
@RunWith (SpringJUnit4ClassRunner.class)
@ContextConfiguration (locations = "classpath:META-INF/ApplicationContext.xml") @Transactional
public class RouteDAOTest {
    @Autowired private RouteDAO dao;
    @Autowired private UserDAO userDAO;
    private Route route;
    private UserDetail user = new UserDetail();

    @Before @Rollback (false) public void setup() {
        user.setLogin("login");
        user.setCity("city");
        user.setPassword("password");
        route = new Route();
        route.setCreatedBy(user);
        route.setName("route");
        user = userDAO.saveAndFlush(user);
        route = dao.saveAndFlush(route);
    }

    @Test
    public void testGetRoutesCreatedByUser() throws Exception {
        assertEquals(route, dao.findByCreatedBy(user.getId()).iterator().next());
    }

    @Test
    public void testGetRoutesNearPoint() throws Exception {

    }

    @Test
    public void testGetRouteContainsName() throws Exception {
        Collection<Route> list = dao.getRouteContainsName("route");
        assertEquals(route, list.iterator().next());
    }

    @Test public void testFindByOne() {
        assertEquals(route, dao.findOne(route.getId()));
    }

    @Test public void findByNameTest() {
        assertEquals(route, dao.findByName("route"));
    }
}
