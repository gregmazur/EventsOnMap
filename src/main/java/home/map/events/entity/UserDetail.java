package home.map.events.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.NamedQuery;
import javax.persistence.Table;

/**
 * Created by greg on 14.07.15.
 */
@Entity
@Table(name = "users")
@NamedQuery(name = "UserDetail.getUser", query = "FROM UserDetail WHERE login=:login AND password=:password")
public class UserDetail extends BaseEntity {
    @Column
    private String login;
    @Column
    private String password;
    @Column
    private String city;
    @Column
    private long quantityOfEventsPosted;
    @Column
    private long quantityOfRoutesPosted;

    public UserDetail(String login, String password, String city) {
        super();
        this.login = login;
        this.password = password;
        this.city = city;
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
}
