package home.map.events.dao;

import home.map.events.core.entity.Comment;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.Collection;

/**
 * Created by greg on 22.07.15.
 */
public interface CommentDAO extends JpaRepository<Comment,Long> {
    @Query ("SELECT c FROM  Comment c WHERE c.createdBy.id = :userId")
    Collection<Comment> findByCreatedBy(@Param ("userId") Long userId);

    Comment findByName(String name);
}
