package home.map.events.rest.mvc;

import home.map.events.service.UserService;
import org.junit.Before;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;

/**
 * Created by greg on 23.08.15.
 */
public class UserControllerTest {
    @InjectMocks private UserController controller;
    private MockMvc mockMvc;
    @Mock
    private UserService service;

    @Before public void setup() {
        MockitoAnnotations.initMocks(this);
        mockMvc = MockMvcBuilders.standaloneSetup(controller).build();
    }


}
