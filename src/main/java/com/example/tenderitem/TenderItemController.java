package com.example.tenderitem;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/v1/tender_items")
public class TenderItemController {

    private final TenderItemService tenderItemService;

    @Autowired
    public TenderItemController(TenderItemService tenderItemService) {
        this.tenderItemService = tenderItemService;
    }

}
