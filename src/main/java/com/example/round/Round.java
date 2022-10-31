package com.example.round;


import lombok.*;

import javax.persistence.*;
import java.math.BigDecimal;
import java.time.LocalDateTime;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
@Entity
@Table(name = "round")
public class Round {


    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;


    @Column(nullable = false)
    private int tenderId;

    @Column(nullable = false)
    private LocalDateTime createdDate;

    @Column(nullable = false)
    private BigDecimal lowestTotalRate;

    @Column(nullable = false,columnDefinition = "BIT")
    private Boolean roundFinishStatus;

    @Column(nullable = false)
    private int roundNumber;

    @Column(nullable = false)
    private int bidderId;

}
