package home.map.events.core.entity;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.Collection;


/**
 * Created by greg on 14.07.15.
 */
@Entity @Table (name = "Route")
@AttributeOverride (name = "id", column = @Column (name = "route_id",
    nullable = false, columnDefinition = "bigserial")) public class Route extends BaseEntityAudit {

    @ElementCollection private Collection<Point> routePoints = new ArrayList<Point>();

    @OneToMany @JoinTable (name = "\"users_tagged_at_route\"") private Collection<UserDetail>
        usersTagged = new ArrayList<UserDetail>();

    public Route() {
    }

    public synchronized void addPoint(Point point) {
        routePoints.add(point);
    }

    public Collection<Point> getRoutePoints() {
        return routePoints;
    }

    public void setRoutePoints(Collection<Point> routePoints) {
        this.routePoints = routePoints;
    }

    public Collection<UserDetail> getUsersTagged() {
        return usersTagged;
    }

    public void setUsersTagged(Collection<UserDetail> usersTagged) {
        this.usersTagged = usersTagged;
    }


}
