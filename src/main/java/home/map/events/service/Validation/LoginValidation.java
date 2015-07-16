package home.map.events.service.Validation;

import home.map.events.entity.UserDetail;

/**
 * Created by greg on 16.07.15.
 */
public interface LoginValidation {
    UserDetail login(String login, String password);
}
