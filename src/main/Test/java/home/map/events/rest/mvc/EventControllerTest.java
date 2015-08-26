package home.map.events.rest.mvc;

import home.map.events.core.entity.Event;
import home.map.events.core.entity.Route;
import home.map.events.core.entity.UserDetail;
import home.map.events.core.service.EventService;
import org.junit.Before;
import org.junit.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;

import static org.hamcrest.Matchers.*;
import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

/**
 * Created by greg on 26.08.15.
 */
public class EventControllerTest {
    @InjectMocks private EventController controller;
    @Mock private EventService service;

    private MockMvc mockMvc;
    private UserDetail user;
    private Route route;

    @Before public void setup() {
        user = new UserDetail();
        route = new Route();
        user.setId(1L);
        route.setCreatedBy(user);
        MockitoAnnotations.initMocks(this);
        mockMvc = MockMvcBuilders.standaloneSetup(controller).build();

    }

    @Test public void testGetRoute() throws Exception {
        Event event = new Event();
        event.setId(1L);
        event.setCreatedBy(user);
        event.setName("test");
        when(service.getById(1L)).thenReturn(event);

        mockMvc.perform(get("/event/1")).andDo(print())
            .andExpect(jsonPath("$.name", is(event.getName())))
            .andExpect(jsonPath("$.links[*].href", hasItem(endsWith("event/1"))))
            .andExpect(status().isOk());
    }
}
