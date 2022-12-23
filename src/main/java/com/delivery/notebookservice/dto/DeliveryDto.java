package com.delivery.notebookservice.dto;

import com.delivery.notebookservice.entity.Cargo;
import com.delivery.notebookservice.entity.StatusOfDelivery;
import com.delivery.notebookservice.entity.Transporter;
import com.delivery.notebookservice.entity.Warehouse;
import lombok.Data;


@Data
public class DeliveryDto {
    private Long id;
    private WarehouseDto warehouseFrom;
    private WarehouseDto warehouseTo;
    private TransporterDto transporter;
    private CargoDto cargo;
    private StatusOfDelivery statusOfDelivery;
}
