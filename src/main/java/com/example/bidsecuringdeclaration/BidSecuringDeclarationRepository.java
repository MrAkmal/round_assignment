package com.example.bidsecuringdeclaration;

import com.example.bidsecuringdeclaration.dto.BidSecuringDeclarationDTO;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;
import java.util.Optional;

public interface BidSecuringDeclarationRepository extends JpaRepository<BidSecuringDeclaration, Integer> {

    @Query("select " +
            "new com.example.bidsecuringdeclaration.dto.BidSecuringDeclarationDTO(" +
            "bsd.id,bsd.bidderId,bsd.tenderId,bsd.declarationStatus,bsd.declarationTime" +
            ") " +
            "from BidSecuringDeclaration bsd where bsd.tenderId= :tenderId and bsd.bidderId= :bidderId ")
    List<BidSecuringDeclarationDTO> getBidSecuringDeclarationByTenderIdAndBidderId(Integer tenderId, Integer bidderId);

    Optional<BidSecuringDeclaration> findByTenderIdAndBidderId(Integer tenderId, Integer bidderId);
}
