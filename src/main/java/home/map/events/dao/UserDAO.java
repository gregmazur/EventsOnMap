package home.map.events.dao;

import home.map.events.entity.UserDetail;

/**
 * Created by greg on 16.07.15.
 */
public interface UserDAO {
    UserDetail getUser(String login, String password);
    void addUser(UserDetail user);
    void updateUser(UserDetail user);
    void removeUser(UserDetail user);
    UserDetail getUserById(long id);
}
