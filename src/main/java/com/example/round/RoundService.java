package com.example.round;

import com.example.payload.ResponseDTO;
import com.example.round.dto.RoundCreateDTO;
import com.example.round.dto.RoundDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;
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
            round.setBidderId(dto.getBidderId());
            repository.save(round);
        }

        return round;

    }


    private Round fromCreateDTO(RoundCreateDTO dto) {

        return Round.builder()
                .tenderId(dto.getTenderId())
                .createdDate(LocalDateTime.now())
                .lowestTotalRate(dto.getLowestTotalRate())
                .roundFinishStatus(dto.getRoundFinishStatus())
                .roundNumber(dto.getRoundNumber())
                .bidderId(dto.getBidderId())
                .build();
    }


    public ResponseEntity<ResponseDTO<List<RoundDTO>>> getAllByTenderIdAndRoundNumber(Integer tenderId, Integer roundNumber) {

        List<Round> rounds = repository.findRoundsByTenderIdAndRoundNumber(tenderId, roundNumber);

        List<RoundDTO> roundDTOS = rounds.stream().map(round -> {
            return RoundDTO.builder()
                    .id(round.getId())
                    .tenderId(round.getTenderId())
                    .createdDate(round.getCreatedDate())
                    .lowestTotalRate(round.getLowestTotalRate())
                    .roundFinishStatus(round.getRoundFinishStatus())
                    .roundNumber(round.getRoundNumber())
                    .bidderId(round.getBidderId())
                    .build();
        }).toList();

        return new ResponseEntity<>(new ResponseDTO<>(roundDTOS, "Success", HttpStatus.OK.value()), HttpStatus.OK);
    }
}
