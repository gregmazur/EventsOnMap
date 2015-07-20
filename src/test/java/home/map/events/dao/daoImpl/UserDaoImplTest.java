package home.map.events.dao.daoImpl;

import home.map.events.dao.UserDAO;
import home.map.events.entity.UserDetail;
import org.junit.Before;
import org.junit.Test;

/**
 * Created by greg on 20.07.15.
 */
public class UserDaoImplTest {
    UserDetail user1;
    UserDetail user2;
    UserDetail user3;
    UserDAO userDAO = new UserDaoImpl();
    @Before
    public void start() {
        user1 = new UserDetail("login","password","city");
        user2 = new UserDetail("toUpdate","password2","city2");
        user3 = new UserDetail("toRemove","password2","city2");
        userDAO.addUser(user1);
    }



    @Test
    public void testGetUser() throws Exception {
        UserDetail userDetail = userDAO.getUser("login", "password");
        System.out.println(userDetail);
    }

    @Test
    public void testAddUser() throws Exception {
        userDAO.addUser(user2);
        userDAO.addUser(user3);

    }

    @Test
    public void testUpdateUser() throws Exception {
        UserDetail userDetail = userDAO.getUser("toUpdate","password2");
        userDetail.setCity("Odessa");
userDAO.updateUser(userDetail);
    }

    @Test
    public void testRemoveUser() throws Exception {

        userDAO.removeUser(user3);
    }

    @Test
    public void testGetUserById() throws Exception {
        System.out.println(userDAO.getUserById(1));
    }
}