package com.example.bidsecuringdeclaration.dto;

import lombok.*;

import javax.validation.constraints.NotNull;
import java.time.LocalDateTime;

@AllArgsConstructor
@NoArgsConstructor
@Setter
@Getter
@Builder
public class BidSecuringDeclarationCreateDTO {

    @NotNull
    private Integer bidderId;

    @NotNull
    private Integer tenderId;

    private Boolean declarationStatus;

    @NotNull
    private LocalDateTime declarationTime;

}
