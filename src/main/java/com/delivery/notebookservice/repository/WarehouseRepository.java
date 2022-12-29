package com.delivery.notebookservice.repository;

import com.delivery.notebookservice.entity.Warehouse;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;


@Repository
public interface WarehouseRepository extends JpaRepository<Warehouse, Long> {
    @Query("SELECT w FROM Warehouse w WHERE " +
            ":id = w.id " +
            "OR " +
            "lower(w.title) LIKE concat('%', lower(:title), '%') " +
            "OR " +
            ":addressId = w.address.id " +
            "OR " +
            "lower(w.address.city) LIKE concat(lower(:city), '%') " +
            "OR " +
            "lower(w.address.street) LIKE concat(lower(:street), '%') " +
            "OR " +
            ":id IS null AND " +
            ":title IS null AND " +
            ":addressId IS null AND " +
            ":city IS null AND " +
            ":street IS null")
    Page<Warehouse> findAllBy(Long id, String title, Long addressId, String city, String street, Pageable pageable);
}
