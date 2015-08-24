package home.map.events.rest.mvc;

import home.map.events.core.entity.Test;
import home.map.events.core.service.TestService;
import home.map.events.rest.resources.TestResource;
import home.map.events.rest.resources.asm.TestResourceAsm;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

/**
 * Created by greg on 24.08.15.
 */
@Controller public class TestController {
    private TestService service;

    public TestController(TestService service) {
        this.service = service;
    }

    @RequestMapping (value = "/test/{testId}",
        method = RequestMethod.GET)
    public ResponseEntity<TestResource> getRoute(@PathVariable Long testId) {
        Test test = service.find(testId);
        if (test != null) {
            TestResource res = new TestResourceAsm().toResource(test);
            return new ResponseEntity<TestResource>(res, HttpStatus.OK);
        } else {
            return new ResponseEntity<TestResource>(HttpStatus.NOT_FOUND);
        }
    }
}

