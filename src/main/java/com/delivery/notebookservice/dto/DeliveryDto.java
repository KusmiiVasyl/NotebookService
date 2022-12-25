package com.delivery.notebookservice.dto;

import com.delivery.notebookservice.entity.enums.DeliveryStatus;
import lombok.Data;


@Data
public class DeliveryDto {
    private Long warehouseFromId;
    private Long warehouseToId;
    private Long transporterId;
    private Long cargoId;
    private DeliveryStatus deliveryStatus;
}
