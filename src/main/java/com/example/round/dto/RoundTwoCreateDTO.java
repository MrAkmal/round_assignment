package com.example.round.dto;

import lombok.*;

import javax.validation.constraints.NotNull;
import java.math.BigDecimal;
import java.util.List;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class RoundTwoCreateDTO {

    @NotNull
    private BigDecimal totalRate;


    @NotNull
    private int tenderId;

    @NotNull
    private int userId;

    private List<RoundTwoRateCreateDTO> roundTwoRateCreateDTOS;

}
