package home.map.events.dao;

import home.map.events.dao.daoImpl.WritingDataException;
import home.map.events.entity.UserDetail;

/**
 * Created by greg on 16.07.15.
 */
public interface UserDAO {
    UserDetail  getUser(String login, String password);
    void addUser(UserDetail user) throws WritingDataException;
    void updateUser(UserDetail user) throws WritingDataException;
    void removeUser(UserDetail user) throws WritingDataException;
    UserDetail getUserById(long id);
}
