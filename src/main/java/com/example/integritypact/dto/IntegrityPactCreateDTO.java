package com.example.integritypact.dto;

import lombok.*;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import java.time.LocalDateTime;

@AllArgsConstructor
@NoArgsConstructor
@Setter
@Getter
@Builder
public class IntegrityPactCreateDTO {

    @NotNull
    private Integer bidderId;

    @NotNull
    private Integer tenderId;

    private Boolean declarationStatus;

    @NotBlank
    private LocalDateTime declarationTime;

}
