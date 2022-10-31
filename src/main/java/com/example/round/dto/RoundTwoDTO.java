package com.example.round.dto;

import com.example.round.Round;
import lombok.*;

import java.math.BigDecimal;
import java.time.LocalDateTime;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class RoundTwoDTO {


    private LocalDateTime submissionDateTime;

    private BigDecimal totalRate;

    private int tenderId;

    private int userId;

    private Round round;
}

