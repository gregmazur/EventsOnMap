package home.map.events.entity;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.Collection;


/**
 * Created by greg on 14.07.15.
 */
@Entity
@AttributeOverride(name = "id", column = @Column(name = "route_id",
        nullable = false, columnDefinition = "BIGINT UNSIGNED"))
public class Route extends BaseEntityAudit {

    @ElementCollection
    private Collection<Point> routePoints = new ArrayList<Point>();

    @OneToMany(cascade = CascadeType.ALL)
    @JoinTable(name = "\"route_events\"")
    private Collection<Event> routeEvents = new ArrayList<Event>();

    @OneToMany(cascade = CascadeType.ALL)
    @JoinTable(name = "\"route_comments\"")
    private Collection<Comment> comments = new ArrayList<Comment>();

    public Route() {
    }

    public Route(UserDetail createdBy) {
        super();
        setCreatedBy(createdBy);
    }
    public synchronized void  addEvent(Event event){
        if(!routeEvents.contains(event)){
            routeEvents.add(event);
        }
    }
    public synchronized void  addPoint(Point point){
        if(!routePoints.contains(point)){
            routePoints.add(point);
        }
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
