package com.example.round.one;

import com.example.round.dto.RoundOneRateCreateDTO;
import com.example.tenderitem.TenderItem;
import com.example.tenderitem.TenderItemService;
import com.example.tenderitem.dto.TenderItemDTO;
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

    public void create(RoundOne roundOne) {

        List<TenderItemDTO> tenderItems = tenderItemService.getAllTenderItems(roundOne.getTenderId());

        

        List<RoundOneRate> roundOneRates = fromTenderItemsList(tenderItems, roundOne);

        repository.saveAll(roundOneRates);

    }


    private List<RoundOneRate> fromTenderItemsList(List<TenderItemDTO> tenderItemsDTO, RoundOne roundOne) {


        return fromDTO(tenderItemsDTO).stream().map(tenderItem -> {
            return RoundOneRate.builder()
                    .quantity(tenderItem.getQuantity())
                    .rate(roundOne.getTotalRate())
                    .userId(roundOne.getUserId())
                    .roundOne(roundOne)
                    .tenderItem(tenderItem)
                    .build();
        }).toList();


    }


    private List<TenderItem> fromDTO(List<TenderItemDTO> tenderItemDTOS) {

        return tenderItemDTOS.stream().map(dto -> TenderItem.builder()
                .name(dto.getName())
                .description(dto.getDescription())
                .quantity(dto.getQuantity())
                .tenderId(dto.getTenderId())
                .build()).toList();

    }


}
