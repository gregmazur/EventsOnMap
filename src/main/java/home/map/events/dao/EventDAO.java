package home.map.events.dao;

import home.map.events.entity.Event;
import home.map.events.entity.UserDetail;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.ArrayList;

/**
 * Created by greg on 22.07.15.
 */
public interface EventDAO extends JpaRepository<Event,Long>{
    @Query("SELECT e FROM  Event e WHERE e.createdBy = :userdetail")
    ArrayList<Event> getEventsCreatedByUser(@Param("userdetail")UserDetail user);
}
