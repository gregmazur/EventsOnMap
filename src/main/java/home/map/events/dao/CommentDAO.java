package home.map.events.dao;

import home.map.events.entity.Comment;

/**
 * Created by greg on 22.07.15.
 */
public interface CommentDAO {
    void addComment(Comment comment);

    void updateComment(Comment comment);

    void removeComment(Comment comment);
}
