package home.map.events.entity;

import javax.persistence.Entity;

/**
 * Created by greg on 16.07.15.
 */
@Entity
public class Comment extends BaseEntity {
    private String text;

    public String getText() {
        return text;
    }

    public void setText(String text) {
        this.text = text;
    }
}
