package com.example.upload702.controller;


import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/person")
public class PersonController {
    private final String prefix = "person/";

    @RequestMapping("/homePage")
    public String mainPage(){
        return prefix+"personal-home";
    }

    @RequestMapping("/headPage")
    public String headPage(){
        return prefix+"personal-head";
    }
    @RequestMapping("/informationPage")
    public String informationPage(){
        return prefix+"personal-information";
    }

}
