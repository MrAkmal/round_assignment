package com.example.integritypact;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/v1/integrity_pact")
public class IntegrityPactController {

    private final IntegrityPactService integrityPactService;

    @Autowired
    public IntegrityPactController(IntegrityPactService integrityPactService) {
        this.integrityPactService = integrityPactService;
    }
}
