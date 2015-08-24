package home.map.events.core.service.Validation;

import home.map.events.core.entity.UserDetail;

/**
 * Created by greg on 16.07.15.
 */
public interface LoginValidation {
    UserDetail login(String login, String password);
}
