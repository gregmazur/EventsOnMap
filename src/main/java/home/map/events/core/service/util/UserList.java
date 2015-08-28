package home.map.events.core.service.util;

import home.map.events.core.entity.UserDetail;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by greg on 28.08.15.
 */
public class UserList {
    List<UserDetail> users = new ArrayList<>();

    public List<UserDetail> getUsers() {
        return users;
    }

    public void setUsers(List<UserDetail> users) {
        this.users = users;
    }

    public UserList(List<UserDetail> users) {

        this.users = users;
    }
}
