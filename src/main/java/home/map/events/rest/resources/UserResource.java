package home.map.events.rest.resources;

import home.map.events.core.entity.UserDetail;
import home.map.events.core.entity.enums.UserRole;
import org.springframework.hateoas.ResourceSupport;

import java.util.Date;


/**
 * Created by greg on 23.08.15.
 */
public class UserResource extends ResourceSupport {

    private String name;
    private String login;
    private String password;
    private String city;
    private long quantityOfEventsPosted;
    private long quantityOfRoutesPosted;
    private long quantityOfCommentsLeft;
    private UserRole role;
    private Date createdAt;
    private Date updatedAt;

    public UserDetail toUserDetail() {
        UserDetail user = new UserDetail();
        user.setLogin(login);
        user.setPassword(password);
        user.setCity(city);
        user.setName(name);
        user.setQuantityOfCommentsLeft(quantityOfCommentsLeft);
        user.setQuantityOfEventsPosted(quantityOfEventsPosted);
        user.setQuantityOfRoutesPosted(quantityOfRoutesPosted);
        user.setRole(role);
        user.setCreatedAt(createdAt);
        user.setUpdatedAt(updatedAt);
        return user;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public Date getCreatedAt() {
        return createdAt;
    }

    public void setCreatedAt(Date createdAt) {
        this.createdAt = createdAt;
    }

    public Date getUpdatedAt() {
        return updatedAt;
    }

    public void setUpdatedAt(Date updatedAt) {
        this.updatedAt = updatedAt;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

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
