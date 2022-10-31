package com.example.round;

import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.Optional;

public interface RoundRepository extends JpaRepository<Round,Integer> {


    Optional<Round> findByTenderIdAndRoundNumber(int tenderId, int roundNumber);


    List<Round> findRoundsByTenderIdAndRoundNumber(int tenderId,int roundNumber);

}
