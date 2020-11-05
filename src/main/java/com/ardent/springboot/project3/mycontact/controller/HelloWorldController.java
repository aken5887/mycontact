package com.ardent.springboot.project3.mycontact.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

/**
@Controller
@ResponseBody
 **/
@RestController
public class HelloWorldController {
    @GetMapping(value="/api/helloWorld")
    public String helloWorld(){
        return "HelloWorld";
    }
}
