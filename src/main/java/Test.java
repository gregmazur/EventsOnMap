import home.map.events.entity.Event;
import home.map.events.entity.Point;
import home.map.events.entity.Route;
import home.map.events.entity.UserDetail;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

/**
 * Created by greg on 13.07.15.
 */
public class Test {
    public static void main(String[] args) {
        UserDetail user = new UserDetail("login","password","Odessa");
        user.setName("creator");
        UserDetail user2 = new UserDetail("second", "password","Odessa");
        user2.setName("someone");
        Point point = new Point(223.56,234.435);
        Route route = new Route(user);
        Event event = new Event(user, point);
        event.setName("Event");
        event.setPoint(point);
        route.getRouteEvents().add(event);
        route.getRoutePoints().add(point);
        route.setName("mainRoute");
        route.getUsersTagged().add(user2);
        route.getUsersTagged().add(user);

        SessionFactory sessionFactory = new Configuration().configure().buildSessionFactory();
        Session session = sessionFactory.openSession();
        session.beginTransaction();
        session.save(user);
        session.save(user2);
        session.save(event);
        session.save(route);
        session.getTransaction().commit();
    }
}
