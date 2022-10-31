package com.example.integritypact;

import com.example.integritypact.dto.IntegrityPactCreateDTO;
import com.example.integritypact.dto.IntegrityPactDTO;
import com.example.payload.ResponseDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1/integrity_pact")
public class IntegrityPactController {

    private final IntegrityPactService service;

    @Autowired
    public IntegrityPactController(IntegrityPactService service) {
        this.service = service;
    }


    @GetMapping
    public ResponseEntity<ResponseDTO<List<IntegrityPactDTO>>> getAllIntegrityPact() {
        return service.getAll();
    }


    @GetMapping("/{tenderId}/{bidderId}")
    public ResponseEntity<ResponseDTO<List<IntegrityPactDTO>>> getIntegrityPactByTenderIdAndBidderId(@PathVariable Integer tenderId, @PathVariable Integer bidderId) {
        return service.getIntegrityPactByTenderIdAndBidderId(tenderId, bidderId);
    }


    @PostMapping
    public ResponseEntity<ResponseDTO<IntegrityPactDTO>> create(@RequestBody IntegrityPactCreateDTO dto) {
        return service.create(dto);
    }
}
