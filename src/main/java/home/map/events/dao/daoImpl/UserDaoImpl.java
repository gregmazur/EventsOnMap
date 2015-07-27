package home.map.events.dao.daoImpl;

import home.map.events.dao.UserDAO;
import home.map.events.entity.UserDetail;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;


/**
 * Created by greg on 16.07.15.
 */
@Repository
@Transactional
public class UserDaoImpl  implements UserDAO {
    @PersistenceContext
    private EntityManager em;

    public UserDetail getUser(String login, String password) {
        return em.find(UserDetail.class,"SELECT u FROM UserDetail u WHERE u.login = :login and u.password = :password");
//        return (UserDetail) getEm().createQuery("SELECT u FROM UserDetail u WHERE u.login = :login and u.password = :password")
//                .setParameter("login", login)
//                .setParameter("password", password).getSingleResult();
    }

    public void addUser(UserDetail user)  {
        em.persist(user);
    }

    public void updateUser(UserDetail user) {
        em.merge(user);
    }

    public void removeUser(UserDetail user)  {
       em.remove(user);
    }

    public UserDetail getUserById(long id) {
        return em.find(UserDetail.class,id);
    }

}
