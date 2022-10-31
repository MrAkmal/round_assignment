package com.example.bidsecuringdeclaration;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class BidSecuringDeclarationService {

    private final BidSecuringDeclarationRepository bidSecuringDeclarationRepository;

    @Autowired
    public BidSecuringDeclarationService(BidSecuringDeclarationRepository bidSecuringDeclarationRepository) {
        this.bidSecuringDeclarationRepository = bidSecuringDeclarationRepository;
    }
}
