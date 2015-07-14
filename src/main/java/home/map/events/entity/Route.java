package home.map.events.entity;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.Collection;
import java.util.HashSet;


/**
 * Created by greg on 14.07.15.
 */
@Entity
public class Route extends BaseEntity {
    @ElementCollection
    private Collection<Point> routePoints = new ArrayList<Point>();
    @OneToMany
    private Collection<Event> routeEvents = new ArrayList<Event>();
    @ManyToOne
    private UserDetail createdBy;
    @OneToMany
    private Collection<UserDetail> usersTagged = new HashSet<UserDetail>();


    public Route(UserDetail createdBy) {
        super();
        this.createdBy = createdBy;
        usersTagged.add(createdBy);
    }

    public Collection<Point> getRoutePoints() {
        return routePoints;
    }

    public void setRoutePoints(Collection<Point> routePoints) {
        this.routePoints = routePoints;
    }

    public Collection<Event> getRouteEvents() {
        return routeEvents;
    }

    public void setRouteEvents(Collection<Event> routeEvents) {
        this.routeEvents = routeEvents;
    }

    public UserDetail getCreatedBy() {
        return createdBy;
    }

    public void setCreatedBy(UserDetail createdBy) {
        this.createdBy = createdBy;
    }

    public Collection<UserDetail> getUsersTagged() {
        return usersTagged;
    }

    public void setUsersTagged(Collection<UserDetail> usersTagged) {
        this.usersTagged = usersTagged;
    }
}
