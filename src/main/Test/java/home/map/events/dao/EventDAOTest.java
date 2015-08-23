package home.map.events.dao;

import home.map.events.entity.Event;
import home.map.events.entity.Point;
import home.map.events.entity.UserDetail;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNull;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.transaction.annotation.Transactional;

import java.util.Collection;

/**
 * Created by greg on 07.08.15.
 */
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = "classpath:META-INF/ApplicationContext.xml")
@Transactional
public class EventDAOTest {
    @Autowired
    private UserDAO userDAO;
    @Autowired
    private EventDAO eventDAO;



    @Test
    public void testAddEvent() throws Exception {
        Event event = new Event();
        eventDAO.saveAndFlush(event);
        Event fromDB = eventDAO.findOne(event.getId());
    }
    @Test
    public void testGetEventsCreatedByUser() throws Exception {
        UserDetail userDetail = new UserDetail();
        userDetail.setName("name");
        userDAO.saveAndFlush(userDetail);
        Point point = new Point(423,123);
        Event event = new Event(userDetail,point);
        eventDAO.saveAndFlush(event);
        System.out.println(eventDAO.findAll());
        Collection<Event> fromDB = eventDAO.getEventsCreatedByUser(userDetail);
        System.out.println("FROM DB" + fromDB);
    }
    @Test
    public void updateEvent() throws Exception {
        Event event = new Event();
        eventDAO.saveAndFlush(event);
        event.setName("name");
        eventDAO.saveAndFlush(event);
        Event fromDB = eventDAO.findOne(event.getId());
        assertEquals(event,fromDB);
        System.out.println("UPDATED" + fromDB);
    }
    @Test
    public void removeEvent() throws Exception {
        Event event = new Event();
        event.setName("toRemove");
        eventDAO.saveAndFlush(event);
        eventDAO.delete(event);
        Event fromDB = eventDAO.findOne(event.getId());
        assertNull(fromDB);
        System.out.println("UPDATED" + fromDB);
    }

}
