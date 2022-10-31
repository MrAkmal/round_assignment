package com.example.round.two;

import com.example.tenderitem.TenderItem;
import com.example.tenderitem.TenderItemService;
import com.example.tenderitem.dto.TenderItemDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class RoundTwoRateService {


    private final RoundTwoRateRepository repository;

    private final TenderItemService tenderItemService;

    @Autowired
    public RoundTwoRateService(RoundTwoRateRepository repository, TenderItemService tenderItemService) {
        this.repository = repository;
        this.tenderItemService = tenderItemService;
    }

    public void create(RoundTwo roundOne) {

        List<TenderItemDTO> tenderItems = tenderItemService.getAllTenderItems(roundOne.getTenderId());

        List<RoundTwoRate> roundOneRates = fromTenderItemsList(tenderItems, roundOne);

        repository.saveAll(roundOneRates);

    }


    private List<RoundTwoRate> fromTenderItemsList(List<TenderItemDTO> tenderItemsDTO, RoundTwo roundOne) {


        return fromDTO(tenderItemsDTO).stream().map(tenderItem -> {
            return RoundTwoRate.builder()
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
