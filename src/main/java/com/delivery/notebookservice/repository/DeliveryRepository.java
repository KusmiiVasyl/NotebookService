package com.delivery.notebookservice.repository;

import com.delivery.notebookservice.entity.Delivery;
import com.delivery.notebookservice.entity.enums.DeliveryStatus;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;


@Repository
public interface DeliveryRepository extends JpaRepository<Delivery, Long> {
    @Query(value = "SELECT d FROM Delivery d WHERE " +
            ":id = d.id " +
            "OR " +
            ":warehouseFromId = d.warehouseFrom.id " +
            "OR " +
            "lower(d.warehouseFrom.title) LIKE concat('%', lower(:warehouseFromTitle), '%') " +
            "OR " +
            "lower(d.warehouseFrom.address.city) LIKE concat(lower(:deliveryFromCity), '%') " +
            "OR " +
            ":warehouseToId = d.warehouseTo.id " +
            "OR " +
            "lower(d.warehouseTo.title) LIKE concat('%', lower(:warehouseToTitle), '%') " +
            "OR " +
            "lower(d.warehouseTo.address.city) LIKE concat(lower(:deliveryToCity), '%') " +
            "OR " +
            ":transporterId = d.transporter.id " +
            "OR " +
            ":cargoId = d.cargo.id " +
            "OR " +
            ":deliveryStatus = d.deliveryStatus " +
            "OR " +
            ":id IS null AND " +
            ":warehouseFromId IS null AND " +
            ":warehouseFromTitle IS null AND " +
            ":deliveryFromCity IS null AND " +
            ":warehouseToId IS null AND " +
            ":warehouseToTitle IS null AND " +
            ":deliveryToCity IS null AND " +
            ":transporterId IS null AND " +
            ":cargoId IS null AND " +
            ":deliveryStatus IS null")
    Page<Delivery> findAllBy(Long id,
                             Long warehouseFromId,
                             String warehouseFromTitle,
                             String deliveryFromCity,
                             Long warehouseToId,
                             String warehouseToTitle,
                             String deliveryToCity,
                             Long transporterId,
                             Long cargoId,
                             DeliveryStatus deliveryStatus,
                             Pageable pageable);
}
