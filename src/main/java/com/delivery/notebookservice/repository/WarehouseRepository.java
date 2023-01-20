package com.delivery.notebookservice.repository;

import com.delivery.notebookservice.entity.Warehouse;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;


@Repository
public interface WarehouseRepository extends JpaRepository<Warehouse, Long> {
    @Query("""
            SELECT w FROM Warehouse w WHERE 
            (:id = w.id OR :id IS null) AND
            (lower(w.title) LIKE concat('%', lower(:title), '%') OR :title IS null) AND
            (:addressId = w.address.id OR :addressId IS null) AND
            (lower(w.address.city) LIKE concat(lower(:city), '%') OR :city IS null) AND 
            (lower(w.address.street) LIKE concat(lower(:street), '%') OR :street IS null)""")
    Page<Warehouse> findAllBy(Long id, String title, Long addressId, String city, String street, Pageable pageable);
}
