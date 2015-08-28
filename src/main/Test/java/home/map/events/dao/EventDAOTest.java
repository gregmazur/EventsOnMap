package home.map.events.dao;

import home.map.events.core.entity.Event;
import home.map.events.core.entity.Point;
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
import static org.junit.Assert.assertNull;

/**
 * Created by greg on 07.08.15.
 */
@RunWith (SpringJUnit4ClassRunner.class)
@ContextConfiguration (locations = "classpath:META-INF/ApplicationContext.xml") @Transactional
public class EventDAOTest {
    @Autowired private UserDAO userDAO;
    @Autowired private EventDAO eventDAO;
    @Autowired private RouteDAO routeDAO;
    private UserDetail userDetail;
    private Event event;
    private Route route;

    @Before @Rollback (value = false) public void setup() {
        userDetail = new UserDetail();
        userDetail.setName("Test");
        userDAO.saveAndFlush(userDetail);
        route = new Route();
        route.setCreatedBy(userDetail);
        Point point = new Point(423, 123);
        event = new Event(point);
        event.setCreatedBy(userDetail);
        event.setRoute(route);
        event.setName("testGetEventsCreatedByUser");
        eventDAO.save(event);
    }


    @Test public void testAddEvent() throws Exception {
        Event fromDB = eventDAO.findOne(event.getId());
        assertEquals(event.getName(), fromDB.getName());
    }

    @Test public void testGetEventsCreatedByUser() throws Exception {
        Collection<Event> list = eventDAO.findByCreatedBy(userDetail.getId());
        assertEquals(event, list.iterator().next());
    }

    @Test public void updateEvent() throws Exception {
        eventDAO.saveAndFlush(event);
        Event fromDB = eventDAO.findOne(event.getId());
        assertEquals(event, fromDB);

    }

    @Test public void removeEvent() throws Exception {
        eventDAO.delete(event);
        Event fromDB = eventDAO.findOne(event.getId());
        assertNull(fromDB);
    }

    @Test public void containsNameTest() {
        Collection<Event> list = eventDAO.findByNameContaining("test");
        assertEquals(event, list.iterator().next());
    }

    @Test public void findByRouteTest() {
        Collection<Event> list = eventDAO.findByRoute(route);
        assertEquals(event, list.iterator().next());
    }
}
