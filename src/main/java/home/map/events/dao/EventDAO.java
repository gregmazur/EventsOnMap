package home.map.events.dao;

import home.map.events.core.entity.Event;
import home.map.events.core.entity.Route;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

/**
 * Created by greg on 22.07.15.
 */
public interface EventDAO extends JpaRepository<Event,Long>{
    @Query ("SELECT e FROM  Event e WHERE e.createdBy.id = :userId") List<Event> findByCreatedBy(
        @Param ("userId") Long userId);

    @Query ("SELECT e FROM Event e WHERE e.name LIKE CONCAT('%',:name,'%')")
    List<Event> findByNameContaining(@Param ("name") String name);

    /**
     * Created with Spring DATA
     *
     * @param route
     * @return
     */
    List<Event> findByRoute(Route route);

    Event findByName(String name);
}
