package home.map.events.service;

import home.map.events.entity.Comment;
import home.map.events.entity.Event;
import home.map.events.entity.Route;
import home.map.events.entity.UserDetail;

/**
 * Created by greg on 23.08.15.
 */
public interface CommentService {
    Comment addCommentToEvent(Event event, String text);

    Comment addCommentToRoute(Route route, String text);

    boolean editComment(Comment comment, UserDetail user);
}
