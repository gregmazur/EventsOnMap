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
    @OneToMany(cascade = CascadeType.ALL, fetch = FetchType.EAGER, targetEntity = Comment.class)
    @JoinTable(name = "event_comments", joinColumns = {
        @JoinColumn(name = "event_id")}, inverseJoinColumns = {@JoinColumn(name = "comment_id")})
    private Collection<Comment> comments = new ArrayList<Comment>();
    @OneToMany
    @JoinTable(name = "\"users_tagged_at_event\"")
    private Collection<UserDetail> usersTagged = new ArrayList<UserDetail>();

    public Event(UserDetail createdBy, Point point, Route route) {
        super();
        this.point = point;
        this.route = route;
        setCreatedBy(createdBy);
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

    public Collection<Comment> getComments() {
        return comments;
    }

    public synchronized void addComment(Comment comment){
        comments.add(comment);
    }

    public synchronized void removeComment(Comment comment){
        comments.remove(comment);
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
