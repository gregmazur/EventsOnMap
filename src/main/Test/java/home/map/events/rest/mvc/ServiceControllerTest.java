package home.map.events.rest.mvc;

import home.map.events.service.UserService;
import org.mockito.InjectMocks;
import org.mockito.Mock;

import static org.junit.Assert.*;

/**
 * Created by greg on 23.08.15.
 */
public class ServiceControllerTest {
    @InjectMocks
    private ServiceController controller;

    @Mock
    private UserService service;



}
