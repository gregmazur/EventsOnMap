package home.map.events.dao.daoImpl;

import home.map.events.dao.UserDAO;
import home.map.events.entity.UserDetail;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;

/**
 * Created by greg on 16.07.15.
 */
public class UserDaoImpl implements UserDAO {
    @Autowired
    private SessionFactory sessionFactory;

    public boolean createUser(UserDetail user) {
        return false;
    }

    public UserDetail getUser(String login, String password) {
        return (UserDetail) sessionFactory.getCurrentSession()
                .getNamedQuery("UserDetail.getUser").setParameter("login", login)
                .setParameter("password", password).uniqueResult();
    }
}
