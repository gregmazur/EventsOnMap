package home.map.events.rest.resources;

import home.map.events.entity.enums.UserRole;
import org.springframework.hateoas.ResourceSupport;


/**
 * Created by greg on 23.08.15.
 */
public class UserResource extends ResourceSupport {

    private String login;
    private String city;
    private long quantityOfEventsPosted;
    private long quantityOfRoutesPosted;
    private long quantityOfCommentsLeft;
    private UserRole role;

    public String getLogin() {
        return login;
    }

    public void setLogin(String login) {
        this.login = login;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public long getQuantityOfEventsPosted() {
        return quantityOfEventsPosted;
    }

    public void setQuantityOfEventsPosted(long quantityOfEventsPosted) {
        this.quantityOfEventsPosted = quantityOfEventsPosted;
    }

    public long getQuantityOfRoutesPosted() {
        return quantityOfRoutesPosted;
    }

    public void setQuantityOfRoutesPosted(long quantityOfRoutesPosted) {
        this.quantityOfRoutesPosted = quantityOfRoutesPosted;
    }

    public long getQuantityOfCommentsLeft() {
        return quantityOfCommentsLeft;
    }

    public void setQuantityOfCommentsLeft(long quantityOfCommentsLeft) {
        this.quantityOfCommentsLeft = quantityOfCommentsLeft;
    }

    public UserRole getRole() {
        return role;
    }

    public void setRole(UserRole role) {
        this.role = role;
    }
}
