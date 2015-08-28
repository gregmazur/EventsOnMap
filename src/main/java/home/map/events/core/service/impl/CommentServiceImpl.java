package home.map.events.core.service.impl;

import home.map.events.core.entity.Comment;
import home.map.events.core.service.CommentService;
import home.map.events.dao.CommentDAO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

/**
 * Created by greg on 28.08.15.
 */
@Service @Transactional public class CommentServiceImpl implements CommentService {
    @Autowired private CommentDAO dao;

    @Override public Comment getById(Long id) {
        return dao.findOne(id);
    }

    @Override public Comment updateComment(Long id, Comment comment) {
        //TODO
        return null;
    }

    @Override public Comment removeComment(Long id) {
        return null;
    }
}
