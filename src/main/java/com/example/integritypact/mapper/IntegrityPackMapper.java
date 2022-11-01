package com.example.integritypact.mapper;

import com.example.integritypact.IntegrityPact;
import com.example.integritypact.dto.IntegrityPactCreateDTO;
import com.example.integritypact.dto.IntegrityPactDTO;
import org.springframework.stereotype.Component;

import java.time.LocalDateTime;

@Component
public class IntegrityPackMapper {


    public IntegrityPact fromCreateDTO(IntegrityPactCreateDTO dto) {

        return IntegrityPact.builder()
                .bidderId(dto.getBidderId())
                .tenderId(dto.getTenderId())
                .declarationStatus(dto.getDeclarationStatus())
                .declarationTime(LocalDateTime.now())
                .build();
    }


    public IntegrityPactDTO toDTO(IntegrityPact integrityPact) {

        return IntegrityPactDTO.builder()
                .id(integrityPact.getId())
                .bidderId(integrityPact.getBidderId())
                .tenderId(integrityPact.getTenderId())
                .declarationStatus(integrityPact.getDeclarationStatus())
                .declarationTime(integrityPact.getDeclarationTime())
                .build();
    }

}
