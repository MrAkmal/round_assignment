package com.example.integritypact.dto;


import lombok.*;

import java.time.LocalDateTime;

@AllArgsConstructor
@NoArgsConstructor
@Setter
@Getter
@Builder
public class IntegrityPactDTO {

    private Integer id;

    private Integer bidderId;

    private Integer tenderId;

    private Boolean declarationStatus;

    private LocalDateTime declarationTime;

}
