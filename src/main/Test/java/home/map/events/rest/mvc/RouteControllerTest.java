package home.map.events.rest.mvc;

import home.map.events.service.RouteService;
import org.junit.Before;
import org.junit.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;

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

    }

    @Test public void testDeleteRoute() throws Exception {

    }
}
