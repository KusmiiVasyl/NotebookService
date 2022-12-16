package com.delivery.notebookservice.repository;

import com.delivery.notebookservice.entity.Cargo;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;


@Repository
public interface CargoRepository extends JpaRepository<Cargo, Long> {
}
