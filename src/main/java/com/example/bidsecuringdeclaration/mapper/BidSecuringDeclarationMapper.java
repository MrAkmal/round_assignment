package com.example.bidsecuringdeclaration.mapper;

import com.example.bidsecuringdeclaration.BidSecuringDeclaration;
import com.example.bidsecuringdeclaration.dto.BidSecuringDeclarationCreateDTO;
import com.example.bidsecuringdeclaration.dto.BidSecuringDeclarationDTO;
import org.springframework.stereotype.Component;

import java.time.LocalDateTime;

@Component
public class BidSecuringDeclarationMapper {


    public BidSecuringDeclaration fromCreateDTO(BidSecuringDeclarationCreateDTO dto) {

        return BidSecuringDeclaration.builder()
                .bidderId(dto.getBidderId())
                .tenderId(dto.getTenderId())
                .declarationStatus(dto.getDeclarationStatus())
                .declarationTime(LocalDateTime.now())
                .build();

    }


    public BidSecuringDeclarationDTO toDTO(BidSecuringDeclaration bidSecuringDeclaration) {

        return BidSecuringDeclarationDTO.builder()
                .id(bidSecuringDeclaration.getId())
                .bidderId(bidSecuringDeclaration.getBidderId())
                .tenderId(bidSecuringDeclaration.getTenderId())
                .declarationStatus(bidSecuringDeclaration.getDeclarationStatus())
                .declarationTime(bidSecuringDeclaration.getDeclarationTime())
                .build();
    }
}
