package home.map.events.rest.mvc;

import home.map.events.core.entity.Route;
import home.map.events.core.service.TestService;
import org.junit.Before;
import org.junit.Test;
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
public class TestControllerTest {

    @InjectMocks private TestController controller;


    @Mock private TestService service;


    private MockMvc mockMvc;


    @Before public void setup() {
        MockitoAnnotations.initMocks(this);


        mockMvc = MockMvcBuilders.standaloneSetup(controller).build();
    }


    @Test public void getTest() throws Exception {
        home.map.events.core.entity.Test test = new home.map.events.core.entity.Test();
        test.setId(1L);

        test.setName("Greg");


        when(service.find(1L)).thenReturn(test);


        mockMvc.perform(get("/test/1")).andDo(print())
            .andExpect(jsonPath("$.name", is(test.getName())))
            .andExpect(jsonPath("$.links[*].href", hasItem(endsWith("/1"))))
            .andExpect(status().isOk());
    }

    @Test public void createRouteExistingUser() throws Exception {
        Route createdRoute = new Route();
        createdRoute.setId(1L);
        createdRoute.setName("Test Route");


        when(service.createRoute(eq(1L), any(Route.class))).thenReturn(createdRoute);


        mockMvc.perform(post("profile/1/routes").content("{\"name\":\"Test Route\"}")
            .contentType(MediaType.APPLICATION_JSON)).andDo(print())
            .andExpect(jsonPath("$.name", is("Test Route")))
            .andExpect(jsonPath("$.links[*].href", hasItem(endsWith("/routes/1"))))
            .andExpect(header().string("Location", endsWith("/routes/1")))
            .andExpect(status().isCreated());
    }

}
