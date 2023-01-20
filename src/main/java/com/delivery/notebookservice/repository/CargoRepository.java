package com.delivery.notebookservice.repository;

import com.delivery.notebookservice.entity.Cargo;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;


@Repository
public interface CargoRepository extends JpaRepository<Cargo, Long> {
    @Query("""
            SELECT c FROM Cargo c WHERE 
            (:id = c.id OR :id IS null) AND
            (lower(c.name) LIKE concat(lower(:name), '%') OR :name IS null) AND 
            (c.amount >= :amountRangeStart AND c.amount <= :amountRangeEnd OR 
            :amountRangeStart IS null AND 
            :amountRangeEnd IS null)""")
    Page<Cargo> findAllBy(Long id, String name, Double amountRangeStart, Double amountRangeEnd, Pageable pageable);
}
