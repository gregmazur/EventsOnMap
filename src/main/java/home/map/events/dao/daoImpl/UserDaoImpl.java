package home.map.events.dao.daoImpl;

import home.map.events.dao.UserDAO;
import home.map.events.entity.UserDetail;
import org.springframework.orm.jpa.JpaTemplate;
import org.springframework.transaction.annotation.Transactional;


/**
 * Created by greg on 16.07.15.
 */
@Transactional
public class UserDaoImpl  implements UserDAO {
    JpaTemplate jpaTemplate;

    public UserDetail getUser(String login, String password) {
        return jpaTemplate.find(UserDetail.class,"SELECT u FROM UserDetail u WHERE u.login = :login and u.password = :password");
//        return (UserDetail) getEm().createQuery("SELECT u FROM UserDetail u WHERE u.login = :login and u.password = :password")
//                .setParameter("login", login)
//                .setParameter("password", password).getSingleResult();
    }

    public void addUser(UserDetail user)  {
        jpaTemplate.persist(user);
    }

    public void updateUser(UserDetail user) {
        jpaTemplate.merge(user);
    }

    public void removeUser(UserDetail user)  {
       jpaTemplate.remove(user);
    }

    public UserDetail getUserById(long id) {
        return jpaTemplate.find(UserDetail.class,id);
    }

}
