package com.example.round.dto;

import com.example.round.one.RoundOne;
import com.example.tenderitem.TenderItem;
import lombok.*;

import java.math.BigDecimal;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class RoundOneRateCreateDTO {


    private int quantity;

    private BigDecimal rate;

    private int userId;

    private RoundOne roundOne;

    private TenderItem tenderItem;
}
