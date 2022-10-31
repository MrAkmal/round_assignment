package com.example.bidsecuringdeclaration;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/v1/bud_securing_declaration")
public class BidSecuringDeclarationController {

    private final BidSecuringDeclarationService bidSecuringDeclarationService;

    @Autowired
    public BidSecuringDeclarationController(BidSecuringDeclarationService bidSecuringDeclarationService) {
        this.bidSecuringDeclarationService = bidSecuringDeclarationService;
    }

    @GetMapping("/{tenderId}/{bidderId}")
    public ResponseEntity getBidSecuringDeclarationByTenderIdAndBidderId(@PathVariable Integer tenderId, @PathVariable Integer bidderId) {
        return null;
    }

    @PostMapping
    public ResponseEntity create(@RequestBody String dto) {
        return null;
    }
}
