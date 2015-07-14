package home.map.events.entity;

import javax.persistence.Embedded;
import javax.persistence.Entity;

/**
 * Created by greg on 14.07.15.
 */
@Entity
public class Event extends BaseEntity {
    @Embedded
    private Point point;

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
