package home.map.events.rest.mvc;

import home.map.events.core.entity.Route;
import home.map.events.core.service.RouteService;
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
 * Created by greg on 24.08.15.
 */
public class RouteControllerTest {
    @InjectMocks private RouteController controller;
    private MockMvc mockMvc;
    @Mock private RouteService service;

    @Before public void setup() {
        MockitoAnnotations.initMocks(this);
        mockMvc = MockMvcBuilders.standaloneSetup(controller).build();
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
