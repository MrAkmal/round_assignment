package com.example.round.dto;

import lombok.*;

import java.math.BigDecimal;
import java.time.LocalDateTime;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class RoundTwoCreateDTO {

    private LocalDateTime submissionDateTime;

    private BigDecimal totalRate;

    private int tenderId;

    private int userId;

}
