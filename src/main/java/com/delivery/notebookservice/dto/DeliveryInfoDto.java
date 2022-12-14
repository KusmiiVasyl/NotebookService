package com.delivery.notebookservice.dto;

import com.delivery.notebookservice.entity.enums.DeliveryStatus;
import lombok.Data;


@Data
public class DeliveryInfoDto {
    private Long id;
    private WarehouseDto warehouseFrom;
    private WarehouseDto warehouseTo;
    private TransporterDto transporter;
    private CargoDto cargo;
    private DeliveryStatus deliveryStatus;
}
