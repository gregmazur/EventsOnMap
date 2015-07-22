package home.map.events.entity;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.Collection;

/**
 * Created by greg on 14.07.15.
 */
@Entity
@AttributeOverride(name = "id", column = @Column(name = "event_id",
        nullable = false, columnDefinition = "BIGINT UNSIGNED"))
public class Event extends BaseEntityAudit {
    @Embedded
    private Point point;

    @OneToMany(cascade = CascadeType.ALL)
    @JoinTable(name = "event_comments")
    private Collection<Comment> comments = new ArrayList<Comment>();

    public Event(UserDetail createdBy, Point point) {
        super();
        this.point = point;
        setCreatedBy(createdBy);
    }

    public Event() {
    }

    public Point getPoint() {
        return point;
    }

    public void setPoint(Point point) {
        this.point = point;
    }
}
