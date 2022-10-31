package com.example.integritypact;

import com.example.integritypact.dto.IntegrityPactCreateDTO;
import com.example.integritypact.dto.IntegrityPactDTO;
import com.example.integritypact.mapper.IntegrityPackMapper;
import com.example.payload.ResponseDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class IntegrityPactService {

    private final IntegrityPactRepository repository;
    private final IntegrityPackMapper mapper;

    @Autowired
    public IntegrityPactService(IntegrityPactRepository repository, IntegrityPackMapper mapper) {
        this.repository = repository;
        this.mapper = mapper;
    }


    public ResponseEntity<ResponseDTO<List<IntegrityPactDTO>>> getAll() {

        return new ResponseEntity<>(new ResponseDTO<>(repository.getAll(), "success", 200), HttpStatus.OK);
    }


    public ResponseEntity<ResponseDTO<List<IntegrityPactDTO>>> getIntegrityPactByTenderIdAndBidderId(Integer tenderId, Integer bidderId) {

        return new ResponseEntity<>(new ResponseDTO<>(repository.getIntegrityPactByTenderIdAndBidderId(tenderId, bidderId), "success", 200), HttpStatus.OK);
    }


    public ResponseEntity<ResponseDTO<IntegrityPactDTO>> create(IntegrityPactCreateDTO dto) {

        Optional<IntegrityPact> optionalIntegrityPact = repository.findByTenderIdAndBidderId(dto.getTenderId(), dto.getBidderId());

        if (optionalIntegrityPact.isPresent()) throw new RuntimeException("Integrity Pact already exist");

        IntegrityPact fromCreateDTO = mapper.fromCreateDTO(dto);

        IntegrityPact integrityPact = repository.save(fromCreateDTO);

        return new ResponseEntity<>(new ResponseDTO<>(mapper.toDTO(integrityPact), "successfully created", 201), HttpStatus.CREATED);
    }

}
