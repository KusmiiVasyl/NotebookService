package com.delivery.notebookservice.repository;

import com.delivery.notebookservice.entity.Delivery;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;


@Repository
public interface DeliveryRepository extends JpaRepository<Delivery, Long> {
}
