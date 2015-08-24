package home.map.events.rest.resources;

import home.map.events.core.entity.*;
import org.springframework.hateoas.ResourceSupport;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Date;

/**
 * Created by greg on 23.08.15.
 */
public class RouteResource extends ResourceSupport {

    private String name;
    private Collection<Point> routePoints = new ArrayList<Point>();
    private Collection<Event> routeEvents = new ArrayList<Event>();
    private Collection<Comment> comments = new ArrayList<Comment>();
    private Collection<UserDetail> usersTagged = new ArrayList<UserDetail>();
    private UserDetail createdBy;
    private Date createdAt;

    public Route toRoute() {
        Route route = new Route();
        route.setName(name);

        route.setRoutePoints(routePoints);
        route.setRouteEvents(routeEvents);
        route.setCreatedAt(createdAt);
        route.setUsersTagged(usersTagged);
        route.setCreatedBy(createdBy);
        return route;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
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

    public Collection<Comment> getComments() {
        return comments;
    }

    public void setComments(Collection<Comment> comments) {
        this.comments = comments;
    }

    public Collection<UserDetail> getUsersTagged() {
        return usersTagged;
    }

    public void setUsersTagged(Collection<UserDetail> usersTagged) {
        this.usersTagged = usersTagged;
    }

    public UserDetail getCreatedBy() {
        return createdBy;
    }

    public void setCreatedBy(UserDetail createdBy) {
        this.createdBy = createdBy;
    }

    public Date getCreatedAt() {
        return createdAt;
    }

    public void setCreatedAt(Date createdAt) {
        this.createdAt = createdAt;
    }
}
