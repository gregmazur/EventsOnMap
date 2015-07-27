package home.map.events.dao.daoImpl;

import home.map.events.dao.UserDAO;
import home.map.events.entity.UserDetail;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.BeansException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ApplicationContextAware;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.transaction.TransactionConfiguration;
import org.springframework.transaction.annotation.Transactional;

/**
 * Created by greg on 20.07.15.
 */
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = { "/ApplicationContext.xml" })
@Transactional
@TransactionConfiguration(defaultRollback = true)
public class UserDaoImplTest implements ApplicationContextAware {
    @Autowired
    private UserDAO userDAO;





    @Test
    public void testGetUser() throws Exception {
        UserDetail user = new UserDetail("login","password","city");
        userDAO.addUser(user);
        UserDetail userDetail = userDAO.getUser("login", "password");
        System.out.println("Test user login/password" + userDetail);

    }



    @Test
    public void testUpdateUser() throws Exception, WritingDataException {
        UserDetail userDetail = new UserDetail("login2","password","city");
        userDAO.addUser(userDetail);
        userDetail = userDAO.getUser("login2", "password");
        userDetail.setCity("Odessa");
        userDAO.updateUser(userDetail);
        System.out.println("testUpdateUser" + userDAO.getUser("login2", "password"));
    }

    @Test
    public void testRemoveUser() throws Exception, WritingDataException {
        UserDetail userDetail = new UserDetail("login3","password","city");
        userDAO.addUser(userDetail);
        userDetail = userDAO.getUser("login2", "password");
        userDAO.removeUser(userDetail);
    }

    @Test
    public void testGetUserById() throws Exception, WritingDataException {
        UserDetail userDetail = new UserDetail("login2","password","city");
        userDAO.addUser(userDetail);
        System.out.println("Get USER by ID = " + userDAO.getUserById(1));
    }
//    @Test
//    public void testAddNonUniqueLogin() throws Exception, WritingDataException {
//        UserDetail user = new UserDetail("login","password","city");
//
//        userDAO.addUser(user);
//
//    }

    public void setApplicationContext(ApplicationContext applicationContext) throws BeansException {

    }
}