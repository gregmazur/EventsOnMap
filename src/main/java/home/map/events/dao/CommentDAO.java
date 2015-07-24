package home.map.events.dao;

import home.map.events.dao.daoImpl.WritingDataException;
import home.map.events.entity.Comment;

/**
 * Created by greg on 22.07.15.
 */
public interface CommentDAO {
    void addComment(Comment comment) throws WritingDataException;
    void updateComment(Comment comment) throws WritingDataException;
    void removeComment(Comment comment) throws WritingDataException;
}
