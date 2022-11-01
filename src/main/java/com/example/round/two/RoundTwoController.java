package com.example.round.two;

import com.example.payload.ResponseDTO;
import com.example.round.dto.RoundTwoCreateDTO;
import com.example.round.dto.RoundTwoDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.Valid;

@RestController
@RequestMapping("/v1/round-two")
public class RoundTwoController {


    private final RoundTwoService service;

    @Autowired
    public RoundTwoController(RoundTwoService service) {
        this.service = service;
    }


    @PostMapping
    public ResponseEntity<ResponseDTO<RoundTwoDTO>> create(@Valid @RequestBody RoundTwoCreateDTO dto) {

        return service.create(dto);

    }

}
