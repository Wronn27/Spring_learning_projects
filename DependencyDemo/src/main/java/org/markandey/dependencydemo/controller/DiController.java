package org.markandey.dependencydemo.controller;

import org.markandey.dependencydemo.service.DiService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class DiController {

    @Autowired
    private DiService service;

    @GetMapping("/start")
    public String start(){
        service.compile();
        return "Done";
    }
}
