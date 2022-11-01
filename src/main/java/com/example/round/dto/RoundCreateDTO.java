package com.example.round.dto;

import lombok.*;

import javax.validation.constraints.NotNull;
import java.math.BigDecimal;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class RoundCreateDTO {


    @NotNull
    private int tenderId;


    private BigDecimal lowestTotalRate;

    private Boolean roundFinishStatus;

    @NotNull
    private int roundNumber;

    @NotNull
    private int bidderId;


}
