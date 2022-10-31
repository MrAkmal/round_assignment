package com.example.round.two;

import com.example.round.Round;
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
@Table(name = "round_two")
public class RoundTwo {


    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;


    @Column(nullable = false)
    private LocalDateTime submissionDateTime;

    @Column(nullable = false)
    private BigDecimal totalRate;


    @Column(nullable = false)
    private int tenderId;

    @Column(nullable = false)
    private int userId;

    @ManyToOne(cascade = {CascadeType.DETACH,CascadeType.MERGE,CascadeType.PERSIST,CascadeType.REFRESH})
    private Round round;

}
