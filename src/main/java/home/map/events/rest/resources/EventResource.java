package home.map.events.rest.resources;

import home.map.events.core.entity.Comment;
import home.map.events.core.entity.Event;
import home.map.events.core.entity.Point;
import home.map.events.core.entity.UserDetail;
import org.springframework.hateoas.ResourceSupport;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Date;

/**
 * Created by greg on 25.08.15.
 */
public class EventResource extends ResourceSupport {
    private String name;
    private UserDetail createdBy;
    private UserDetail updatedBy;
    private Date createdAt;
    private Date updatedAt;
    private Point point;
    private Collection<Comment> comments = new ArrayList<Comment>();
    private Collection<UserDetail> usersTagged = new ArrayList<UserDetail>();

    public Event toEvent() {
        Event event = new Event();
        event.setName(name);
        event.setCreatedAt(createdAt);
        event.setUpdatedAt(updatedAt);
        event.setUpdatedBy(updatedBy);
        event.setCreatedBy(createdBy);
        event.setUsersTagged(usersTagged);
        event.setPoint(point);
        event.setComments(comments);
        return event;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public UserDetail getCreatedBy() {
        return createdBy;
    }

    public void setCreatedBy(UserDetail createdBy) {
        this.createdBy = createdBy;
    }

    public UserDetail getUpdatedBy() {
        return updatedBy;
    }

    public void setUpdatedBy(UserDetail updatedBy) {
        this.updatedBy = updatedBy;
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

    public Point getPoint() {
        return point;
    }

    public void setPoint(Point point) {
        this.point = point;
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
}
