package com.example.bidsecuringdeclaration;

import com.example.bidsecuringdeclaration.dto.BidSecuringDeclarationCreateDTO;
import com.example.bidsecuringdeclaration.dto.BidSecuringDeclarationDTO;
import com.example.bidsecuringdeclaration.mapper.BidSecuringDeclarationMapper;
import com.example.payload.ResponseDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class BidSecuringDeclarationService {

    private final BidSecuringDeclarationRepository repository;
    private final BidSecuringDeclarationMapper mapper;

    @Autowired
    public BidSecuringDeclarationService(BidSecuringDeclarationRepository repository, BidSecuringDeclarationMapper mapper) {
        this.repository = repository;
        this.mapper = mapper;
    }


    public ResponseEntity<ResponseDTO<List<BidSecuringDeclarationDTO>>> getAllBidSecuringDeclaration() {

        return new ResponseEntity<>(new ResponseDTO<>(repository.getAll(), "success", 200), HttpStatus.OK);
    }


    public ResponseEntity<ResponseDTO<List<BidSecuringDeclarationDTO>>> getBidSecuringDeclarationByTenderIdAndBidderId(Integer tenderId, Integer bidderId) {

        return new ResponseEntity<>(new ResponseDTO<>(repository.getBidSecuringDeclarationByTenderIdAndBidderId(tenderId, bidderId), "success", 200), HttpStatus.OK);
    }


    public ResponseEntity<ResponseDTO<BidSecuringDeclarationDTO>> create(BidSecuringDeclarationCreateDTO dto) {

        Optional<BidSecuringDeclaration> optionalBidSecuringDeclaration = repository.findByTenderIdAndBidderId(dto.getTenderId(), dto.getBidderId());

        if (optionalBidSecuringDeclaration.isPresent())
            throw new RuntimeException("BidSecureDeclaration already exist");

        BidSecuringDeclaration fromCreateDTO = mapper.fromCreateDTO(dto);

        BidSecuringDeclaration bidSecuringDeclaration = repository.save(fromCreateDTO);

        return new ResponseEntity<>(new ResponseDTO<>(mapper.toDTO(bidSecuringDeclaration), "successfully created", 201), HttpStatus.CREATED);

    }


}
