package com.example.bidsecuringdeclaration;


import lombok.*;

import javax.persistence.*;
import java.time.LocalDateTime;

@AllArgsConstructor
@NoArgsConstructor
@Setter
@Getter
@Builder
@Entity
@Table(name = "bud_securing_declaration")
public class BidSecuringDeclaration {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    private Integer bidderId;

    private Integer tenderId;

    @Column(columnDefinition = "BIT")
    private Boolean declarationStatus;

    private LocalDateTime declarationTime;

}
