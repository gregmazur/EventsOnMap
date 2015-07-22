package home.map.events.entity;

import javax.persistence.Column;
import javax.persistence.Entity;

/**
 * Created by greg on 16.07.15.
 */
@Entity
public class Comment extends BaseEntityAudit {
    @Column(name = "text")
    private String text;

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
}
