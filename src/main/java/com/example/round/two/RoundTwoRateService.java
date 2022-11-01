package com.example.round.two;

import com.example.round.dto.RoundTwoRateCreateDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class RoundTwoRateService {


    private final RoundTwoRateRepository repository;


    @Autowired
    public RoundTwoRateService(RoundTwoRateRepository repository) {
        this.repository = repository;
    }

    public void create(List<RoundTwoRateCreateDTO> roundTwoRateCreateDTOS, RoundTwo roundOne) {

        List<RoundTwoRate> roundOneRates = roundTwoRateCreateDTOS.stream().map(dto -> RoundTwoRate.builder()
                .quantity(dto.getQuantity())
                .rate(dto.getRate())
                .userId(dto.getUserId())
                .roundOne(roundOne)
                .tenderItem(dto.getTenderItem())
                .build()).toList();

        repository.saveAll(roundOneRates);

    }


}
