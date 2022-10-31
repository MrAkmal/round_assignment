package com.example.tenderitem.dto;

import lombok.*;
import org.hibernate.validator.constraints.Range;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

@AllArgsConstructor
@NoArgsConstructor
@Setter
@Getter
@Builder
public class TenderItemCreateDTO {

    @NotBlank(message = "name required")
    private String name;

    @NotBlank(message = "description required")
    private String description;

    @NotNull(message= "quantity may not be empty")
    @Range(min = 1)
    private Integer quantity;

    @NotNull(message= "tenderId may not be empty")
    @Range(min = 1)
    private Integer tenderId;

}
