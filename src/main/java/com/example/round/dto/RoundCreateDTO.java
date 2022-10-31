package com.example.round.dto;

import lombok.*;

import javax.validation.constraints.NotNull;
import java.math.BigDecimal;
import java.time.LocalDateTime;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class RoundCreateDTO {


    @NotNull
    private int tenderId;

    private LocalDateTime createdDate;

    private BigDecimal lowestTotalRate;

    private Boolean roundFinishStatus;

    @NotNull
    private int roundNumber;

    @NotNull
    private int bidderId;


}
