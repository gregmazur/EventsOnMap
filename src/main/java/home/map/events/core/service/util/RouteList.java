package home.map.events.core.service.util;

import home.map.events.core.entity.Route;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by greg on 28.08.15.
 */
public class RouteList {
    List<Route> routes = new ArrayList<>();

    public RouteList(List<Route> routes) {
        this.routes = routes;
    }

    public List<Route> getRoutes() {
        return routes;
    }

    public void setRoutes(List<Route> routes) {
        this.routes = routes;
    }
}
