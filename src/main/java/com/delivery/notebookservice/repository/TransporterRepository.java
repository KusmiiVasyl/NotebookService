package com.delivery.notebookservice.repository;

import com.delivery.notebookservice.entity.Transporter;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;


@Repository
public interface TransporterRepository extends JpaRepository<Transporter, Long> {
    @Query(value = "SELECT t FROM Transporter t WHERE " +
            ":id = t.id " +
            "OR " +
            "lower(t.name) LIKE concat('%', lower(:name), '%') " +
            "OR " +
            "lower(t.carModel) LIKE concat('%', lower(:carModel), '%') " +
            "OR " +
            ":loadCapacity <= t.loadCapacity " +
            "OR " +
            ":id IS null AND " +
            ":name IS null AND " +
            ":carModel IS null AND " +
            ":loadCapacity IS null")
    Page<Transporter> findAllBy(Long id, String name, String carModel, Double loadCapacity, Pageable pageable);
}
