package com.example.round.two;

import com.example.payload.ResponseDTO;
import com.example.round.Round;
import com.example.round.RoundService;
import com.example.round.dto.RoundCreateDTO;
import com.example.round.dto.RoundTwoCreateDTO;
import com.example.round.dto.RoundTwoDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;

@Service
public class RoundTwoService {


    private final RoundTwoRepository repository;

    private final RoundService roundService;

    private final RoundTwoRateService roundTwoRateService;


    @Autowired
    public RoundTwoService(RoundTwoRepository repository, RoundService roundService, RoundTwoRateService roundTwoRateService) {
        this.repository = repository;
        this.roundService = roundService;
        this.roundTwoRateService = roundTwoRateService;
    }

    public ResponseEntity<ResponseDTO<RoundTwoDTO>> create(RoundTwoCreateDTO dto) {

        Round round = roundService.checkAndSave(new RoundCreateDTO(dto.getTenderId(), dto.getTotalRate(), false, 2, dto.getUserId()));

        RoundTwo roundTwo = repository.save(fromCreateDTO(dto, round));

        roundTwoRateService.create(dto.getRoundTwoRateCreateDTOS(), roundTwo);

        return new ResponseEntity<>(new ResponseDTO<>(toDTO(roundTwo), "Success", HttpStatus.CREATED.value()), HttpStatus.OK);

    }

    private RoundTwoDTO toDTO(RoundTwo roundTwo) {
        return RoundTwoDTO.builder()
                .submissionDateTime(roundTwo.getSubmissionDateTime())
                .totalRate(roundTwo.getTotalRate())
                .tenderId(roundTwo.getTenderId())
                .userId(roundTwo.getUserId())
                .round(roundTwo.getRound())
                .build();
    }


    private RoundTwo fromCreateDTO(RoundTwoCreateDTO dto, Round round) {

        return RoundTwo.builder()
                .submissionDateTime(LocalDateTime.now())
                .totalRate(dto.getTotalRate())
                .tenderId(dto.getTenderId())
                .userId(dto.getUserId())
                .round(round)
                .build();
    }

}
