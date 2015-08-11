package home.map.events.entity;

import home.map.events.entity.enums.UserRole;

import javax.persistence.*;

/**
 * Created by greg on 14.07.15.
 */
@Entity
@Table(name = "UserDetail")
@AttributeOverride(name = "id", column = @Column(name = "user_id",
        nullable = false, columnDefinition = "BIGINT UNSIGNED"))
public class UserDetail extends BaseEntityAudit {
    @Column(name = "login",unique = true)
    private String login;
    @Column(name = "password")
    private String password;
    @Column(name = "city")
    private String city;
    @Column
    private long quantityOfEventsPosted;
    @Column
    private long quantityOfRoutesPosted;
    @Column
    private long quantityOfCommentsLeft;
    @Column(name = "role")
    @Enumerated
    UserRole role;

    public UserDetail(String login, String password, String city) {
        super();
        this.login = login;
        this.password = password;
        this.city = city;
    }

    public UserDetail() {
    }

    public UserRole getRole() {
        return role;
    }

    public void setRole(UserRole role) {
        this.role = role;
    }

    public String getLogin() {
        return login;
    }

    public void setLogin(String login) {
        this.login = login;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
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

    @Override
    public String toString() {
        return super.toString()+" UserDetail{" +
                "login='" + login + '\'' +
                ", password='" + password + '\'' +
                ", city='" + city + '\'' +
                ", quantityOfEventsPosted=" + quantityOfEventsPosted +
                ", quantityOfRoutesPosted=" + quantityOfRoutesPosted +
                '}';
    }
}
