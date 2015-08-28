package home.map.events.core.entity;

import javax.persistence.AttributeOverride;
import javax.persistence.Column;
import javax.persistence.Entity;

/**
 * Created by greg on 16.07.15.
 */
@Entity @AttributeOverride (name = "id", column = @Column (name = "comment_id",
    nullable = false, columnDefinition = "bigserial"))
public class Comment extends BaseEntityAudit {
    @Column private Route ownerRoute;
    @Column private Event ownerEvent;
    @Column (name = "text") private String text;

    public Comment() {
    }

    public Comment(String text) {
        this.text = text;
    }

    public String getText() {
        return text;
    }

    public void setText(String text) {
        this.text = text;
    }

    public Route getOwnerRoute() {
        return ownerRoute;
    }

    public void setOwnerRoute(Route owner) {
        this.ownerRoute = owner;
    }

    public Event getOwnerEvent() {
        return ownerEvent;
    }

    public void setOwnerEvent(Event ownerEvent) {
        this.ownerEvent = ownerEvent;
    }
}
