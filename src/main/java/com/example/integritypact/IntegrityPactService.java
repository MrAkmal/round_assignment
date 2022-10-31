package com.example.integritypact;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class IntegrityPactService {

    private final IntegrityPactRepository integrityPactRepository;

    @Autowired
    public IntegrityPactService(IntegrityPactRepository integrityPactRepository) {
        this.integrityPactRepository = integrityPactRepository;
    }
}
