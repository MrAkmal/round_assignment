package com.example.round;

import com.example.round.dto.RoundCreateDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.persistence.Column;
import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.Optional;

@Service
public class RoundService {


    private final RoundRepository repository;

    @Autowired
    public RoundService(RoundRepository repository) {
        this.repository = repository;
    }

    public Round checkAndSave(RoundCreateDTO dto) {

        Optional<Round> optionalRound = repository.findByTenderIdAndRoundNumber(dto.getTenderId(), dto.getRoundNumber());

        if (optionalRound.isEmpty()) return repository.save(fromCreateDTO(dto));

        Round round = optionalRound.get();

        if (dto.getLowestTotalRate().compareTo(round.getLowestTotalRate()) < 0) {
            round.setLowestTotalRate(dto.getLowestTotalRate());
            repository.save(round);
        }

        return round;

    }


    private Round fromCreateDTO(RoundCreateDTO dto) {

        return Round.builder()
                .tenderId(dto.getTenderId())
                .createdDate(dto.getCreatedDate())
                .lowestTotalRate(dto.getLowestTotalRate())
                .roundFinishStatus(dto.getRoundFinishStatus())
                .roundNumber(dto.getRoundNumber())
                .bidderId(dto.getBidderId())
                .build();
    }


}
