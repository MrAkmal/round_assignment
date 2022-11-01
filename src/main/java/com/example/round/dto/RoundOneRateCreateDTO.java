package com.example.round.dto;

import com.example.round.one.RoundOne;
import com.example.tenderitem.TenderItem;
import lombok.*;

import javax.validation.constraints.NotNull;
import java.math.BigDecimal;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class RoundOneRateCreateDTO {


    @NotNull
    private int quantity;

    @NotNull
    private BigDecimal rate;

    @NotNull
    private int userId;

    @NotNull
    private int tenderItemId;

}
