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
    @Query(value = """
             SELECT d FROM Delivery d WHERE
            (:id = d.id OR :id IS null) AND
            (:warehouseFromId = d.warehouseFrom.id OR :warehouseFromId IS null) AND
            (lower(d.warehouseFrom.title) LIKE concat('%', lower(:warehouseFromTitle),'%') OR :warehouseFromTitle IS null) AND
            (lower(d.warehouseFrom.address.city) LIKE concat(lower(:deliveryFromCity), '%') OR :deliveryFromCity IS null) AND
            (:warehouseToId = d.warehouseTo.id OR :warehouseToId IS null) AND
            (lower(d.warehouseTo.title) LIKE concat('%', lower(:warehouseToTitle), '%') OR :warehouseToTitle IS null) AND
            (lower(d.warehouseTo.address.city) LIKE concat(lower(:deliveryToCity), '%') OR :deliveryToCity IS null) AND
            (:transporterId = d.transporter.id OR :transporterId IS null) AND
            (lower(d.cargo.name) LIKE concat('%', lower(:cargoName),'%') OR :cargoName IS null) AND
            (:deliveryStatus = d.deliveryStatus OR :deliveryStatus IS null)""")
    Page<Delivery> findAllBy(Long id,
                             Long warehouseFromId,
                             String warehouseFromTitle,
                             String deliveryFromCity,
                             Long warehouseToId,
                             String warehouseToTitle,
                             String deliveryToCity,
                             Long transporterId,
                             String cargoName,
                             DeliveryStatus deliveryStatus,
                             Pageable pageable);
}


