package home.map.events.core.service.util;

import home.map.events.core.entity.Comment;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by greg on 28.08.15.
 */
public class CommentList {
    List<Comment> comments = new ArrayList<>();

    public List<Comment> getComments() {
        return comments;
    }

    public void setComments(List<Comment> comments) {
        this.comments = comments;
    }

    public CommentList(List<Comment> comments) {

        this.comments = comments;
    }
}
