package home.map.events.rest.resources;

import home.map.events.core.entity.Route;
import org.springframework.hateoas.ResourceSupport;

import java.util.ArrayList;
import java.util.Collection;

/**
 * Created by greg on 24.08.15.
 */
public class TestResource extends ResourceSupport {
    private String text;
    private String name;
    private Collection<Route> list = new ArrayList<Route>();

    public Collection<Route> getList() {
        return list;
    }

    public void setList(Collection<Route> list) {
        this.list = list;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getText() {
        return text;
    }

    public void setText(String text) {
        this.text = text;
    }
}
