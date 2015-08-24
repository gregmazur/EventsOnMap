package home.map.events.core.service;

import home.map.events.core.entity.Comment;

/**
 * Created by greg on 23.08.15.
 */
public interface CommentService {
    Comment getById(Long id);

    Comment updateComment(Long id, Comment comment);

    Comment removeComment(Long id);
}
