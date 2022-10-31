package com.example.bidsecuringdeclaration.dto;


import lombok.*;

import java.time.LocalDateTime;

@AllArgsConstructor
@NoArgsConstructor
@Setter
@Getter
@Builder
public class BidSecuringDeclarationDTO {

    private Integer id;

    private Integer bidderId;

    private Integer tenderId;

    private Boolean declarationStatus;

    private LocalDateTime declarationTime;

}
