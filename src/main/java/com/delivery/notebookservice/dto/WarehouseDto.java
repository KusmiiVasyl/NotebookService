package com.delivery.notebookservice.dto;

import lombok.Data;


@Data
public class WarehouseDto extends AddressDto {
    private Long id;
    private String title;
}
