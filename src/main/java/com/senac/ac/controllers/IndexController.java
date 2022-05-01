package com.senac.ac.controllers;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class IndexController {

    @Value("${base.index}")
    private String index;

    @RequestMapping("/automation/v1/api")
    public String index(){
        return index;
    }
}
