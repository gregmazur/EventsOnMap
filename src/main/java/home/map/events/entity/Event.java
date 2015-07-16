package home.map.events.entity;

import javax.persistence.Embedded;
import javax.persistence.Entity;
import javax.persistence.OneToMany;
import java.util.ArrayList;
import java.util.Collection;

/**
 * Created by greg on 14.07.15.
 */
@Entity
public class Event extends BaseEntity {
    @Embedded
    private Point point;

    @OneToMany
    private Collection<Comment> comments = new ArrayList<Comment>();

    public Event(UserDetail createdBy, Point point) {
        super();
        this.point = point;
        setCreatedBy(createdBy);
    }

    public Point getPoint() {
        return point;
    }

    public void setPoint(Point point) {
        this.point = point;
    }
}
