package com.example.round;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/v1/round")
public class RoundController {

    private final RoundService service;

    @Autowired
    public RoundController(RoundService service) {
        this.service = service;
    }


    

}
