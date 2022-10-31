package com.example.integritypact;

import lombok.*;

import javax.persistence.*;
import java.time.LocalDateTime;

@AllArgsConstructor
@NoArgsConstructor
@Setter
@Getter
@Builder
@Entity
@Table(name = "integrity_pact")
public class IntegrityPact {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    private Integer bidderId;

    private Integer tenderId;

    @Column(columnDefinition = "BIT")
    private Boolean declarationStatus;

    private LocalDateTime declarationTime;
}
