package home.map.events.rest.mvc;


import org.junit.Before;
import org.junit.Test;
import org.mockito.InjectMocks;
import org.mockito.MockitoAnnotations;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;

/**
 * Created by greg on 23.08.15.
 */
public class ControllerClassTest {

    private MockMvc mockMvc;
    @InjectMocks
    private ControllerClass controller;
    @Before
    public void setup() {
        MockitoAnnotations.initMocks(this);


        mockMvc = MockMvcBuilders.standaloneSetup(controller).build();
    }
    @Test
    public void testWelcome() throws Exception {
        mockMvc.perform(get("/welcome")).andDo(print());
    }
}
