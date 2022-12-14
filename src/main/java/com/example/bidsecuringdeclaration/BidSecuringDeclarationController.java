package com.example.bidsecuringdeclaration;

import com.example.bidsecuringdeclaration.dto.BidSecuringDeclarationCreateDTO;
import com.example.bidsecuringdeclaration.dto.BidSecuringDeclarationDTO;
import com.example.payload.ResponseDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RestController
@RequestMapping("/api/v1/bud_securing_declaration")
public class BidSecuringDeclarationController {

    private final BidSecuringDeclarationService service;


    @Autowired
    public BidSecuringDeclarationController(BidSecuringDeclarationService service) {
        this.service = service;
    }


    @GetMapping
    public ResponseEntity<ResponseDTO<List<BidSecuringDeclarationDTO>>> getAllBidSecuringDeclaration() {
        return service.getAllBidSecuringDeclaration();
    }


    @GetMapping("/{tenderId}/{bidderId}")
    public ResponseEntity<ResponseDTO<List<BidSecuringDeclarationDTO>>> getBidSecuringDeclarationByTenderIdAndBidderId(@PathVariable Integer tenderId, @PathVariable Integer bidderId) {
        return service.getBidSecuringDeclarationByTenderIdAndBidderId(tenderId, bidderId);
    }


    @PostMapping
    public ResponseEntity<ResponseDTO<BidSecuringDeclarationDTO>> create(@Valid @RequestBody BidSecuringDeclarationCreateDTO dto, BindingResult result) {

        return service.create(dto);
    }

}
