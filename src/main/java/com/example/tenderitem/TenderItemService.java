package com.example.tenderitem;

import com.example.payload.ResponseDTO;
import com.example.tenderitem.dto.TenderItemCreateDTO;
import com.example.tenderitem.dto.TenderItemDTO;
import com.example.tenderitem.mapper.TenderItemMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class TenderItemService {

    private final TenderItemRepository repository;
    private final TenderItemMapper mapper;

    @Autowired
    public TenderItemService(TenderItemRepository repository, TenderItemMapper mapper) {
        this.repository = repository;
        this.mapper = mapper;
    }


    public ResponseEntity<ResponseDTO<List<TenderItemDTO>>> getAllTenderItemsByTenderId(Integer tenderId) {

        return new ResponseEntity<>(new ResponseDTO<>(getAllTenderItems(tenderId), "success", 200), HttpStatus.OK);
    }

    public List<TenderItemDTO> getAllTenderItems(Integer tenderId){
        return repository.getAllTenderItemsByTenderId(tenderId);
    }


    public ResponseEntity<ResponseDTO<TenderItemDTO>> create(TenderItemCreateDTO dto) {

        Optional<TenderItem> optionalTenderItem = repository.findByTenderIdAndNameAndDescription(dto.getTenderId(), dto.getName(), dto.getDescription());

        if (optionalTenderItem.isPresent()) throw new RuntimeException("TenderItem already exist");

        TenderItem tenderItem = repository.save(mapper.fromCreateDTO(dto));

        return new ResponseEntity<>(new ResponseDTO<>(mapper.toDTO(tenderItem), "successfully created", 201), HttpStatus.CREATED);
    }





}
