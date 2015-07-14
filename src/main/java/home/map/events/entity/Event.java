package home.map.events.entity;

import javax.persistence.Embedded;
import javax.persistence.Entity;

/**
 * Created by greg on 14.07.15.
 */
@Entity
public class Event extends Ancestry {
    @Embedded
    private Point point;

    public Event(UserDetail createdBy, Point point) {
        super(createdBy);
        this.point = point;
    }

    public Point getPoint() {
        return point;
    }

    public void setPoint(Point point) {
        this.point = point;
    }
}
