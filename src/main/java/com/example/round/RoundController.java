package com.example.round;

import com.example.payload.ResponseDTO;
import com.example.round.dto.RoundDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/v1/round")
public class RoundController {

    private final RoundService service;

    @Autowired
    public RoundController(RoundService service) {
        this.service = service;
    }


    @GetMapping("/{tender_id}/{round_number}")
    public ResponseEntity<ResponseDTO<List<RoundDTO>>> getAll(@PathVariable("tender_id") Integer tenderId, @PathVariable("round_number") Integer roundNumber) {
        return service.getAllByTenderIdAndRoundNumber(tenderId,roundNumber);
    }

}
