package com.example.tenderitem.mapper;

import com.example.tenderitem.TenderItem;
import com.example.tenderitem.dto.TenderItemCreateDTO;
import com.example.tenderitem.dto.TenderItemDTO;
import org.springframework.stereotype.Component;

@Component
public class TenderItemMapper {

    public TenderItemDTO toDTO(TenderItem tenderItem) {

        return TenderItemDTO.builder()
                .id(tenderItem.getId())
                .tenderId(tenderItem.getTenderId())
                .description(tenderItem.getDescription())
                .name(tenderItem.getName())
                .quantity(tenderItem.getQuantity())
                .build();
    }

    public TenderItem fromCreateDTO(TenderItemCreateDTO dto) {

        return TenderItem.builder()
                .tenderId(dto.getTenderId())
                .description(dto.getDescription())
                .name(dto.getName())
                .quantity(dto.getQuantity())
                .build();
    }
}
