package home.map.events.dao.daoImpl;

import home.map.events.dao.CommentDAO;
import home.map.events.entity.Comment;

/**
 * Created by greg on 24.07.15.
 */
public class CommentDaoImpl extends DAOUtils<Comment> implements CommentDAO {
    public void addComment(Comment comment) throws WritingDataException {
        add(comment);
    }

    public void updateComment(Comment comment) throws WritingDataException {
        update(comment);
    }

    public void removeComment(Comment comment) throws WritingDataException {
        delete(comment);
    }
}
