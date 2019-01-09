package com.example.demo;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

import static jdk.nashorn.internal.runtime.regexp.joni.Config.log;

@Controller
public class TestController {

    @GetMapping("/test")
    private void test(){
        log.println("CHECK TEST API");
    }
}
