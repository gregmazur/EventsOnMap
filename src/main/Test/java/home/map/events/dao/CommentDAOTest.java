package home.map.events.dao;

import home.map.events.core.entity.*;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.annotation.Rollback;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.transaction.annotation.Transactional;

import static org.junit.Assert.assertEquals;

/**
 * Created by greg on 28.08.15.
 */
@RunWith (SpringJUnit4ClassRunner.class)
@ContextConfiguration (locations = "classpath:META-INF/ApplicationContext.xml") @Transactional
public class CommentDAOTest {
    @Autowired private UserDAO userDAO;
    @Autowired private EventDAO eventDAO;
    @Autowired private RouteDAO routeDAO;
    @Autowired private CommentDAO commentDAO;
    private UserDetail userDetail;
    private Event event;
    private Route route;
    private Comment routeComment;
    private Comment eventComment;

    @Before @Rollback (value = false) public void setup() {
        userDetail = new UserDetail();
        userDetail.setName("Test");
        userDAO.saveAndFlush(userDetail);
        route = new Route();
        route.setCreatedBy(userDetail);
        routeDAO.saveAndFlush(route);
        Point point = new Point(423, 123);
        event = new Event(point);
        event.setCreatedBy(userDetail);
        event.setName("testGetEventsCreatedByUser");
        eventDAO.save(event);
        routeComment = new Comment();
        eventComment = new Comment();
        routeComment.setOwnerRoute(route);
        routeComment.setText("text");
        eventComment.setOwnerEvent(event);
        eventComment.setText("text");
    }

    @Test public void testAddCommentToRoute() {
        commentDAO.saveAndFlush(routeComment);
        assertEquals(routeComment, commentDAO.findOne(routeComment.getId()));
    }

    @Test public void testAddCommentToEvent() {
        commentDAO.saveAndFlush(eventComment);
        assertEquals(eventComment, commentDAO.findOne(eventComment.getId()));
    }

}
