package home.map.events.dao.daoImpl;

import home.map.events.dao.UserDAO;
import home.map.events.entity.UserDetail;


/**
 * Created by greg on 16.07.15.
 */
public class UserDaoImpl extends DAOUtils implements UserDAO {

    public UserDetail getUser(String login, String password) {
        return (UserDetail) getEm().createQuery("SELECT u FROM UserDetail u WHERE u.login = :login and u.password = :password")
                .setParameter("login", login)
                .setParameter("password", password);
    }

    public void addUser(UserDetail user) {
        add(user);
    }

    public void updateUser(UserDetail user) {
        update(user);
    }

    public void removeUser(UserDetail user) {
       delete(user);
    }

    public UserDetail getUserById(long id) {
        return (UserDetail) getEm().find(UserDetail.class,id);
    }

}
