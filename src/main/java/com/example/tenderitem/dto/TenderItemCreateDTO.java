package com.example.tenderitem.dto;

import lombok.*;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

@AllArgsConstructor
@NoArgsConstructor
@Setter
@Getter
@Builder
public class TenderItemCreateDTO {

    @NotBlank
    private String name;

    @NotBlank
    private String description;

    @NotNull
    private Integer quantity;

    @NotNull
    private Integer tenderId;

}
