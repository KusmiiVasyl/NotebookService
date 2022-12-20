package com.delivery.notebookservice.repository;

import com.delivery.notebookservice.entity.Transporter;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;


@Repository
public interface TransporterRepository extends JpaRepository<Transporter, Long> {
}
