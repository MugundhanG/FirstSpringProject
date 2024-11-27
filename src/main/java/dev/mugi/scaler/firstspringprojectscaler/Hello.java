package dev.mugi.scaler.firstspringprojectscaler;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class Hello {

    @RequestMapping("hello")
    public String sayHello() {
        return "Hello, Developer!";
    }

}
