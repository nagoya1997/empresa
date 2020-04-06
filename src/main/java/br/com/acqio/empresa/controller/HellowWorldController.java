package br.com.acqio.empresa.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("hello")
public class HellowWorldController {

    @GetMapping
    public String hello() {
        return "Hello World";
    }

}
