package dev.mugi.scaler.firstspringprojectscaler;

import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class Hello {

    @RequestMapping("hello")
    public String sayHello() {
        return "Hello, Developer!";
    }

    @RequestMapping("hello/{name}")
    public String sayHelloWhenLogin(@PathVariable("name") String userName) {
        return "Hello, " + userName + "!";
    }

}
