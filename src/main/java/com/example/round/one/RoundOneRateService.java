package com.example.round.one;

import com.example.round.dto.RoundOneRateCreateDTO;
import com.example.tenderitem.TenderItemService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class RoundOneRateService {


    private final RoundOneRateRepository repository;

    private final TenderItemService tenderItemService;


    @Autowired
    public RoundOneRateService(RoundOneRateRepository repository, TenderItemService tenderItemService) {
        this.repository = repository;
        this.tenderItemService = tenderItemService;
    }

    public void create(List<RoundOneRateCreateDTO> roundOneRateCreateDTOS, RoundOne roundOne) {


        List<RoundOneRate> roundOneRates = roundOneRateCreateDTOS.stream().map(dto -> RoundOneRate.builder()
                .quantity(dto.getQuantity())
                .rate(dto.getRate())
                .userId(dto.getUserId())
                .roundOne(roundOne)
                .tenderItem(dto.getTenderItem())
                .build()).toList();

        repository.saveAll(roundOneRates);

    }

}
