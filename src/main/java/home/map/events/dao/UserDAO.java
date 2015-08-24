package home.map.events.dao;

import home.map.events.core.entity.UserDetail;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

/**
 * Created by greg on 16.07.15.
 */

public interface UserDAO extends JpaRepository<UserDetail,Long>{
    @Query("SELECT u FROM UserDetail u WHERE u.login = :login and u.password = :password")
    UserDetail  getUser(@Param("login") String login,@Param("password") String password);

}
