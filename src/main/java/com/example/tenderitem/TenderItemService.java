package com.example.tenderitem;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class TenderItemService {

    private final TenderItemRepository tenderItemRepository;

    @Autowired
    public TenderItemService(TenderItemRepository tenderItemRepository) {
        this.tenderItemRepository = tenderItemRepository;
    }
}
