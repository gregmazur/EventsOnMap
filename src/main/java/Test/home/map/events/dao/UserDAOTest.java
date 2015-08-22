package Test.home.map.events.dao;

import home.map.events.dao.UserDAO;
import home.map.events.entity.UserDetail;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.transaction.annotation.Transactional;
/**
 * Created by greg on 29.07.15.
 */

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = "classpath:META-INF/ApplicationContext.xml")
@Transactional
public class UserDAOTest {
    @Autowired
    private UserDAO userDAO;

    @Test
    public void addUser() throws Exception {
//        UserDetail user = new UserDetail("login", "password", "city");
//        userDAO.saveAndFlush(user);
//        UserDetail fromDB = userDAO.findOne(user.getId());
//        Assert.assertNotNull(fromDB);
//        Assert.assertEquals(fromDB,user);
//    }
//    @Test
//    public void testGetUser() throws Exception {
//        UserDetail user = new UserDetail("login2", "password", "city");
//        userDAO.saveAndFlush(user);
//        UserDetail fromDB = userDAO.getUser("login2", "password");
//        Assert.assertNotNull(fromDB);
//        Assert.assertEquals(fromDB, user);
//    }
//    @Test
//    public void testGetUserNotExisted() throws Exception {
//        UserDetail fromDB = userDAO.getUser("login3", "password");
//        Assert.assertNull(fromDB);
//    }
//    @Test
//    public void testRemoveUser(){
//        UserDetail user = new UserDetail("remove", "password", "city");
//        userDAO.saveAndFlush(user);
//        userDAO.delete(user.getId());
//        UserDetail fromDB = userDAO.findOne(user.getId());
//        Assert.assertNull(fromDB);
//    }
//    @Test
//    public void updateUser() throws Exception {
//
//        UserDetail user = new UserDetail("toUpdate", "password", "city");
//        userDAO.saveAndFlush(user);
//        user.setName("UPDATED");
//        userDAO.saveAndFlush(user);
//        UserDetail fromDB = userDAO.findOne(user.getId());
//        Assert.assertNotNull(fromDB);
//        Assert.assertEquals(fromDB, user);
//    }
//    @Test
//    public void getAllUsers(){
//        UserDetail user = new UserDetail("remove", "password", "city");
//        userDAO.saveAndFlush(user);
//        System.out.println("PRINTING"+userDAO.findAll());
    }
}
