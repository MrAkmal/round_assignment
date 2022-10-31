package com.example.integritypact;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
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

    @GetMapping("/{tenderId}/{bidderId}")
    public ResponseEntity getIntegrityPactByTenderIdAndBidderId(@PathVariable Integer tenderId, @PathVariable Integer bidderId) {
        return null;
    }
}
