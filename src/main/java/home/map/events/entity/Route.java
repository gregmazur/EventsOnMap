package home.map.events.entity;

import javax.persistence.ElementCollection;
import javax.persistence.Entity;
import javax.persistence.OneToMany;
import java.util.ArrayList;
import java.util.Collection;


/**
 * Created by greg on 14.07.15.
 */
@Entity
public class Route extends BaseEntity {
    @ElementCollection
    private Collection<Point> routePoints = new ArrayList<Point>();
    @OneToMany
    private Collection<Event> routeEvents = new ArrayList<Event>();
    @OneToMany
    private Collection<Comment> comments = new ArrayList<Comment>();


    public Route(UserDetail createdBy) {
        super();
        setCreatedBy(createdBy);
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
}
