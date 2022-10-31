package com.example.round.dto;

import lombok.*;

import java.math.BigDecimal;
import java.time.LocalDateTime;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class RoundDTO {

    private Integer id;

    private int tenderId;

    private LocalDateTime createdDate;

    private BigDecimal lowestTotalRate;

    private Boolean roundFinishStatus;

    private int roundNumber;

    private int bidderId;

}
