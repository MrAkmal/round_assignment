package com.example.tenderitem;

import com.example.tenderitem.dto.TenderItemDTO;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;
import java.util.Optional;

public interface TenderItemRepository extends JpaRepository<TenderItem, Integer> {

    @Query("select new com.example.tenderitem.dto.TenderItemDTO(ti.id,ti.name,ti.description,ti.quantity,ti.tenderId)" +
            " from TenderItem ti where ti.tenderId= :tenderId ")
    List<TenderItemDTO> getAllTenderItemsByTenderId(Integer tenderId);


    Optional<TenderItem> findByTenderIdAndNameAndDescription(Integer tenderId, String name, String description);

}
