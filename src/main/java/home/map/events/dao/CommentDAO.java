package home.map.events.dao;

import home.map.events.core.entity.Comment;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 * Created by greg on 22.07.15.
 */
public interface CommentDAO extends JpaRepository<Comment,Long> {

}
