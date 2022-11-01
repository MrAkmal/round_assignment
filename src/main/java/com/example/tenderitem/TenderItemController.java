package com.example.tenderitem;

import com.example.payload.ResponseDTO;
import com.example.tenderitem.dto.TenderItemCreateDTO;
import com.example.tenderitem.dto.TenderItemDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RestController
@RequestMapping("/api/v1/tender_items")
public class TenderItemController {

    private final TenderItemService service;


    @Autowired
    public TenderItemController(TenderItemService service) {
        this.service = service;
    }


    @GetMapping
    public ResponseEntity<ResponseDTO<List<TenderItemDTO>>> getAllTenderItems() {
        return service.getAll();
    }


    @GetMapping("/{tenderId}")
    public ResponseEntity<ResponseDTO<List<TenderItemDTO>>> getAllTenderItemsByTenderId(@PathVariable Integer tenderId) {
        return service.getAllTenderItemsByTenderId(tenderId);
    }


    @PostMapping
    public ResponseEntity<ResponseDTO<Void>> create(@Valid @RequestBody List<TenderItemCreateDTO> dto) {
        return service.create(dto);
    }

}
