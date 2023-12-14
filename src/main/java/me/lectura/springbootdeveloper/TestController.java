package me.lectura.springbootdeveloper;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class TestController {
    @GetMapping("/test") // http://localhost:8080/test GET 접속
    public String test(){
        return "Hello, World!";
    }
}
