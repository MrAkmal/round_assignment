package com.example.round.one;

import com.example.payload.ResponseDTO;
import com.example.round.dto.RoundOneCreateDTO;
import com.example.round.dto.RoundOneDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.Valid;

@RestController
@RequestMapping("/v1/round-one")
public class RoundOneController {


    private final RoundOneService service;

    @Autowired
    public RoundOneController(RoundOneService service) {
        this.service = service;
    }


    @PostMapping
    public ResponseEntity<ResponseDTO<RoundOneDTO>> create(@Valid @RequestBody RoundOneCreateDTO dto) {

        return service.create(dto);

    }

}
