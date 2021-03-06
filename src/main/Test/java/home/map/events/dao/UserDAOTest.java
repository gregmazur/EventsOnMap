package home.map.events.dao;

import home.map.events.core.entity.UserDetail;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.annotation.Rollback;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.transaction.annotation.Transactional;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNull;
/**
 * Created by greg on 29.07.15.
 */

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = "classpath:META-INF/ApplicationContext.xml")
@Transactional
public class UserDAOTest {
    @Autowired
    private UserDAO userDAO;
    private UserDetail user;
    @Before
    @Rollback (false)
    public void setup()
    {
        user = new UserDetail();
        user.setLogin("login");
        user.setCity("city");
        user.setPassword("password");
        user.setName("name");
        userDAO.saveAndFlush(user);
    }
    @Test
    public void addUser() throws Exception {
        UserDetail fromDB = userDAO.findOne(user.getId());
        assertEquals(fromDB, user);
    }
    @Test
    public void testGetUser() throws Exception {
        UserDetail fromDB = userDAO.getUser("login", "password");
        assertEquals(fromDB, user);
    }
    @Test
    public void testGetUserNotExisted() throws Exception {
        UserDetail fromDB = userDAO.getUser("login3", "password");
        assertNull(fromDB);
    }
    @Test
    public void testRemoveUser(){
        userDAO.delete(user.getId());
        UserDetail fromDB = userDAO.findOne(user.getId());
        assertNull(fromDB);
    }
    @Test
    public void updateUser() throws Exception {
        user.setName("UPDATED");
        userDAO.saveAndFlush(user);
        UserDetail fromDB = userDAO.findOne(user.getId());
        assertEquals(fromDB, user);
    }
    @Test
    public void getAllUsers(){
        assertEquals(user, userDAO.findAll().iterator().next());
    }

    @Test public void findUserByLogin() {
        assertEquals(user, userDAO.findByLogin("login"));
    }
}
