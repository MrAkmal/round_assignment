package com.example.integritypact.dto;

import lombok.*;
import org.hibernate.validator.constraints.Range;

import javax.validation.constraints.NotNull;

@AllArgsConstructor
@NoArgsConstructor
@Setter
@Getter
@Builder
public class IntegrityPactCreateDTO {

    @NotNull(message= "bidderId may not be empty")
    @Range(min = 1)
    private Integer bidderId;

    @NotNull(message= "tenderId may not be empty")
    @Range(min = 1)
    private Integer tenderId;

    private Boolean declarationStatus;

}
