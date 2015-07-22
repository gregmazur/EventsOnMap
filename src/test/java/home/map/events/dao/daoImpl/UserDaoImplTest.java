package home.map.events.dao.daoImpl;

import home.map.events.dao.UserDAO;
import home.map.events.entity.UserDetail;
import org.junit.BeforeClass;
import org.junit.Test;

import java.sql.SQLException;

/**
 * Created by greg on 20.07.15.
 */
public class UserDaoImplTest {
    static UserDetail user1;
    static UserDetail user2;
    static UserDetail user3;
    static UserDAO userDAO = new UserDaoImpl();

    @BeforeClass
    public static void start() throws SQLException, WritingDataException {
        user1 = new UserDetail("login","password","city");
        user2 = new UserDetail("toUpdate","password2","city2");
        user3 = new UserDetail("toRemove","password2","city2");
        userDAO.addUser(user1);
        userDAO.addUser(user2);
        userDAO.addUser(user3);
    }



    @Test
    public void testGetUser() throws Exception {
        UserDetail userDetail = userDAO.getUser("login", "password");
        System.out.println(userDetail);
    }



    @Test
    public void testUpdateUser() throws Exception, WritingDataException {
        UserDetail userDetail = userDAO.getUserById(2);
        userDetail.setCity("Odessa");
userDAO.updateUser(userDetail);
        System.out.println(userDAO.getUserById(2));
    }

    @Test
    public void testRemoveUser() throws Exception, WritingDataException {

        userDAO.removeUser(user3);
    }

    @Test
    public void testGetUserById() throws Exception {

        System.out.println(userDAO.getUserById(1));
    }
    @Test
    public void testAddNonUniqueLogin() throws Exception, WritingDataException {
        UserDetail user = new UserDetail("login","password","city");

        userDAO.addUser(user);

    }
}