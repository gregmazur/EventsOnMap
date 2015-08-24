package home.map.events.dao;

import home.map.events.core.entity.Route;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.Collection;

/**
 * Created by greg on 21.07.15.
 */
public interface RouteDAO extends JpaRepository<Route,Long> {
    @Query ("SELECT r FROM  Route r WHERE r.createdBy.id = :userId")
    Collection<Route> getRoutesCreatedByUser(@Param ("userId") Long userId);



    @Query("SELECT r FROM Route r WHERE r.name LIKE CONCAT('%',:entered_name,'%')")
    Collection<Route> getRouteContainsName(@Param("entered_name")String name);

}
