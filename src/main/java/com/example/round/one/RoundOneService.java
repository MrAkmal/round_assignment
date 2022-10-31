package com.example.round.one;

import com.example.payload.ResponseDTO;
import com.example.round.Round;
import com.example.round.RoundService;
import com.example.round.dto.RoundCreateDTO;
import com.example.round.dto.RoundOneCreateDTO;
import com.example.round.dto.RoundOneDTO;
import com.example.tenderitem.TenderItemService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

@Service
public class RoundOneService {


    private final RoundOneRepository repository;

    private final RoundService roundService;

    private final TenderItemService tenderItemService;

    @Autowired
    public RoundOneService(RoundOneRepository repository, RoundService roundService, TenderItemService tenderItemService) {
        this.repository = repository;
        this.roundService = roundService;
        this.tenderItemService = tenderItemService;
    }

    public ResponseEntity<ResponseDTO<RoundOneDTO>> create(RoundOneCreateDTO dto) {

        Round round = roundService.checkAndSave(new RoundCreateDTO(dto.getTenderId(), dto.getSubmissionDateTime(), dto.getTotalRate(), false, 1, dto.getUserId()));

        RoundOne roundOne = repository.save(fromCreateDTO(dto, round));

        tenderItemService.create();


        return new ResponseEntity<>(new ResponseDTO<>(toDTO(roundOne), "Success", HttpStatus.CREATED.value()), HttpStatus.OK);

    }

    private RoundOneDTO toDTO(RoundOne roundOne) {
        return RoundOneDTO.builder()
                .submissionDateTime(roundOne.getSubmissionDateTime())
                .totalRate(roundOne.getTotalRate())
                .tenderId(roundOne.getTenderId())
                .userId(roundOne.getUserId())
                .round(roundOne.getRound())
                .build();
    }


    private RoundOne fromCreateDTO(RoundOneCreateDTO dto, Round round) {

        return RoundOne.builder()
                .submissionDateTime(dto.getSubmissionDateTime())
                .totalRate(dto.getTotalRate())
                .tenderId(dto.getTenderId())
                .userId(dto.getUserId())
                .round(round)
                .build();
    }

}
