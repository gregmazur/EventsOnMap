package home.map.events.entity;

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

    @OneToMany (cascade = CascadeType.ALL) @JoinTable (name = "\"route_events\"")
    private Collection<Event> routeEvents = new ArrayList<Event>();

    @OneToMany (cascade = CascadeType.ALL, fetch = FetchType.EAGER, targetEntity = Comment.class)
    @JoinTable (name = "route_comments", joinColumns = {
        @JoinColumn (name = "route_id")}, inverseJoinColumns = {@JoinColumn (name = "comment_id")})
    private Collection<Comment> comments = new ArrayList<Comment>();
    @OneToMany @JoinTable (name = "\"users_tagged_at_route\"") private Collection<UserDetail>
        usersTagged = new ArrayList<UserDetail>();

    public Route() {
    }

    public Route(UserDetail createdBy) {
        super();
        setCreatedBy(createdBy);
    }

    public synchronized void addEvent(Event event) {
        routeEvents.add(event);
    }

    public synchronized void addPoint(Point point) {
        routePoints.add(point);
    }

    public synchronized void addComment(Comment comment) {
        comments.add(comment);
    }

    public synchronized void removeComment(Comment comment) {
        comments.remove(comment);
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

    public Collection<UserDetail> getUsersTagged() {
        return usersTagged;
    }

    public void setUsersTagged(Collection<UserDetail> usersTagged) {
        this.usersTagged = usersTagged;
    }

    public Collection<Comment> getComments() {
        return comments;
    }

    public void setComments(Collection<Comment> comments) {
        this.comments = comments;
    }
}
