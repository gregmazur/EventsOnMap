package home.map.events.core.entity;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.Collection;

/**
 * Created by greg on 14.07.15.
 */
@Entity
@Table(name = "Event")
@AttributeOverride(name = "id", column = @Column(name = "event_id",
        nullable = false, columnDefinition = "bigserial"))
public class Event extends BaseEntityAudit {
    @Embedded
    private Point point;
    @Column private Route route;
    @OneToMany
    @JoinTable(name = "\"users_tagged_at_event\"")
    private Collection<UserDetail> usersTagged = new ArrayList<UserDetail>();

    public Event(Point point) {
        super();
        this.point = point;
    }

    public Event() {
    }

    public Route getRoute() {
        return route;
    }

    public void setRoute(Route route) {
        this.route = route;
    }

    public Point getPoint() {
        return point;
    }

    public void setPoint(Point point) {
        this.point = point;
    }



    public Collection<UserDetail> getUsersTagged() {
        return usersTagged;
    }

    public void setUsersTagged(Collection<UserDetail> usersTagged) {
        this.usersTagged = usersTagged;
    }
}
