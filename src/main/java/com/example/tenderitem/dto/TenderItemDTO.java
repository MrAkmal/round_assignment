package com.example.tenderitem.dto;

import lombok.*;

@AllArgsConstructor
@NoArgsConstructor
@Setter
@Getter
@Builder
public class TenderItemDTO {

    private Integer id;


    private String name;

    private String description;

    private Integer quantity;

    private Integer tenderId;
}
