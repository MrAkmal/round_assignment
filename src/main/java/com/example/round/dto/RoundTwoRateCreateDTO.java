package com.example.round.dto;

import com.example.round.two.RoundTwo;
import com.example.tenderitem.TenderItem;
import lombok.*;

import java.math.BigDecimal;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class RoundTwoRateCreateDTO {


    private int quantity;

    private BigDecimal rate;

    private int userId;

    private RoundTwo roundOne;

    private TenderItem tenderItem;
}
