package home.map.events.rest.mvc;

import home.map.events.core.entity.Event;
import home.map.events.core.entity.Route;
import home.map.events.core.service.RouteService;
import org.junit.Before;
import org.junit.Test;
import org.mockito.ArgumentCaptor;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;

import static org.hamcrest.Matchers.*;
import static org.mockito.Matchers.any;
import static org.mockito.Matchers.eq;
import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;
/**
 * Created by greg on 24.08.15.
 */
public class RouteControllerTest {
    @InjectMocks private RouteController controller;
    private MockMvc mockMvc;
    private ArgumentCaptor<Route> routeCaptor;
    @Mock private RouteService service;

    @Before public void setup() {
        MockitoAnnotations.initMocks(this);
        mockMvc = MockMvcBuilders.standaloneSetup(controller).build();

        routeCaptor = ArgumentCaptor.forClass(Route.class);
    }

    @Test public void testGetRoute() throws Exception {
        Route route = new Route();
        route.setName("nameTest");
        route.setId(1L);
        when(service.getById(1L)).thenReturn(route);

        mockMvc.perform(get("/route/1")).andDo(print())
            .andExpect(jsonPath("$.name", is(route.getName())))
            .andExpect(jsonPath("$.links[*].href", hasItem(endsWith("/1"))))
            .andExpect(status().isOk());

    }

    @Test public void getNonExistingBlogEntry() throws Exception {
        when(service.getById(1L)).thenReturn(null);


        mockMvc.perform(get("/route/1")).andExpect(status().isNotFound());
    }

    //    @Test public void addRoute() throws Exception {
    //        Route route = new Route();
    //        route.setId(1L);
    //        route.setName("test");
    //
    //
    //        when(service.addRoute(any(Route.class))).thenReturn(route);
    //
    //
    //        mockMvc.perform(
    //            post("/route").content("{\"name\":\"test\"}").contentType(MediaType.APPLICATION_JSON))
    //            .andDo(print()).andExpect(header().string("Location", Matchers.endsWith("/route/1")))
    //            .andExpect(jsonPath("$.name", is(route.getName()))).andExpect(status().isCreated());
    //
    //
    //        verify(service).addRoute(routeCaptor.capture());
    //    }

    @Test public void createEventExistingRoute() throws Exception {
        Route route = new Route();
        route.setId(1L);


        Event event = new Event();
        event.setName("Test Title");
        event.setId(1L);


        when(service.addEventToRoute(eq(1L), any(Event.class))).thenReturn(event);


        mockMvc.perform(post("/route/1/event").content("{\"name\":\"Test Title\"}")
            .accept(MediaType.APPLICATION_JSON).contentType(MediaType.APPLICATION_JSON))
            .andDo(print()).andExpect(jsonPath("$.name", is(event.getName())))
            .andExpect(jsonPath("$.links[*].href", hasItem(endsWith("event/1"))))
            .andExpect(header().string("Location", endsWith("event/1")))
            .andExpect(status().isCreated());
    }

    //    @Test public void testDeleteRoute() throws Exception {
    //        Route route = new Route();
    //        route.setName("nameTest");
    //        route.setId(1L);
    //        when(service.removeRoute( 1L)).thenReturn(route);
    //
    //        mockMvc.perform(delete("/route/1"))
    //            .andDo(print())
    //            .andExpect(jsonPath("$.name", is(route.getName())))
    //            .andExpect(jsonPath("$.links[*].href",hasItem(endsWith("/1"))))
    //            .andExpect(status().isOk());
    //    }
}
