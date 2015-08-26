package home.map.events.rest.mvc;

import home.map.events.core.entity.UserDetail;
import home.map.events.core.service.UserService;
import org.junit.Before;
import org.junit.Test;
import org.mockito.ArgumentCaptor;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;

import static org.hamcrest.Matchers.endsWith;
import static org.hamcrest.Matchers.is;
import static org.junit.Assert.assertEquals;
import static org.mockito.Matchers.any;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;
/**
 * Created by greg on 23.08.15.
 */
public class UserControllerTest {
    @InjectMocks private UserController controller;
    private MockMvc mockMvc;
    @Mock private UserService service;
    private ArgumentCaptor<UserDetail> captor;
    @Before public void setup() {
        MockitoAnnotations.initMocks(this);
        mockMvc = MockMvcBuilders.standaloneSetup(controller).build();
    }

    //        @Test public void createRouteExistingUser() throws Exception {
    //            Route createdRoute = new Route();
    //            createdRoute.setId(1L);
    //            createdRoute.setName("Test Route");
    //
    //            when(service.createRoute(eq(1L), any(Route.class))).thenReturn(createdRoute);
    //
    //
    //            mockMvc.perform(post("profile/1/routes").content("{\"name\":\"Test Route\"}")
    //                .contentType(MediaType.APPLICATION_JSON)).andDo(print())
    //                .andExpect(jsonPath("$.name", is("Test Route")))
    //                .andExpect(jsonPath("$.links[*].href", hasItem(endsWith("/routes/1"))))
    //                .andExpect(header().string("Location", endsWith("/routes/1")))
    //                .andExpect(status().isCreated());
    //        }

    @Test public void getExistingAccount() throws Exception {
        UserDetail foundUser = new UserDetail();
        foundUser.setId(1L);
        foundUser.setPassword("test");
        foundUser.setName("test");

        when(service.getByID(1L)).thenReturn(foundUser);

        mockMvc.perform(get("/profile/1")).andDo(print())
            .andExpect(jsonPath("$.password", is(foundUser.getPassword())))
            .andExpect(jsonPath("$.name", is(foundUser.getName()))).andExpect(status().isOk());

        System.out.print(service.getByID(1L));
    }

    @Test public void createUserTest() throws Exception {
        UserDetail userDetail = new UserDetail();
        userDetail.setId(1L);
        userDetail.setPassword("test");
        userDetail.setName("test");


        when(service.createUser(any(UserDetail.class))).thenReturn(userDetail);


        mockMvc.perform(post("/profile").content("{\"name\":\"test\",\"password\":\"test\"}")
            .accept(MediaType.APPLICATION_JSON).contentType(MediaType.APPLICATION_JSON))
            .andDo(print()).andExpect(header().string("Location", endsWith("/rest/accounts/1")))
            .andExpect(jsonPath("$.name", is(userDetail.getName())))
            .andExpect(status().isCreated());


        verify(service).createUser(captor.capture());


        String password = captor.getValue().getPassword();
        assertEquals("test", password);
    }

}
