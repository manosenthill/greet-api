package org.myorg;

import lombok.AllArgsConstructor;
import lombok.Getter;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class GreetApiController {

    @GetMapping("/api/hello")
    Response getGreeting(){
        return new Response("Hello, there");
    }

    @AllArgsConstructor
    @Getter
    class Response{
        String message;
    }
}
