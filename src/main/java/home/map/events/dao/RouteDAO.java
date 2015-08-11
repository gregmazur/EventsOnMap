package home.map.events.dao;

import home.map.events.entity.Route;
import home.map.events.entity.UserDetail;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.Collection;

/**
 * Created by greg on 21.07.15.
 */
public interface RouteDAO extends JpaRepository<Route,Long> {
    @Query("SELECT r FROM  Route r WHERE r.createdBy = :userdetail")
    Collection<Route> getRoutesCreatedByUser(@Param("userdetail")UserDetail user);



    @Query("SELECT r FROM Route r WHERE r.name LIKE name")
    Collection<Route> getRouteContainsName(@Param("name")String name);

}
