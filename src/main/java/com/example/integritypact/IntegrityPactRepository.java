package com.example.integritypact;

import com.example.integritypact.dto.IntegrityPactDTO;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;
import java.util.Optional;

public interface IntegrityPactRepository extends JpaRepository<IntegrityPact, Integer> {


    @Query("select " +
            "new com.example.integritypact.dto.IntegrityPactDTO(" +
            "ip.id,ip.bidderId,ip.tenderId,ip.declarationStatus,ip.declarationTime" +
            ") " +
            "from IntegrityPact ip where ip.tenderId= :tenderId and ip.bidderId= :bidderId ")
    List<IntegrityPactDTO> getIntegrityPactByTenderIdAndBidderId(Integer tenderId, Integer bidderId);


    Optional<IntegrityPact> findByTenderIdAndBidderId(Integer tenderId, Integer bidderId);


    @Query("select " +
            "new com.example.integritypact.dto.IntegrityPactDTO(" +
            "ip.id,ip.bidderId,ip.tenderId,ip.declarationStatus,ip.declarationTime" +
            ") " +
            "from IntegrityPact ip ")
    List<IntegrityPactDTO> getAll();
}
